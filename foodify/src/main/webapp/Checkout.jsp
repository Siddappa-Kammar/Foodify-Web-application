<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.tap.model.Cart"%>
<%@ page import="com.tap.model.CartItem"%>
<%@ page import="com.tap.model.Menu"%>

<!DOCTYPE html>
<html>

<head>

    <meta charset="UTF-8">

    <title>Foodify - Checkout</title>
    
    <link rel="stylesheet"
      href="<%= request.getContextPath() %>/css/common.css">

	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/checkout.css">

<!--     <style> --><%-- 

/*         * { */
/*             margin: 0; */
/*             padding: 0; */
/*             box-sizing: border-box; */
/*             font-family: Arial, sans-serif; */
/*         } */

/*         body { */
/*             background-color: #f7f7f7; */
/*             color: #333; */
/*         } */

/*         /* ================= NAVBAR ================= */ */

/*         .navbar { */
/*             height: 70px; */
/*             background-color: white; */
/*             display: flex; */
/*             align-items: center; */
/*             justify-content: space-between; */
/*             padding: 0 7%; */
/*             box-shadow: 0 2px 8px rgba(0,0,0,0.08); */
/*         } */

/*         .logo { */
/*             font-size: 30px; */
/*             font-weight: bold; */
/*             color: #ff5722; */
/*             text-decoration: none; */
/*         } */

/*         .nav-links { */
/*             display: flex; */
/*             gap: 30px; */
/*         } */

/*         .nav-links a { */
/*             text-decoration: none; */
/*             color: #333; */
/*             font-size: 16px; */
/*         } */

/*         .nav-links a:hover { */
/*             color: #ff5722; */
/*         } */
        
/*         .user-name { */
/* 	    color: #333; */
/* 	    font-size: 15px; */
/* 	    font-weight: bold; */
/* 		} */
		
/* /* 		.logout-btn { */ */
/* /* 		    text-decoration: none; */ */
/* /* 		    color: #ff5722; */ */
/* /* 		    border: 1px solid #ff5722; */ */
/* /* 		    padding: 8px 16px; */ */
/* /* 		    border-radius: 6px; */ */
/* /* 		    font-size: 14px; */ */
/* /* 		    font-weight: bold; */ */
/* /* 		    transition: 0.3s; */ */
/* /* 		} */ */
		
/* /* 		.logout-btn:hover { */ */
/* /* 		    background-color: #ff5722; */ */
/* /* 		    color: white; */ */
/* /* 		} */ */

/*         /* ================= PAGE ================= */ */

/*         .container { */
/*             width: 88%; */
/*             max-width: 1200px; */
/*             margin: 40px auto; */
/*         } */

/*         .page-title { */
/*             font-size: 30px; */
/*             margin-bottom: 30px; */
/*         } */

/*         /* FLEX WRAPPER FOR 2-COLUMN LAYOUT */ */

/*         .checkout-wrapper { */
/*             display: flex; */
/*             gap: 30px; */
/*             align-items: flex-start; */
/*         } */

/*         /* ================= LEFT SIDE (Address & Payment) ================= */ */

/*         .checkout-left { */
/*             flex: 1; */
/*             min-width: 0; */
/*         } */

/*         .section { */
/*             background: white; */
/*             padding: 25px; */
/*             border-radius: 12px; */
/*             margin-bottom: 25px; */
/*             box-shadow: 0 2px 10px rgba(0,0,0,0.08); */
/*         } */

/*         .section h2 { */
/*             font-size: 21px; */
/*             margin-bottom: 20px; */
/*         } */

/*         /* ================= BACK TO CART ================= */ */

/*         .back-cart { */
/*             display: inline-block; */
/*             text-decoration: none; */
/*             color: #ff5722; */
/*             font-size: 15px; */
/*             font-weight: bold; */
/*             margin-bottom: 20px; */
/*             padding: 10px 18px; */
/*             background-color: white; */
/*             border-radius: 8px; */
/*             box-shadow: 0 2px 8px rgba(0,0,0,0.05); */
/*             transition: 0.3s; */
/*         } */

