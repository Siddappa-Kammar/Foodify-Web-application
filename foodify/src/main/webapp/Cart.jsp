<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Map"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Foodify - Cart</title>
    
    <link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/common.css">

	<link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/cart.css">
      
</head>

<body>

	<jsp:include page="/includes/navbar.jsp" />
	
    <div class="container">

        <h1 class="page-title">
            Your Cart
        </h1>


        <%

            Cart cart = (Cart) session.getAttribute("cart");

            if (cart == null || cart.getItems().isEmpty()) {

        %>


            <!-- EMPTY CART -->

            <div class="empty-cart">

                <h2>Your cart is empty</h2>

                <p>
                    Looks like you haven't added anything to your cart yet.
                </p>

                <a href="<%= request.getContextPath() %>/Restaurant" class="restaurant-btn">
                    Browse Restaurants
                </a>

            </div>


        <%

            } else {

                Map<Integer, CartItem> items = cart.getItems();

                double grandTotal = 0;

        %>


			<!-- BACK TO MENU BUTTON: Show only when cart has items -->
				
			<div class="back-menu-container">
			
			    <a class="back-menu-btn" href="<%= request.getContextPath() %>/MenuController?restaurantId=<%= cart.getRestId() %>">
			        ← Back to Menu
			    </a>
			</div>
			

            <div class="cart-wrapper">
      

                <!-- CART ITEMS -->

                <div class="cart-items">

                <%

                    for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {

                        CartItem cartItem = entry.getValue();

                        Menu menu = cartItem.getMenu();

                        double itemTotal =
                                menu.getPrice() * cartItem.getQuantity();

                        grandTotal = grandTotal + itemTotal;

                %>


                    <div class="cart-item">


                        <!-- IMAGE -->

                        <img
                            src="<%= menu.getImagePath() %>"
                            class="item-image"
                            alt="<%= menu.getItemName() %>"
                        >


                        <!-- DETAILS -->

                        <div class="item-details">

                            <div class="item-name">

                                <%= menu.getItemName() %>

                            </div>

                            <div class="item-price">

                                ₹ <%= menu.getPrice() %>

                            </div>


                            <!-- QUANTITY -->

                            <div class="quantity-box">

                                <a
                                    href="CartController?action=decrease&menuId=<%= menu.getMenuId() %>"
                                    class="quantity-btn"
                                >
                                    −
                                </a>

                                <span class="quantity">

                                    <%= cartItem.getQuantity() %>

                                </span>

                                <a
                                    href="CartController?action=increase&menuId=<%= menu.getMenuId() %>"
                                    class="quantity-btn"
                                >
                                    +
                                </a>

                                <a
                                    href="CartController?action=remove&menuId=<%= menu.getMenuId() %>"
                                    class="remove-btn"
                                >
                                    Remove
                                </a>

                            </div>

                        </div>


                        <!-- ITEM TOTAL -->

                        <div class="item-total">

                            ₹ <%= itemTotal %>

                        </div>


                    </div>


                <%

                    }

                %>

                </div>


                <!-- CART SUMMARY -->

                <div class="cart-summary">

                    <h2>
                        Bill Details
                    </h2>


                    <div class="summary-row">

                        <span>
                            Item Total
                        </span>

                        <span>
                            ₹ <%= grandTotal %>
                        </span>

                    </div>


                    <div class="summary-row">

                        <span>
                            Delivery Fee
                        </span>

                        <span>
                            ₹ 40
                        </span>

                    </div>


                    <div class="summary-row">

                        <span>
                            Taxes & Charges
                        </span>

                        <span>
                            ₹ 20
                        </span>

                    </div>


                    <div class="total-row">

                        <span>
                            To Pay
                        </span>

                        <span>
                            ₹ <%= grandTotal + 40 + 20 %>
                        </span>

                    </div>


                    <a
                        href="<%= request.getContextPath() %>/CheckoutController"
                        class="checkout-btn"
                    >
                        Proceed to Checkout
                    </a>

                </div>


            </div>


        <%

            }

        %>

    </div>

</body>

</html>