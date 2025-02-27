<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration Page</title>
<link rel="stylesheet" href="register.css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="icon" href="https://cdn-icons-png.flaticon.com/512/7217/7217494.png" type="image/x-icon">

</head>
<body>
	<div class="wrapper">
		<form action="Register" method="post">
		<h1>Sign Up</h1>
		<div class="input-details">
			<input type="text" name="username" placeholder="Username" required><i class='bx bxs-user'></i><br>
			<input type="password" name="password" placeholder="Password" required><i class='bx bxs-lock-alt'></i><br>
			<input type="password" name="cpassword" placeholder="Confirm Password" required><br>
			<input type="email" name="email"placeholder="Email" required><i class='bx bxs-envelope'></i><br>
			<input type="text" name="address" placeholder="Address" required><br>
		</div>
		<div class="registration-link"><button class="btn">Register</button></div>
		<div class="login-link"><p>Already a user?<a href="login.jsp">Login</a></p></div>
	</form>
	</div>
</body>
</html>