/*         .back-cart:hover { */
/*             background-color: #fff0ec; */
/*             text-decoration: underline; */
/*         } */

/*         /* ================= ADDRESS ================= */ */

/*         .input-group { */
/*             margin-bottom: 18px; */
/*         } */

/*         .input-group label { */
/*             display: block; */
/*             margin-bottom: 7px; */
/*             font-size: 14px; */
/*             font-weight: bold; */
/*         } */

/*         .input-group input, */
/*         .input-group textarea { */
/*             width: 100%; */
/*             padding: 12px; */
/*             border: 1px solid #ddd; */
/*             border-radius: 7px; */
/*             font-size: 14px; */
/*             outline: none; */
/*         } */

/*         .input-group input:focus, */
/*         .input-group textarea:focus { */
/*             border-color: #ff5722; */
/*         } */

/*         .input-group textarea { */
/*             height: 90px; */
/*             resize: vertical; */
/*         } */

/*         /* ================= PAYMENT ================= */ */

/*         .payment-option { */
/*             border: 1px solid #ddd; */
/*             border-radius: 8px; */
/*             padding: 15px; */
/*             margin-bottom: 12px; */
/*             cursor: pointer; */
/*             transition: 0.2s; */
/*         } */

/*         .payment-option:hover { */
/*             border-color: #ff5722; */
/*             background-color: #fff8f5; */
/*         } */

/*         .payment-option label { */
/*             cursor: pointer; */
/*             font-size: 15px; */
/*             font-weight: bold; */
/*             display: flex; */
/*             align-items: center; */
/*         } */

/*         .payment-option input { */
/*             margin-right: 12px; */
/*             accent-color: #ff5722; */
/*         } */

/*         /* ================= RIGHT SIDE (ORDER SUMMARY) ================= */ */

/*         .order-summary { */
/*             width: 380px; */
/*             flex-shrink: 0; */
/*             background: white; */
/*             padding: 25px; */
/*             border-radius: 12px; */
/*             box-shadow: 0 2px 10px rgba(0,0,0,0.08); */
/*             position: sticky; */
/*             top: 20px; */
/*         } */

/*         .order-summary h2 { */
/*             margin-bottom: 20px; */
/*             font-size: 22px; */
/*         } */

/*         /* ================= ITEM ================= */ */

/*         .summary-item { */
/*             display: flex; */
/*             justify-content: space-between; */
/*             align-items: center; */
/*             gap: 15px; */
/*             padding: 13px 0; */
/*             border-bottom: 1px solid #eee; */
/*         } */

/*         .item-info { */
/*             display: flex; */
/*             align-items: center; */
/*             gap: 12px; */
/*         } */

/*         .item-image { */
/*             width: 65px; */
/*             height: 65px; */
/*             object-fit: cover; */
/*             border-radius: 8px; */
/*         } */

/*         .item-name { */
/*             font-size: 15px; */
/*             font-weight: bold; */
/*         } */

/*         .item-quantity { */
/*             color: #777; */
/*             font-size: 13px; */
/*             margin-top: 4px; */
/*         } */

/*         .item-price { */
/*             font-size: 15px; */
/*             font-weight: bold; */
/*             white-space: nowrap; */
/*         } */

/*         /* ================= TOTAL ================= */ */

/*         .summary-row { */
/*             display: flex; */
/*             justify-content: space-between; */
/*             margin-top: 15px; */
/*             color: #555; */
/*             font-size: 14px; */
/*         } */

/*         .total-row { */
/*             display: flex; */
/*             justify-content: space-between; */
/*             border-top: 1px solid #ddd; */
/*             margin-top: 20px; */
/*             padding-top: 20px; */
/*             font-size: 20px; */
/*             font-weight: bold; */
/*         } */

/*         .place-order-btn { */
/*             width: 100%; */
/*             border: none; */
/*             background-color: #ff5722; */
/*             color: white; */
/*             padding: 14px; */
/*             border-radius: 7px; */
/*             margin-top: 25px; */
/*             font-size: 16px; */
/*             font-weight: bold; */
/*             cursor: pointer; */
/*             transition: 0.3s; */
/*         } */

