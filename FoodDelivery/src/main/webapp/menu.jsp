<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.dao.model.Restaurant, com.dao.model.Menu"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Menu List</title>
    <link rel="icon" href="images/login.png">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="menu.css">
</head>
<body>
    <div class="navbar">
         <div class="img"><img alt="delivery" src="images\login.png" width="70px" height="70px" margin-top="20px"></div>
         <navbar>
            <a href="home.jsp"><i class='bx bxs-food-menu'></i> Restaurants</a>
            <a href="#"><i class='bx bxs-phone'></i> Contact</a>
            <a href="cart.jsp"><i class='bx bxs-cart'></i> Cart</a>
        <navbar>
    </div>

    <div class="container">
        <h1>Menu Items</h1>
        <div class="menu-container">
            <% 
            int restaurantId = (int) session.getAttribute("restaurantId");
            ArrayList<Menu> menuList = (ArrayList<Menu>) request.getAttribute("menus");
            
            for(Menu m : menuList){
            %>
            <div class="menu-card">
                <div class="menu-details">
                    <h2 class="menu-title"><%= m.getName() %></h2>
                    <p class="menu-description"><%= m.getDescription() %></p>
                    <p class="menu-price">₹<%= m.getPrice() %></p>
                    <form action="cart" method="post">
                        <input type="hidden" name="action" value="add">
                        <input type="hidden" name="itemId" value="<%= m.getMenu_id() %>">
                        <input type="hidden" name="restaurantId" value="<%= session.getAttribute("restaurantId") %>">
                        <button type="submit" class="add-to-cart">Add to Cart</button>
                    </form>
                </div>
                <img src="<%= request.getContextPath() + m.getImagePath() %>" alt="<%= m.getName() %>" class="menu-image">
            </div>
            <% } %>
        </div>
        <a href="home.jsp" class="back-button">Back to Restaurants</a>
    </div>
      <div class="footbar">
        <p>&copy; 2023 Restaurant Listing. All rights reserved.</p>
    </div>
</body>
</html>

