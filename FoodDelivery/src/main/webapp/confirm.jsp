<!DOCTYPE html>
<html>
<head>
<title>Order confirmed successfully</title>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
<link rel="icon" href="images/login.png">
<link rel="stylesheet" href="confirm.css">
</head>
<body>
<div class="navbar">
		<div class="img">
			<img alt="delivery" src="images\login.png" width="70px" height="70px" margin-top="20px"  border-radius= "30px">
		</div>
		<navbar>
		<a href="home.jsp"><i class='bx bxs-home'></i>Home</a>
		<a href="home.jsp"><i class='bx bxs-food-menu'></i>Restaurants</a>
		<a href=""><i class='bx bxs-phone'></i>Contact Us</a> 
		</navbar>
	</div>

<div id="popup" class="popup">
   <img alt="delivery" src="images/confirmed.gif">
</div>

<div class="hidden-content">
    <img src="images/scooty.gif" alt="Hidden Image">
    <h1>Order placed successfully</h1>
    <p>Order is being prepared and delivered soon......</p>
</div>
  <div class="footbar">
        <p>&copy; 2023 Restaurant Listing. All rights reserved.</p>
    </div>
<script type="text/javascript">
    window.onload = function() {
        var popup = document.getElementById('popup');
        var hiddenContent = document.querySelector('.hidden-content');
        
        setTimeout(function () {
            popup.style.opacity = '0';
            setTimeout(function() {
                popup.style.display = 'none';
                hiddenContent.style.display = 'flex';
            }, 500);
        }, 1300);
    };
</script>

</body>
</html>
