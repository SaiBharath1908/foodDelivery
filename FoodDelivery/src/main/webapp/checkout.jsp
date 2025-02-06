<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Checkout Page</title>
    <link rel="stylesheet" href="checkout.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
    <div class="address">
    	<div class="container">
        <h1>Checkout</h1>
        <form action="checkout" method="post">
            <div class="form-group">
                <label for="houseNo">House No.</label>
                <input type="text" id="houseNo" name="houseNo" required>
            </div>
            <div class="form-group">
                <label for="street">Street</label>
                <input type="text" id="street" name="street" required>
            </div>
            <div class="form-group">
                <label for="landmark">Landmark</label>
                <input type="text" id="landmark" name="landmark">
            </div>
            <div class="form-group">
                <label for="city">City</label>
                <input type="text" id="city" name="city" required>
            </div>
            <div class="form-group">
                <label for="districtState">District, State</label>
                <input type="text" id="districtState" name="districtState" required>
            </div>
            <div class="form-group">
                <label for="pincode">Pincode</label>
                <input type="number" id="pincode" name="pincode" required>
            </div>
            
            <div class="payment-section">
                <div class="form-group">
                    <label for="paymentMethod">Payment Method</label>
                    <select id="paymentMethod" name="paymentmethod">
                        <option value="creditCard">Credit card</option>
                        <option value="debitCard">Debit card</option>
                        <option value="upi">UPI</option>
                        <option value="cod">Cash on Delivery</option>
                    </select>
                </div>
                <button type="submit">Place Order</button>
            </div>
        </form>
    </div>
    </div>
      <div class="footbar">
        <p>&copy; 2023 Restaurant Listing. All rights reserved.</p>
    </div>
</body>
</html>

