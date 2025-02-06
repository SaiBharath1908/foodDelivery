<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@  page
	import="java.util.*,com.dao.model.Restaurant,jakarta.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HOME -Restaurants</title>
<link rel="icon" href="images/login.png">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link rel="stylesheet" href="home.css">
</head>
<body>
	<div class="navbar">
		<div class="img">
			<img alt="delivery" src="images\login.png" width="70px" height="70px"
				margin-top="20px">
		</div>
		<navbar> <a href="home.jsp"><i class='bx bxs-home'></i>Home</a>
		<a href="home.jsp"><i class='bx bxs-food-menu'></i>Restaurants</a> <a
			href=""><i class='bx bxs-phone'></i>Contact Us</a> <a href="cart.jsp"><i
			class='bx bxs-cart'></i>Cart</a> </navbar>
	</div>
	<div class="search-img">
		<img alt="delivery" src="images/search-img.jpg">
		<div class="search">
			<input type="text" placeholder="search..."> <i
				class='bx bx-search'></i>
		</div>
	</div>



	<h1 class="welcome">
		Welcome
		<% out.println(session.getAttribute("name")); %>
	</h1>

	<div class="restaurant-grid">
		<% 
    ArrayList<Restaurant> rlist = (ArrayList<Restaurant>) session.getAttribute("Restaurants");
    if (rlist != null && !rlist.isEmpty()) {
        for(Restaurant r : rlist) {
%>
		<div class="restaurant-card">
			<img src="<%= request.getContextPath() + r.getImagePath() %>"
				alt="<%= r.getImagePath() %>" class="restaurant-image">
			<div class="restaurant-info">
				<div class="info-header">
					<h2 class="restaurant-name"><%= r.getName() %></h2>
					<div class="rating-chip">
						★
						<%= r.getRatings() %></div>
				</div>
				<p class="restaurant-address"><%= r.getAddress() %></p>
				<p class="cuisine-type"><%= r.getCuisineType() %></p>
				<a href="menu?restaurantId=<%= r.getRestaurant_id() %>"
					class="view-menu-btn">View Menu</a>
			</div>
		</div>
		<%}  
    } else {
%>
		<p>No restaurants available.</p>
		<% 
    }
%>%>
	</div>
	<div class="footbar">
		<p>&copy; 2023 Restaurant Listing. All rights reserved.</p>
	</div>
</body>
</html>