/*         .place-order-btn:hover { */
/*             background-color: #e64a19; */
/*         } */

/*         /* ================= FOOTER ================= */ */

/*         .footer { */
/*             background-color: #222; */
/*             color: white; */
/*             text-align: center; */
/*             padding: 25px; */
/*             margin-top: 40px; */
/*         } */

/*         .footer p { */
/*             color: #bbb; */
/*             font-size: 14px; */
/*         } */

/*         /* ================= RESPONSIVE ================= */ */

/*         @media (max-width: 900px) { */

/*             .checkout-wrapper { */
/*                 flex-direction: column; */
/*             } */

/*             .order-summary { */
/*                 width: 100%; */
/*                 position: static; */
/*             } */

/*         } */

/*         @media (max-width: 550px) { */

/*             .container { */
/*                 width: 92%; */
/*             } */

/*             .nav-links { */
/*                 gap: 12px; */
/*             } */

/*             .nav-links a { */
/*                 font-size: 13px; */
/*             } */

/*             .logo { */
/*                 font-size: 24px; */
/*             } */

/*         } */

<!--     </style> -->

</head>

<body>

<jsp:include page="/includes/navbar.jsp" />

<!-- ================= NAVBAR ================= -->

<!-- <div class="navbar"> -->

<%--     <a href="<%= request.getContextPath() %>/RestaurantController" class="logo"> --%>
<!--         FOODIFY -->
<!--     </a> -->

<!--     <div class="nav-links"> -->

<%--         <a href="<%= request.getContextPath() %>/RestaurantController"> --%>
<!--             Restaurants -->
<!--         </a> -->

<!--         <a href="#"> -->
<!--             Orders -->
<!--         </a> -->

<%--         <a href="<%= request.getContextPath() %>/Cart.jsp"> --%>
<!--             Cart 🛒 -->
<!--         </a> -->

<%--         
// 			String userName = (String) session.getAttribute("userName");
<%-- 		%> --%>

<%-- 		
// 			if (userName != null) {
<%-- 		%> --%>

<%-- 			<span class="user-name"> 👤 <%=userName%> --%>
<%-- 			</span> <a href="<%=request.getContextPath()%>/LogoutController" --%>
<!-- 				class="logout-btn"> Logout </a> -->

<%-- 		
// 			} else {
<%-- 		%> --%>

<%-- 			<a href="<%=request.getContextPath()%>/Login.jsp" class="login-nav"> --%>
<!-- 				Login </a> -->

<%-- 	
// 			}
<%-- 		%> --%>

<!--     </div> -->

<!-- </div> -->


<%
    /* Fetch cart from request attribute or fallback to session */
    Cart cart = (Cart) request.getAttribute("cart");
    if (cart == null) {
        cart = (Cart) session.getAttribute("cart");
    }
%>


<!-- ================= MAIN ================= -->

