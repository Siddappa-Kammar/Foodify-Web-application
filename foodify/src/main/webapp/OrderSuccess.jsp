
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Foodify - Order Successful</title>
    <link rel="stylesheet"
        href="<%= request.getContextPath() %>/css/common.css">
</head>
<body>
    <jsp:include page="/includes/navbar.jsp" />

    <main style="max-width:650px; margin:70px auto; padding:35px;
                text-align:center; background:#fff; border-radius:12px;">

        <h1 style="color:#28a745;">✓ Order Placed Successfully!</h1>

        <p>Thank you for ordering with Foodify.</p>

        <h3>
            Order ID:
            <%= session.getAttribute("lastOrderId") %>
        </h3>

        <p>Your order has been saved successfully.</p>

        <a href="<%= request.getContextPath() %>/Restaurant"
           style="display:inline-block; margin-top:20px; padding:12px 22px;
                  background:#fc4a1a; color:white; text-decoration:none;
                  border-radius:6px;">
            Continue Shopping
        </a>
    </main>

    <jsp:include page="/includes/footer.jsp" />
</body>
</html>
