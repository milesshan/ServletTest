<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>Mom and Pop's Shop</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<header id="home" class="header">
		<nav class="nav" role="navigation">
			<div class="container nav-elements">
				<ul class="navbar">
					<li><a href="home">Home</a></li>
					<li><a href="products">Products</a></li>
					<li><a href="login">Login</a></li>
					<li><a href="registerUser">New User?</a></li>
					<li><a href="checkout">Checkout</a></li>
				</ul>
			</div>
		</nav>
		<div class="container tagline">
			<h1 class="headline">Welcome</h1>
			<p>Welcome to Mom and Pop's online store!</p>
			<%
			if (request.getAttribute("username") == null) {
				out.println("Guest");
			} else {
			out.println(request.getAttribute("username"));
			}
			%>
		</div>
	</header>
</body>
</html>
