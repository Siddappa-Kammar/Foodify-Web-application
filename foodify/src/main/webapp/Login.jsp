<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Foodify - Login</title>

	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/common.css">
	
	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/login.css">
<%-- 
<!-- <style> -->
/* * { */
/* 	margin: 0; */
/* 	padding: 0; */
/* 	box-sizing: border-box; */
/* 	font-family: Arial, sans-serif; */
/* } */

/* body { */
/* 	background-color: #f8f8f8; */
/* 	min-height: 100vh; */
/* } */

/* /* ================= NAVBAR ================= */ */
/* .navbar { */
/* 	height: 70px; */
/* 	background-color: white; */
/* 	display: flex; */
/* 	align-items: center; */
/* 	justify-content: space-between; */
/* 	padding: 0 7%; */
/* 	box-shadow: 0 2px 10px rgba(0, 0, 0, 0.08); */
/* } */

/* .logo { */
/* 	font-size: 28px; */
/* 	font-weight: bold; */
/* 	color: #ff5722; */
/* 	text-decoration: none; */
/* } */

/* .nav-links { */
/* 	display: flex; */
/* 	gap: 30px; */
/* 	align-items: center; */
/* } */

/* .nav-links a { */
/* 	text-decoration: none; */
/* 	color: #333; */
/* 	font-size: 15px; */
/* 	font-weight: 500; */
/* 	transition: 0.3s; */
/* } */

/* .nav-links a:hover { */
/* 	color: #ff5722; */
/* } */

/* .login-nav { */
/* 	background-color: #ff5722; */
/* 	color: white !important; */
/* 	padding: 9px 18px; */
/* 	border-radius: 6px; */
/* } */

/* .login-nav:hover { */
/* 	background-color: #e64a19; */
/* } */

/* /* ================= LOGIN CONTAINER ================= */ */
/* .login-container { */
/* 	min-height: calc(100vh - 70px); */
/* 	display: flex; */
/* 	justify-content: center; */
/* 	align-items: center; */
/* 	padding: 40px 20px; */
/* } */

/* /* ================= LOGIN CARD ================= */ */
/* .login-card { */
/* 	width: 100%; */
/* 	max-width: 420px; */
/* 	background-color: white; */
/* 	padding: 35px; */
/* 	border-radius: 15px; */
/* 	box-shadow: 0 5px 25px rgba(0, 0, 0, 0.10); */
/* } */

/* .login-card h1 { */
/* 	text-align: center; */
/* 	color: #ff5722; */
/* 	margin-bottom: 8px; */
/* } */

/* .login-card .subtitle { */
/* 	text-align: center; */
/* 	color: #777; */
/* 	font-size: 14px; */
/* 	margin-bottom: 30px; */
/* } */

/* /* ================= FORM ================= */ */
/* .form-group { */
/* 	margin-bottom: 20px; */
/* } */

/* .form-group label { */
/* 	display: block; */
/* 	margin-bottom: 7px; */
/* 	font-size: 14px; */
/* 	font-weight: bold; */
/* 	color: #333; */
/* } */

/* .form-group input { */
/* 	width: 100%; */
/* 	padding: 13px; */
/* 	border: 1px solid #ddd; */
/* 	border-radius: 7px; */
/* 	font-size: 15px; */
/* 	outline: none; */
/* 	transition: 0.3s; */
/* } */

/* .form-group input:focus { */
/* 	border-color: #ff5722; */
/* 	box-shadow: 0 0 0 2px rgba(255, 87, 34, 0.08); */
/* } */

/* /* ================= FORGOT PASSWORD ================= */ */
/* .forgot-password { */
/* 	text-align: right; */
/* 	margin-top: -10px; */
/* 	margin-bottom: 20px; */
/* } */

/* .forgot-password a { */
/* 	text-decoration: none; */
/* 	color: #ff5722; */
/* 	font-size: 13px; */
/* } */

/* .forgot-password a:hover { */
/* 	text-decoration: underline; */
/* } */

/* /* ================= LOGIN BUTTON ================= */ */
/* .login-btn { */
/* 	width: 100%; */
/* 	padding: 13px; */
/* 	border: none; */
/* 	border-radius: 7px; */
/* 	background-color: #ff5722; */
/* 	color: white; */
/* 	font-size: 16px; */
/* 	font-weight: bold; */
/* 	cursor: pointer; */
/* 	transition: 0.3s; */
/* } */

/* .login-btn:hover { */
/* 	background-color: #e64a19; */
/* } */

/* /* ================= REGISTER ================= */ */
/* .register-link { */
/* 	text-align: center; */
/* 	margin-top: 25px; */
/* 	color: #666; */
/* 	font-size: 14px; */
/* } */

/* .register-link a { */
/* 	color: #ff5722; */
/* 	text-decoration: none; */
/* 	font-weight: bold; */
/* } */

/* .register-link a:hover { */
/* 	text-decoration: underline; */
/* } */

/* /* ================= ERROR / SUCCESS ================= */ */
/* .message { */
/* 	text-align: center; */
/* 	margin-bottom: 15px; */
/* 	padding: 10px; */
/* 	border-radius: 6px; */
/* 	font-size: 14px; */
/* } */

/* .error { */
/* 	background-color: #ffe5e5; */
/* 	color: #d32f2f; */
/* } */

/* .success { */
/* 	background-color: #e5f7e9; */
/* 	color: #2e7d32; */
/* } */

/* /* ================= MOBILE ================= */ */
/* @media ( max-width : 600px) { */
/* 	.navbar { */
/* 		padding: 0 20px; */
/* 	} */
/* 	.nav-links { */
/* 		gap: 12px; */
/* 	} */
/* 	.nav-links a { */
/* 		font-size: 13px; */
/* 	} */
/* 	.login-card { */
/* 		padding: 25px 20px; */
/* 	} */
/* } */
<!-- </style> -->
--%>
</head>

<body>


	 <!-- NAVBAR -->
    <jsp:include page="/includes/navbar.jsp" />


	<!-- ================= LOGIN ================= -->

	<div class="login-container">

		<div class="login-card">

			<h1>Welcome Back!</h1>

			<p class="subtitle">Login to continue ordering delicious food</p>


			<!-- ERROR MESSAGE -->

			<%
			String error = (String) request.getAttribute("error");

			if (error != null) {
			%>

			<div class="message error">
				<%=error%>
			</div>

			<%
			}
			%>


			<!-- SUCCESS MESSAGE -->

			<%
			String message = (String) request.getAttribute("message");

			if (message != null) {
			%>

			<div class="message success">
				<%=message%>
			</div>

			<%
			}
			%>


			<!-- LOGIN FORM -->

			<form action="<%=request.getContextPath()%>/LoginController"
				method="post">

				<div class="form-group">

					<label for="email"> Email </label> <input type="email" id="email"
						name="email" placeholder="Enter your email" required>

				</div>


				<div class="form-group">

					<label for="password"> Password </label> <input type="password"
						id="password" name="password" placeholder="Enter your password"
						required>

				</div>


				<div class="forgot-password">

					<a href="#"> Forgot Password? </a>

				</div>


				<button type="submit" class="login-btn">Login</button>

			</form>


			<!-- REGISTER -->

			<div class="register-link">

				Don't have an account? <a
					href="<%=request.getContextPath()%>/Signup.jsp"> Signup </a>

			</div>
			
			<% if ("success".equals(request.getParameter("registered"))) { %>
		    <div class="signup-success">
			        Registration successful! Please log in.
	    	</div>
			<% } %>

		</div>

	</div>
	
	<!-- FOOTER -->
    <jsp:include page="/includes/footer.jsp" />


</body>
</html>