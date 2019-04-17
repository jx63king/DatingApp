<%@ page isELIgnored="false"%>

<html>
<head>
<!-- Bootstrap4 CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">

<title>Online Dating App</title>
</head>
<body>
	<nav class="navbar navbar-light fixed-top" style="background-color: #e3f2fd;">
		<a class="navbar-brand" href="#">Online Dating</a>
	</nav>
	<div>
		<div>
			<h1 class="message">Online Dating App</h1>
		</div>
		<div>
			<p class="message">Hello!</p>
		</div>
		<div>
			<p class="message">Please login into your account to view dating
				matches.</p>
		</div>
	</div>


	<div>
		<form action="login" method="post" class="form">
			<div class="form-group">
				<label for="exampleInputEmail1">User ID</label> 
				<input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter User ID" name="idUser" /> 
			</div>
			<div class="form-group">
				<label for="exampleInputPassword1">Password</label> 
				<input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="password" />
			</div>		
			<div>
				<a href="reg.jsp" class="link">Click here to Register</a>
				<button type="submit" value="submit" class="btn btn-primary">Login</button>
			</div>			
		</form>
		<p class="message">Create a new account in order to find your next relationship!</p>
	</div>


	${msg}
</body>

<style type="text/css">
.title {
	text-align: center;
}
.message {
	text-align: center;
	font-size: 18px;
	margin: 10px;
}
.form{
	width: 400px;
	margin: 40px auto;
}
.btn{
	float: right;
}
.link{
	margin: auto 0px;
}
</style>

<!-- jQuery -->
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<!-- popper.min.js -->
<script
	src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<!-- Bootstrap4 JavaScript -->
<script
	src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>

</html>