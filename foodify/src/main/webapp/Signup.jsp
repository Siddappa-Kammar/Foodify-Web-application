
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Foodify - Sign Up</title>

    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/css/common.css">

    <link rel="stylesheet"
          href="<%= request.getContextPath() %>/css/signup.css">
</head>

<body>

    <jsp:include page="/includes/navbar.jsp" />

    <main class="signup-page">

        <div class="signup-card">

            <div class="signup-header">
                <h1>Create Account</h1>
                <p>Join Foodify and get your favorite food delivered!</p>
            </div>

            <%-- Display registration messages --%>
            <% if (request.getAttribute("errorMessage") != null) { %>
                <div class="signup-error">
                    <%= request.getAttribute("errorMessage") %>
                </div>
            <% } %>

            <% if (request.getAttribute("successMessage") != null) { %>
                <div class="signup-success">
                    <%= request.getAttribute("successMessage") %>
                </div>
            <% } %>

            <form action="<%= request.getContextPath() %>/SignupController"
                  method="post"
                  class="signup-form"
                  id="signupForm">

                <div class="form-group">
                    <label for="name">Full Name</label>
                    <input type="text"
                           id="name"
                           name="name"
                           placeholder="Enter your full name"
                           autocomplete="name"
                           required
                           maxlength="100">
                </div>

                <div class="form-group">
                    <label for="email">Email Address</label>
                    <input type="email"
                           id="email"
                           name="email"
                           placeholder="Enter your email"
                           autocomplete="email"
                           required
                           maxlength="150">
                </div>

                <div class="form-group">
                    <label for="phone">Phone Number</label>
                    <input type="tel"
                           id="phone"
                           name="phone"
                           placeholder="Enter 10-digit phone number"
                           autocomplete="tel"
                           pattern="[0-9]{10}"
                           maxlength="10"
                           inputmode="numeric"
                           title="Enter a 10-digit phone number"
                           required>
                </div>

                <div class="form-group">
                    <label for="address">Delivery Address</label>
                    <textarea id="address"
                              name="address"
                              placeholder="Enter your complete address"
                              autocomplete="street-address"
                              rows="3"
                              maxlength="500"
                              required></textarea>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password"
                           id="password"
                           name="password"
                           placeholder="Create a password"
                           autocomplete="new-password"
                           minlength="8"
                           required>
                </div>

                <div class="form-group">
                    <label for="confirmPassword">Confirm Password</label>
                    <input type="password"
                           id="confirmPassword"
                           name="confirmPassword"
                           placeholder="Re-enter your password"
                           autocomplete="new-password"
                           minlength="8"
                           required>
                    <small id="passwordMessage"></small>
                </div>

                <!-- New users register as regular customers -->
                <input type="hidden" name="role" value="USER">

                <button type="submit" class="signup-btn">
                    Create Account
                </button>

            </form>

            <div class="signup-footer">
                <p>
                    Already have an account?
                    <a href="<%= request.getContextPath() %>/Login.jsp">
                        Login
                    </a>
                </p>
            </div>

        </div>

    </main>

    <jsp:include page="/includes/footer.jsp" />

    <script>
        const signupForm = document.getElementById("signupForm");
        const password = document.getElementById("password");
        const confirmPassword = document.getElementById("confirmPassword");
        const passwordMessage = document.getElementById("passwordMessage");

        function checkPasswords() {
            if (confirmPassword.value === "") {
                passwordMessage.textContent = "";
                confirmPassword.setCustomValidity("");
                return;
            }

            if (password.value !== confirmPassword.value) {
                passwordMessage.textContent = "Passwords do not match.";
                confirmPassword.setCustomValidity("Passwords do not match.");
            } else {
                passwordMessage.textContent = "Passwords match.";
                confirmPassword.setCustomValidity("");
            }
        }

        password.addEventListener("input", checkPasswords);
        confirmPassword.addEventListener("input", checkPasswords);

        signupForm.addEventListener("submit", function(event) {
            checkPasswords();

            if (!signupForm.checkValidity()) {
                event.preventDefault();
                signupForm.reportValidity();
            }
        });
    </script>

</body>
</html>
