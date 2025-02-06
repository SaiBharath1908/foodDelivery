<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="stylesheet" href="login.css">
<link rel="icon" href="images/login.png">
</head>
<style>
 /* Responsive Design for Smaller Screens */
        @media (max-width: 480px) {
            .wrapper {
                padding: 20px;
                width: 80%;
            }
        }
    </style>
</head>
<body>

    <div class="wrapper">
        <h1>Login</h1>
        <form action="Login" method="post">
         <div class="input-details">
         <input type="email" name="email" id="email" placeholder="Email" required><i class='bx bxs-envelope'></i><br>
         <input type="password" name="password" id="password" placeholder="Password" required><i class='bx bxs-lock-alt'></i><br>
         </div>
		<div class="login-link"><button class="btn">Login</button></div>
        </form>
        <div class="reg-link"><p>If you're a new user? <a href="index.jsp">Register</a></p></div>
    </div>
    <!--<div class="img"><img alt="delivery" src="images/login.png"></div>-->

</body>
</html>