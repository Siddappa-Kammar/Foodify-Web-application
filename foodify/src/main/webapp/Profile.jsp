<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.tap.model.User"%>

<%
    // Guard — LoginController sets "userId" as Integer
    if (session.getAttribute("userId") == null) {
        response.sendRedirect(request.getContextPath() + "/Login.jsp");
        return;
    }

    User user = (User) request.getAttribute("profileUser");

    if (user == null) {
        response.sendRedirect(request.getContextPath() + "/ProfileController");
        return;
    }

    // Pre-compute display values — keeps JSP expressions clean
    String displayName    = (user.getName()    != null && !user.getName().trim().isEmpty())
                            ? user.getName().trim() : "User";
    String displayPhone   = (user.getPhone()   != null && !user.getPhone().trim().isEmpty())
                            ? user.getPhone() : "Not provided";
    String displayAddress = (user.getAddress() != null && !user.getAddress().trim().isEmpty())
                            ? user.getAddress() : "Not provided";
    String avatarLetter   = displayName.substring(0, 1).toUpperCase();
    String memberSince    = user.getCreateDate() != null
                            ? new java.text.SimpleDateFormat("dd MMM yyyy").format(user.getCreateDate())
                            : "—";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>My Profile | Foodify</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/common.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/profile.css">
</head>
<body>

    <jsp:include page="/includes/navbar.jsp" />

    <main class="profile-container">

        <!-- PAGE HEADING -->
        <div class="profile-heading">
            <h1>My Profile</h1>
            <p>Manage your Foodify account information.</p>
        </div>

        <!-- PROFILE CARD -->
        <section class="profile-card">

            <!-- BANNER / AVATAR -->
            <div class="profile-banner">
                <div class="profile-avatar"><%= avatarLetter %></div>
                <h2><%= displayName %></h2>
                <p><%= user.getEmail() %></p>
            </div>

            <!-- DETAIL ROWS -->
            <div class="profile-details">

                <div class="detail-row">
                    <span>Full Name</span>
                    <strong><%= displayName %></strong>
                </div>

                <div class="detail-row">
                    <span>Email Address</span>
                    <strong><%= user.getEmail() %></strong>
                </div>

                <div class="detail-row">
                    <span>Phone Number</span>
                    <strong><%= displayPhone %></strong>
                </div>

                <div class="detail-row">
                    <span>Delivery Address</span>
                    <strong><%= displayAddress %></strong>
                </div>

                <div class="detail-row">
                    <span>Member Since</span>
                    <strong><%= memberSince %></strong>
                </div>

                <div class="detail-row">
                    <span>Account Role</span>
                    <strong><%= user.getRole() %></strong>
                </div>

                <!-- ACTION BUTTONS -->
                <div class="profile-actions">
                	<!-- ADD THIS EDIT BUTTON BACK -->
                    <button type="button" class="profile-btn edit-btn" onclick="openEditModal()">
                        ✏️ Edit Profile
                    </button>
                    
                    
                    <a href="<%= request.getContextPath() %>/OrdersController"
                       class="profile-btn secondary-btn">
                        📦 My Orders
                    </a>
                    <a href="<%= request.getContextPath() %>/Restaurant"
                       class="profile-btn primary-btn">
                        🍽️ Browse Restaurants
                    </a>
                </div>

            </div>
        </section>

    </main>
    
    
    <!-- EDIT PROFILE MODAL -->
    <div id="editModal" class="modal-overlay">
        <div class="modal-card">
            <h2>Edit Profile</h2>
            <form action="<%= request.getContextPath() %>/EditProfileController" method="post">
                <div class="form-group">
                    <label>Full Name</label>
                    <input type="text" name="name" value="<%= displayName %>" required>
                </div>

                <div class="form-group">
                    <label>Phone Number</label>
                    <input type="tel" name="phone" value="<%= displayPhone %>" pattern="[0-9]{10}" required>
                </div>

                <div class="form-group">
                    <label>Delivery Address</label>
                    <textarea name="address" rows="3" required><%= displayAddress %></textarea>
                </div>

                <div class="modal-actions">
                    <button type="button" class="btn-cancel" onclick="closeEditModal()">Cancel</button>
                    <button type="submit" class="btn-save">Save Changes</button>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="/includes/footer.jsp" />

<script>
function openEditModal() {
    document.getElementById("editModal").style.display = "flex";
}
function closeEditModal() {
    document.getElementById("editModal").style.display = "none";
}
</script>

</body>
</html>

<%--     <jsp:include page="/includes/footer.jsp" /> --%>

<!-- </body> -->
<!-- </html> -->


