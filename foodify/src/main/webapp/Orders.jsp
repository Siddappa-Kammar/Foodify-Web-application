<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.OrderTable" %>
<%@ page import="java.util.Map, java.util.List, com.tap.model.OrderItem" %>
<%
    if (session.getAttribute("userId") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        return;
    }

    List<OrderTable> orders =
        (List<OrderTable>) request.getAttribute("orders");
%>

<%
    Map<Integer, List<OrderItem>> orderItemsMap =
        (Map<Integer, List<OrderItem>>) request.getAttribute("orderItemsMap");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Orders | Foodify</title>
    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/css/common.css">
    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/css/orders.css">
</head>
<body>

    <%@ include file="/includes/navbar.jsp" %>

    <main class="orders-container">
        <h1>My Orders</h1>
        <p class="subtitle">Track your Foodify orders and order history.</p>

        <% if (orders == null || orders.isEmpty()) { %>
            <div class="empty-orders">
                <h2>No orders yet!</h2>
                <p>Your delicious food journey starts here.</p>
                <a class="browse-btn"
                   href="<%= request.getContextPath() %>/RestaurantController">
                    Browse Restaurants
                </a>
            </div>
        <% } else { %>

            <div class="orders-list">
                <% for (OrderTable order : orders) { %>
                    <div class="order-card">

                        <div class="order-header">
                            <div>
                                <span class="order-label">Order ID</span>
                                <h3>#<%= order.getOrderId() %></h3>
                            </div>

                            <span class="status">
                                <%= order.getStatus() %>
                            </span>
                        </div>

                        <div class="order-details">
                            <p>
                                <strong>Restaurant ID:</strong>
                                <%= order.getRestId() %>
                            </p>

                            <p>
                                <strong>Order Date:</strong>
                                <%= order.getOrderDate() %>
                            </p>

                            <p>
                                <strong>Payment:</strong>
                                <%= order.getPaymentMethod() %>
                            </p>

                            <p class="order-total">
                                ₹<%= String.format("%.2f",
                                    order.getTotalAmount()) %>
                            </p>
                        </div>
                        
					                        
					<div class="ordered-items">
					    <h4>Items Ordered</h4>
					
					    <%
					        List<OrderItem> items =
					            orderItemsMap.get(order.getOrderId());
					
					        if (items != null && !items.isEmpty()) {
					            for (OrderItem item : items) {
					    %>
					
					        <div class="ordered-item">
					            <div class="food-info">
					                <% if (item.getImagePath() != null
					                        && !item.getImagePath().trim().isEmpty()) { %>
					
					                    
										<%
										    String imagePath = item.getImagePath();
										
										    if (imagePath != null && !imagePath.trim().isEmpty()) {
										        imagePath = imagePath.trim();
										
										        String imageUrl;
										
										        if (imagePath.startsWith("http://")
										                || imagePath.startsWith("https://")) {
										            imageUrl = imagePath;
										        } else if (imagePath.startsWith("/")) {
										            imageUrl = request.getContextPath() + imagePath;
										        } else {
										            imageUrl = request.getContextPath() + "/" + imagePath;
										        }
										%>
										
										    <img class="food-image"
										         src="<%= imageUrl %>"
										         alt="<%= item.getItemName() %>"
										         onerror="this.style.display='none';">
										
										<%
										    }
										%>

					
					                <% } %>
					
					                <div>
					                    <strong><%= item.getItemName() %></strong>
					                    <p>₹<%= String.format("%.2f", item.getUnitPrice()) %>
					                       × <%= item.getQuantity() %></p>
					                </div>
					            </div>
					
					            <strong class="item-subtotal">
					                ₹<%= String.format("%.2f", item.getItemTotal()) %>
					            </strong>
					        </div>
					
					    <%
					            }
					        } else {
					    %>
					        <p>No items found for this order.</p>
					    <%
					        }
					    %>
					</div>
                        

                    </div>
                <% } %>
            </div>

        <% } %>
    </main>

    <%@ include file="/includes/footer.jsp" %>

</body>
</html>
```