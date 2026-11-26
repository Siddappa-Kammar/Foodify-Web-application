<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.tap.model.Menu, com.tap.model.Cart, com.tap.model.CartItem"%>

<!DOCTYPE html>
<html>

<head>

<meta charset="UTF-8">

<title>Foodify - Menu</title>

	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/common.css">
	
	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/menu.css">
<%-- 
<!-- <style> -->

/* * { */
/*     margin: 0; */
/*     padding: 0; */
/*     box-sizing: border-box; */
/* } */

/* body { */
/*     font-family: Arial, Helvetica, sans-serif; */
/*     background-color: #f7f7f7; */
/*     color: #222; */
/* } */

/* /* NAVBAR */ */

/* .navbar { */
/*     height: 70px; */
/*     background-color: white; */
/*     display: flex; */
/*     align-items: center; */
/*     justify-content: space-between; */
/*     padding: 0 7%; */
/*     box-shadow: 0 2px 10px rgba(0,0,0,0.08); */
/*     position: sticky; */
/*     top: 0; */
/*     z-index: 100; */
/* } */

/* .logo { */
/*     font-size: 30px; */
/*     font-weight: bold; */
/*     color: #fc4a1a; */
/*     letter-spacing: 1px; */
/* } */

/* .nav-links { */
/*     display: flex; */
/*     align-items: center; */
/*     gap: 30px; */
/* } */

/* .nav-links a { */
/*     text-decoration: none; */
/*     color: #333; */
/*     font-size: 16px; */
/*     font-weight: 500; */
/* } */

/* .nav-links a:hover { */
/*     color: #fc4a1a; */
/* } */

/* /* HERO */ */

/* .hero { */
/*     background: linear-gradient(135deg, #ff512f, #f09819); */
/*     color: white; */
/*     text-align: center; */
/*     padding: 45px 20px; */
/* } */

/* .hero h1 { */
/*     font-size: 36px; */
/*     margin-bottom: 10px; */
/* } */

/* .hero p { */
/*     font-size: 17px; */
/* } */

/* /* SEARCH */ */

/* .search-container { */
/*     width: 70%; */
/*     max-width: 700px; */
/*     margin: -25px auto 35px; */
/*     position: relative; */
/* } */

/* .search-container input { */
/*     width: 100%; */
/*     height: 55px; */
/*     border: none; */
/*     border-radius: 30px; */
/*     padding: 0 25px; */
/*     font-size: 16px; */
/*     outline: none; */
/*     box-shadow: 0 5px 20px rgba(0,0,0,0.15); */
/* } */

/* /* CONTAINER */ */

/* .container { */
/*     width: 86%; */
/*     max-width: 1250px; */
/*     margin: auto; */
/* } */

/* .menu-header { */
/*     display: flex; */
/*     justify-content: space-between; */
/*     align-items: center; */
/*     margin-bottom: 25px; */
/* } */

/* .menu-header h2 { */
/*     font-size: 28px; */
/* } */

/* .menu-header span { */
/*     color: #777; */
/*     font-size: 14px; */
/* } */

/* /* GRID */ */

/* .menu-grid { */
/*     display: grid; */
/*     grid-template-columns: repeat(3, 1fr); */
/*     gap: 25px; */
/*     padding-bottom: 50px; */
/* } */

/* .menu-card { */
/*     background-color: white; */
/*     border-radius: 15px; */
/*     overflow: hidden; */
/*     box-shadow: 0 3px 12px rgba(0,0,0,0.10); */
/*     transition: 0.3s; */
/* } */

/* .menu-card:hover { */
/*     transform: translateY(-5px); */
/*     box-shadow: 0 8px 25px rgba(0,0,0,0.16); */
/* } */

/* .food-image { */
/*     width: 100%; */
/*     height: 210px; */
/*     object-fit: cover; */
/*     display: block; */
/* } */

/* .image-placeholder { */
/*     width: 100%; */
/*     height: 210px; */
/*     background: linear-gradient(135deg, #ff9966, #ff5e62); */
/*     display: flex; */
/*     justify-content: center; */
/*     align-items: center; */
/*     font-size: 60px; */
/*     color: white; */
/* } */

/* .card-content { */
/*     padding: 18px; */
/* } */

/* .item-name { */
/*     font-size: 20px; */
/*     font-weight: bold; */
/*     margin-bottom: 8px; */
/* } */

/* .description { */
/*     color: #777; */
/*     font-size: 14px; */
/*     line-height: 1.5; */
/*     min-height: 42px; */
/*     margin-bottom: 15px; */
/* } */

/* .item-bottom { */
/*     display: flex; */
/*     justify-content: space-between; */
/*     align-items: center; */
/* } */

/* .price { */
/*     font-size: 20px; */
/*     font-weight: bold; */
/*     color: #222; */
/* } */

