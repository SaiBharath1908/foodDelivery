<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="com.dao.model.Cart,java.util.Map,com.dao.model.CardItem, com.dao.model.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart Page</title>
<link rel="icon" href="images/login.png">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="cart.css">
</head>


<body>

	<div class="navbar">
		<div class="img">
			<img alt="delivery" src="images\login.png" width="70px" height="70px" margin-top="20px">
		</div>
		<navbar>
		<a href="home.jsp"><i class='bx bxs-home'></i>Home</a>
		<a href="home.jsp"><i class='bx bxs-food-menu'></i>Restaurants</a>
		<a href=""><i class='bx bxs-phone'></i>Contact Us</a> 
		</navbar>
	</div>
	<%
        // Check if the user is logged in
        User user = (User ) session.getAttribute("loggedUser");
        if (user == null) {
    %>
	<div class="empty-cart">
		<h2>User is not logged in</h2>
		<a href="login.jsp">Log in here</a>
	</div>
	<%
        } else {
            // User is logged in, check the cart
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart(); // Create a new cart if it doesn't exist
                session.setAttribute("cart", cart); // Set the cart in the session
            }

            // Check if the cart is empty
            if (cart.getItems().isEmpty()) {
    %>
	<div class="empty-cart">
		<h1>Cart is empty</h1>
		<a href="home.jsp" class="browse-link">Browse here</a>
	</div>
	<%
            } else {
    %>
	<div class="cart-items">
		<%
                    double total_amount = 0;
                    for (Map.Entry<Integer, CardItem> entry : cart.getItems().entrySet()) {
                        CardItem item = entry.getValue();
                        total_amount += item.getPrice() * item.getQunantity();
                    %>
		<div class="cart-item">
			<div class="cart-details">
				<h2>
					Item Name:
					<%= item.getName() %></h2>
				<p>
					Price:
					<%= item.getPrice() %></p>
				<p>
					Quantity:
					<%= item.getQunantity() %></p>
			</div>
			<div class="cart-action">
				<form action="cart" method="post" class="update-quantity-form">
					<input type="hidden" name="action" value="update"> <input
						type="hidden" name="itemId" value="<%= item.getMenu_id() %>">
					<button type="submit" name="quantity"
						value="<%= item.getQunantity() - 1 %>">-</button>
					<span><%= item.getQunantity() %></span>
					<button type="submit" name="quantity"
						value="<%= item.getQunantity() + 1 %>">+</button>
				</form>

				<form action="cart" method="post" class="remove-quantity-form">
					<input type="hidden" name="action" value="remove"> <input
						type="hidden" name="itemId" value="<%= item.getMenu_id() %>">
					<button type="submit">Remove</button>
				</form>
			</div>
		</div>
		<% } %>
	</div>
	<h3>
		Total amount: Rs.<%= total_amount %></h3>
	<div class="total-amount-container">
		<a
			href="menu?restaurantId=<%= session.getAttribute("restaurantId") %>"
			class="add-btn">Add more items</a> <a href="checkout.jsp"
			class="checkout">Proceed to checkout</a>
	</div>
	<%
            }
        }
    %>
      <div class="footbar">
        <p>&copy; 2023 Restaurant Listing. All rights reserved.</p>
    </div>
</body>
</html>