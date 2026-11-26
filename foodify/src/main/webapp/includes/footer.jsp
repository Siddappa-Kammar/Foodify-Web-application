<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<footer class="footer">
    <div class="footer-container">

        <div class="footer-brand">
            <h2>Foodify</h2>
            <p>
                Delicious food delivered to your doorstep.
                Discover restaurants, explore menus and enjoy
                your favorite meals with Foodify.
            </p>
        </div>

        <div class="footer-column">
            <h3>Quick Links</h3>
            <a href="<%= request.getContextPath() %>/index.jsp">Home</a>
            <a href="<%= request.getContextPath() %>/Restaurant">Restaurants</a>
            <a href="<%= request.getContextPath() %>/Cart.jsp">Cart</a>
            <a href="<%= request.getContextPath() %>/Login.jsp">Login</a>
        </div>

        <div class="footer-column">
            <h3>Foodify</h3>
            <a href="#">About Us</a>
            <a href="#">Contact Us</a>
            <a href="#">Privacy Policy</a>
            <a href="#">Terms &amp; Conditions</a>
        </div>

        <div class="footer-column">
            <h3>Contact</h3>
            <p>📧 support@foodify.com</p>
            <p>📞 +91 98765 43210</p>
            <p>📍 Karnataka, India</p>
        </div>

    </div>

    <div class="footer-bottom">
        &copy; 2026 Foodify. All Rights Reserved.
    </div>
</footer>