/* .add-button { */
/*     background-color: #fc4a1a; */
/*     color: white; */
/*     border: none; */
/*     padding: 10px 20px; */
/*     border-radius: 8px; */
/*     font-size: 14px; */
/*     font-weight: bold; */
/*     cursor: pointer; */
/*     transition: 0.3s; */
/* } */

/* .add-button:hover { */
/*     background-color: #e63e10; */
/*     transform: scale(1.04); */
/* } */

/* /* Dynamic Quantity Control Styling (Swiggy / Zomato Style) */ */
/* .quantity-control { */
/*     display: flex; */
/*     align-items: center; */
/*     justify-content: space-between; */
/*     background-color: #ffffff; */
/*     border: 1px solid #fc4a1a; */
/*     border-radius: 8px; */
/*     width: 110px; */
/*     height: 38px; */
/*     box-shadow: 0 2px 5px rgba(252, 74, 26, 0.15); */
/*     overflow: hidden; */
/* } */

/* .qty-btn { */
/*     width: 32px; */
/*     height: 100%; */
/*     background-color: transparent; */
/*     color: #fc4a1a; */
/*     border: none; */
/*     font-size: 18px; */
/*     font-weight: bold; */
/*     cursor: pointer; */
/*     display: flex; */
/*     align-items: center; */
/*     justify-content: center; */
/*     text-decoration: none; */
/*     transition: background-color 0.2s; */
/* } */

/* .qty-btn:hover { */
/*     background-color: #fff0ec; */
/* } */

/* .qty-count { */
/*     font-size: 15px; */
/*     font-weight: bold; */
/*     color: #fc4a1a; */
/* } */

/* .available { */
/*     color: #267e3e; */
/*     font-size: 13px; */
/*     font-weight: bold; */
/*     margin-bottom: 12px; */
/* } */

/* .not-available { */
/*     color: #d32f2f; */
/*     font-size: 13px; */
/*     font-weight: bold; */
/*     margin-bottom: 12px; */
/* } */

/* .empty-menu { */
/*     background-color: white; */
/*     padding: 60px; */
/*     text-align: center; */
/*     border-radius: 15px; */
/*     margin-bottom: 50px; */
/*     color: #777; */
/* } */

/* .empty-menu h3 { */
/*     color: #333; */
/*     margin-bottom: 10px; */
/*     font-size: 22px; */
/* } */

/* .footer { */
/*     background-color: #222; */
/*     color: white; */
/*     text-align: center; */
/*     padding: 25px; */
/*     margin-top: 20px; */
/* } */

/* .footer p { */
/*     color: #bbb; */
/*     font-size: 14px; */
/* } */

/* @media (max-width: 1000px) { */
/*     .menu-grid { */
/*         grid-template-columns: repeat(2, 1fr); */
/*     } */
/* } */

/* @media (max-width: 650px) { */
/*     .menu-grid { */
/*         grid-template-columns: 1fr; */
/*     } */
/*     .nav-links a { */
/*         display: none; */
/*     } */
/*     .logo { */
/*         font-size: 25px; */
/*     } */
/*     .hero h1 { */
/*         font-size: 28px; */
/*     } */
/*     .search-container { */
/*         width: 90%; */
/*     } */
/*     .menu-header { */
/*         flex-direction: column; */
/*         align-items: flex-start; */
/*         gap: 8px; */
/*     } */
/* } */

<!-- </style> --> --%>

</head>

<body>

<jsp:include page="/includes/navbar.jsp" />

<!-- <!-- NAVBAR --> 
<!-- <div class="navbar"> -->
<!--     <div class="logo"> -->
<!--         FOODIFY -->
<!--     </div> -->

<!--     <div class="nav-links"> -->
<%--         <a href="<%= request.getContextPath() %>/Restaurant"> --%>
<!--             Restaurants -->
<!--         </a> -->
<!--         <a href="#"> -->
<!--             Orders -->
<!--         </a> -->
<%--         <a href="<%= request.getContextPath() %>/Cart.jsp"> --%>
<!--             Cart 🛒  -->
<%--             <%  --%>
<%--                Cart navCart = (Cart) session.getAttribute("cart");
//                 int totalItems = 0;
//                 if (navCart != null && navCart.getItems() != null) {
//                     for (CartItem item : navCart.getItems().values()) {
//                         totalItems += item.getQuantity();
//                     }
//                 }
<%--             %> --%>
<%-- <%--             <%= totalItems > 0 ? " (" + totalItems + ")" : "" %> --%> 
<!--        	</a> -->
<%-- 		
		String userName = (String) session.getAttribute("userName");
<%-- 		%> --%>

<%-- 		<% --
// 			if (userName != null) {
<%-- 		%> --%>