<div class="container">

    <h1 class="page-title">
        Checkout
    </h1>


    <div class="checkout-wrapper">


        <!-- ================= LEFT SIDE (Address & Payment) ================= -->

        <div class="checkout-left">

            <!-- BACK TO CART -->
            <a href="<%= request.getContextPath() %>/Cart.jsp" class="back-cart">
                ← Back to Cart
            </a>


            <!-- DELIVERY ADDRESS -->
            <div class="section">

                <h2>📍 Delivery Address</h2>

                <div class="input-group">
                    <label>Full Name</label>
                    <input type="text" name="fullName" id="fullName" placeholder="Enter your full name" required>
                </div>

                <div class="input-group">
                    <label>Phone Number</label>
                    <input type="tel" name="phone" id="phone" placeholder="Enter your phone number" required>
                </div>

                <div class="input-group">
                    <label>Delivery Address</label>
                    <textarea name="address" id="address" placeholder="Enter your complete delivery address" required></textarea>
                </div>

            </div>


            <!-- PAYMENT METHOD -->
            <div class="section">

                <h2>💳 Payment Method</h2>

                <div class="payment-option">
                    <label>
                        <input type="radio" name="paymentMode" value="COD" checked>
                        Cash on Delivery
                    </label>
                </div>

                <div class="payment-option">
                    <label>
                        <input type="radio" name="paymentMode" value="UPI">
                        UPI
                    </label>
                </div>

                <div class="payment-option">
                    <label>
                        <input type="radio" name="paymentMode" value="CARD">
                        Credit / Debit Card
                    </label>
                </div>

            </div>

        </div>


        <!-- ================= RIGHT SIDE (ORDER SUMMARY) ================= -->

        <div class="order-summary">

            <h2>Order Summary</h2>

            <%
                double grandTotal = 0;

                if (cart != null && cart.getItems() != null && !cart.getItems().isEmpty()) {

                    for (Map.Entry<Integer, CartItem> entry : cart.getItems().entrySet()) {

                        CartItem cartItem = entry.getValue();
                        Menu menu = cartItem.getMenu();
                        double itemTotal = cartItem.getTotalAmount();
                        grandTotal += itemTotal;
            %>

            <!-- ITEM -->
            <div class="summary-item">

                <div class="item-info">

                    <% if (menu.getImagePath() != null && !menu.getImagePath().isEmpty()) { %>
                        <img src="<%= menu.getImagePath() %>" class="item-image" alt="<%= menu.getItemName() %>">
                    <% } else { %>
                        <div class="item-image" style="background: #eee; display:flex; align-items:center; justify-content:center;">🍽️</div>
                    <% } %>

                    <div>
                        <div class="item-name"><%= menu.getItemName() %></div>
                        <div class="item-quantity">Qty: <%= cartItem.getQuantity() %></div>
                    </div>

                </div>

                <div class="item-price">
                    ₹<%= String.format("%.2f", itemTotal) %>
                </div>

            </div>

            <%
                    }
                }
                
                double deliveryFee = 40;
                double taxes = 20;
                double totalAmount = grandTotal + deliveryFee + taxes;
            %>


            <!-- PRICE DETAILS -->

            <div class="summary-row">
                <span>Item Total</span>
                <span>₹<%= String.format("%.2f", grandTotal) %></span>
            </div>

            <div class="summary-row">
                <span>Delivery Fee</span>
                <span>₹<%= String.format("%.2f", deliveryFee) %></span>
            </div>

            <div class="summary-row">
                <span>Taxes & Charges</span>
                <span>₹<%= String.format("%.2f", taxes) %></span>
            </div>

            <div class="total-row">
                <span>To Pay</span>
                <span>₹<%= String.format("%.2f", totalAmount) %></span>
            </div>


            <!-- PLACE ORDER FORM -->

            <form action="<%= request.getContextPath() %>/CheckoutController" method="post" onsubmit="return validateCheckout();">

                <input type="hidden" name="totalAmount" value="<%= totalAmount %>">
                <input type="hidden" name="paymentMode" id="selectedPayment">
                <input type="hidden" name="fullName" id="hiddenFullName">
                <input type="hidden" name="phone" id="hiddenPhone">
                <input type="hidden" name="address" id="hiddenAddress">

                <button type="submit" class="place-order-btn">
                    Place Order
                </button>

            </form>

        </div>

    </div>

</div>


<!-- ================= JAVASCRIPT ================= -->

<script>

function validateCheckout() {

    let fullName = document.getElementById("fullName").value.trim();
    let phone = document.getElementById("phone").value.trim();
    let address = document.getElementById("address").value.trim();
    let paymentOption = document.querySelector('input[name="paymentMode"]:checked');

    if (fullName === "") {
        alert("Please enter your full name.");
        return false;
    }

    if (phone === "") {
        alert("Please enter your phone number.");
        return false;
    }

    if (!/^[0-9]{10}$/.test(phone)) {
        alert("Please enter a valid 10-digit phone number.");
        return false;
    }

    if (address === "") {
        alert("Please enter your delivery address.");
        return false;
    }

    /* Copy form values into hidden input fields before submitting */
    document.getElementById("hiddenFullName").value = fullName;
    document.getElementById("hiddenPhone").value = phone;
    document.getElementById("hiddenAddress").value = address;
    document.getElementById("selectedPayment").value = paymentOption ? paymentOption.value : "COD";

    return true;
}

</script>

</body>

</html>