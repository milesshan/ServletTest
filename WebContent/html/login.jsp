<!DOCTYPE html>
<html>
<head>
	<title>Mom and Pop's Shop</title>
	<link rel="stylesheet" href="css/style.css">
	<meta charset="ISO-8859-1">
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
		</div>
	</header>
	<section id="login" class="section">
		<div class="container tagline">
			<% 
			if(request.getAttribute("error") != null){ 
			%>
			<em><%=request.getAttribute("error")%></em><br />
			<%
			}
			%>

			<em>LOGIN USER</em>
			<form action="login" method="post">
				<label>Username</label>
				<input type="text" name="username" id="username"><br /> 
				<label>Password</label>
				<input type="password" name="password" id="password"><br />
				<input type="submit" value="Login">
			</form>
		</div>
	</section>
</body>
</html>