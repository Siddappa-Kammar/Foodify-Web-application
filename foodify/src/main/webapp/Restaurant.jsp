<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List, com.tap.model.Restaurant"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Foodify - Restaurants</title>

	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/common.css">
	
	<link rel="stylesheet"
	      href="<%= request.getContextPath() %>/css/restaurant.css">


</head>

<body>

<jsp:include page="/includes/navbar.jsp" />
<!-- ================= HERO ================= -->

<div class="hero">

    <h1>Discover the Best Food Near You</h1>

    <p>
        Order delicious food from your favourite restaurants
    </p>

</div>


<!-- ================= SEARCH ================= -->

<div class="search-box">

    <input type="text"
           id="searchInput"
           placeholder="Search for restaurants or cuisines..."
           onkeyup="searchRestaurants()">

</div>


<!-- ================= RESTAURANTS ================= -->

<div class="container">

    <div class="section-title">

        <h2>Restaurants</h2>

        <span>
            Explore delicious food
        </span>

    </div>


    <%
    
    List<Restaurant> restaurants =
        (List<Restaurant>) request.getAttribute("restaurant");

    if (restaurants != null && !restaurants.isEmpty()) {
    
    %>

    <div class="restaurant-grid" id="restaurantGrid">

        <%
        
        for(Restaurant restaurant : restaurants) {
        
        %>

        <div class="restaurant-card">

            <!-- Restaurant Image -->

            <%
            if (restaurant.getImagePath() != null &&
                !restaurant.getImagePath().isEmpty()) {
            %>

                <img
                    class="restaurant-image"
                    src="<%= restaurant.getImagePath() %>"
                    alt="<%= restaurant.getName() %>"
                >

            <%
            } else {
            %>

                <div class="image-placeholder">
                    🍽️
                </div>

            <%
            }
            %>


            <!-- Card Content -->

            <div class="card-content">

                <div class="restaurant-name">
                    <%= restaurant.getName() %>
                </div>


                <div class="cuisine">
                    <%= restaurant.getCuisineType() %>
                </div>


                <div class="restaurant-info">

                    <span class="rating">
                        ⭐ <%= restaurant.getRating() %>
                    </span>

                    <span class="delivery-time">
                        🕒 <%= restaurant.getDeliveryTime()+" Minutes" %>
                    </span>

                </div>


                <div class="address">
                    📍 <%= restaurant.getAddress() %>
                </div>


                <a
                    class="view-menu"
                    href="MenuController?restaurantId=<%= restaurant.getRestId() %>">

                    View Menu

                </a>

            </div>

        </div>


        <%
        }
        %>

    </div>

    <%
    
    } else {
    
    %>

        <div class="empty-message">

            <h3>No Restaurants Found</h3>

            <p>
                Currently there are no restaurants available.
            </p>

        </div>

    <%
    }
    %>

</div>


<!-- ================= FOOTER ================= -->

 <jsp:include page="/includes/footer.jsp" />


<!-- ================= SEARCH JAVASCRIPT ================= -->

<script>

function searchRestaurants() {

    let input =
        document.getElementById("searchInput")
        .value
        .toLowerCase();

    let cards =
        document.querySelectorAll(".restaurant-card");

    cards.forEach(function(card) {

        let restaurantName =
            card.querySelector(".restaurant-name")
            .innerText
            .toLowerCase();

        let cuisine =
            card.querySelector(".cuisine")
            .innerText
            .toLowerCase();

        if (
            restaurantName.includes(input) ||
            cuisine.includes(input)
        ) {

            card.style.display = "";

        } else {

            card.style.display = "none";

        }

    });

}

</script>

</body>

</html>