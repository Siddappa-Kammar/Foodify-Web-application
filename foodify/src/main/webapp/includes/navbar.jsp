<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.Cart, com.tap.model.CartItem" %>

<div class="navbar">

    <!-- LOGO -->
    <a href="<%= request.getContextPath() %>/Restaurant" class="logo">
        Foodify
    </a>

    <!-- NAVIGATION LINKS -->
    <div class="nav-links">

        <a href="<%= request.getContextPath() %>/Restaurant">
            Restaurants
        </a>

<%--         <a href="<%= request.getContextPath() %>/OrderController"> --%>
<!--             Orders -->
<!--         </a> -->

        <%
            // Dynamic Cart Items Count Calculation
            Cart navCart = (Cart) session.getAttribute("cart");
            int totalCartItems = 0;
            if (navCart != null && navCart.getItems() != null) {
                for (CartItem item : navCart.getItems().values()) {
                    totalCartItems += item.getQuantity();
                }
            }
        %>

        <a href="<%= request.getContextPath() %>/Cart.jsp">
            Cart 🛒 <%= (totalCartItems > 0) ? "(" + totalCartItems + ")" : "" %>
        </a>

        <%
            // User Session Check (Login / Logout Toggle)
            String userName = (String) session.getAttribute("userName");
            if (userName != null && !userName.trim().isEmpty()) {
        %>
            <!-- USER DROPDOWN LOGO & MENU -->
            <div class="user-dropdown">
                <button class="user-profile-btn">
                    <span class="user-avatar">👤</span>
                    <span class="user-name"><%= userName %></span>
                    <span class="dropdown-arrow">▾</span>
                </button>
                
                <div class="dropdown-menu">
                   <a href="<%= request.getContextPath() %>/ProfileController">My Profile</a>
                    <a href="<%= request.getContextPath() %>/OrdersController">My Orders</a>
                    <hr class="dropdown-divider">
                    <a href="<%= request.getContextPath() %>/LogoutController" class="dropdown-logout">
                        🚪 Logout
                    </a>
                </div>
            </div>
        <%
            } else {
        %>
            <a href="<%= request.getContextPath() %>/Login.jsp" class="login-nav">
                Login
            </a>
        <%
            }
        %>

    </div>

</div>