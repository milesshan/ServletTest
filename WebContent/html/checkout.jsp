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
		</div>
	</header>
	<section id="checkout" class="section">
		<div class="container">
	    	<h2 class="headline">Checkout</h2>
	    	<% 
			if(request.getAttribute("error") != null){ 
			%>
			<em><%=request.getAttribute("error")%></em><br />
			<%
			} 
			%>
	    </div>    
	    <form action="checkout" method="post">
		    <label>Buying vegetables: </label><input autocomplete='off' type="text" name="vegetables" id="vegetables" 
		    value=<%=request.getAttribute("vegetables")%>><br />
		    <label>Buying baked goods: </label><input autocomplete='off' type="text" name="bakedGoods" id="bakedGoods" 
		    value=<%=request.getAttribute("bakedGoods")%>><br />
		    <label>Buying meats: </label><input autocomplete='off' type="text" name="meats" id="meats" 
		    value=<%=request.getAttribute("meats")%>><br />
		    <input type="submit" value="Order">
	    </form>
	</section>
</body>
</html>