<%-- 			<span class="user-name"> 👤 <%=userName%> --%>
<%-- 			</span> <a href="<%=request.getContextPath()%>/LogoutController" --%>
<!-- 				class="logout-btn"> Logout </a> -->

<%-- 		<% --
// 			} else {
<%-- 		%> --%>

<%-- 			<a href="<%=request.getContextPath()%>/Login.jsp" class="login-nav"> --%>
<!-- 				Login </a> -->

<%-- 		
// 			}
<%-- 		%> --%>
<!-- 	</div> -->
<!-- </div> -->

<!-- HERO -->
<div class="hero">
    <h1>Explore Delicious Food</h1>
    <p>Choose your favourite food and add it to your cart</p>
</div>

<!-- SEARCH -->
<div class="search-container">
    <input type="text" id="menuSearch" placeholder="Search for food items..." onkeyup="searchMenu()">
</div>

<!-- MAIN CONTAINER -->
<div class="container">
    <div class="menu-header">
        <h2>Today's Menu</h2>
        <span>Fresh & Delicious</span>
    </div>

    <%
    List<Menu> menuList = (List<Menu>) request.getAttribute("allMenu");
    Cart sessionCart = (Cart) session.getAttribute("cart");

    if (menuList != null && !menuList.isEmpty()) {
    %>

    <div class="menu-grid" id="menuGrid">

    <%
    for (Menu menu : menuList) {

        // Check if current item exists in session cart
        boolean inCart = false;
        int itemQuantity = 0;

        if (sessionCart != null && sessionCart.getItems() != null 
                && sessionCart.getItems().containsKey(menu.getMenuId())) {
            inCart = true;
            itemQuantity = sessionCart.getItems().get(menu.getMenuId()).getQuantity();
        }
    %>

        <div class="menu-card">

            <% if (menu.getImagePath() != null && !menu.getImagePath().isEmpty()) { %>
                <img class="food-image" src="<%= menu.getImagePath() %>" alt="<%= menu.getItemName() %>">
            <% } else { %>
                <div class="image-placeholder">🍽️</div>
            <% } %>

            <div class="card-content">
                <div class="item-name"><%= menu.getItemName() %></div>
                <div class="description"><%= menu.getDescription() %></div>

                <% if (menu.getIsAvailable()) { %>
                    <div class="available">✓ Available</div>
                <% } else { %>
                    <div class="not-available">✕ Currently Unavailable</div>
                <% } %>

                <div class="item-bottom">
                    <div class="price">₹<%= menu.getPrice() %></div>

                    <% if (menu.getIsAvailable()) { %>

                        <% if (inCart) { %>
                            <!-- Display [- quantity +] widget if item is already in cart -->
                            <div class="quantity-control">
                                <a href="<%= request.getContextPath() %>/CartController?action=decrease&menuId=<%= menu.getMenuId() %>&restId=<%= menu.getRestId() %>" class="qty-btn">−</a>
                                <span class="qty-count"><%= itemQuantity %></span>
                                <a href="<%= request.getContextPath() %>/CartController?action=increase&menuId=<%= menu.getMenuId() %>&restId=<%= menu.getRestId() %>" class="qty-btn">+</a>
                            </div>
                        <% } else { %>
                            <!-- Display [+ Add to Cart] button if item is NOT in cart -->
                            <button class="add-button" onclick="addToCart(<%= menu.getMenuId() %>)">
                                + Add to Cart
                            </button>
                        <% } %>

                    <% } else { %>
                        <button class="add-button" disabled style="background:#aaa; cursor:not-allowed;">
                            Unavailable
                        </button>
                    <% } %>

                </div>
            </div>
        </div>

    <% } %>

    </div>

    <% } else { %>
        <div class="empty-menu">
            <h3>No Menu Items Available</h3>
            <p>This restaurant currently has no available food items.</p>
        </div>
    <% } %>

</div>

<!-- FOOTER -->
 <jsp:include page="/includes/footer.jsp" />

<script>
function searchMenu() {
    let input = document.getElementById("menuSearch").value.toLowerCase();
    let cards = document.querySelectorAll(".menu-card");

    cards.forEach(function(card) {
        let itemName = card.querySelector(".item-name").innerText.toLowerCase();
        let description = card.querySelector(".description").innerText.toLowerCase();

        if (itemName.includes(input) || description.includes(input)) {
            card.style.display = "";
        } else {
            card.style.display = "none";
        }
    });
}

function addToCart(menuId) {
    let form = document.createElement("form");
    form.method = "POST";
    form.action = "<%= request.getContextPath() %>/CartController";

    let input = document.createElement("input");
    input.type = "hidden";
    input.name = "menuId";
    input.value = menuId;

    form.appendChild(input);
    document.body.appendChild(form);
    form.submit();
}
</script>

</body>
</html>