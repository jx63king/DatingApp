<%@ page isELIgnored="false"%>
<html>
<head>
<title>Dashboard</title>
<!-- Bootstrap4 CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
</head>

<body>${msg}
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script type=”text/javascript” src=”bootstrap/js/bootstrap.min.js”></script>

<title>Online Dating App</title>
</head>

<nav class="navbar navbar-light fixed-top"
	style="background-color: #e3f2fd;">
	<a class="navbar-brand" href="#">Online Dating</a>
</nav>
<div>
	<h1 class="title">Find your match today!</h1>
</div>
<div>
	<div>
		<p class="message">Fill out the form in order to find out who will
			match with you from our database.</p>
	</div>
	<div>
		<p class="message">Our algorithm has been tested to find someone for you within
			your location, interests, and hobbies.</p>
	</div>
</div>
<div class="container">
	<form action="results" method="post" class="form">
		<h3 style="text-align:center; margin-bottom: 20px;">What are you looking for in a partner?</h3>
		<div class="form-group row">
			<div>
				<label class="label" for="guntypes">User ID:</label> 
				<input type="text" name="idUser" />
			</div>
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Interested in:</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userGender" value="Male" checked> 
				<label class="form-check-label">Male</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userGender" value="Female"> 
				<label class="form-check-label">Female</label>
			</div>
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Sexual Orientation:</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userOrientation" value="Straight" checked> 
				<label class="form-check-label">Straight</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userOrientation" value="Gay"> 
				<label class="form-check-label">Gay</label>
			</div>
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Location (Zipcode):</label>
				<input type="number" name="userZip" /> 
			</div>
			<div class="np">
				<input class="form-check-input" type="radio" name="userZip" value=0 /> 
				<label class="form-check-label">No preference</label>
			</div>
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Age:</label>
				<input type="number" name="userAgeL" /> 
				--
				<input type="number" name="userAgeH" /> 
			</div>
			<div class="np">
				<input class="form-check-input" type="radio" name="agePreference" value="No" /> 
				<label class="form-check-label">No preference</label>
			</div>
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Looking for: </label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userRelationship" value="Casual" checked /> 
				<label class="form-check-label">Short term</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userRelationship" value="Long-term" /> 
				<label class="form-check-label">Long term</label>
			</div>
			<div class="form-check form-check-inline">
				<input class="form-check-input" type="radio" name="userRelationship" value="No" /> 
				<label class="form-check-label">No preference</label>
			</div>		
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Personality: </label>
				<input class="input" type="text" name="userPersonality" />
			</div>		
			<div class="np">
				<input class="form-check-input" type="radio" name="userPersonality" value="No" /> 
				<label class="form-check-label">No preference</label>
			</div>	
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Hobby: </label>
				<input type="text" name="userHobby" />
			</div>			
			<div class="np">
				<input class="form-check-input" type="radio" name="userHobby" value="No" /> 
				<label class="form-check-label">No preference</label>
			</div>		
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Attractive scale: </label>
				<select name="userAttractiveness">
					<option value="1" selected>1</option>
					<option value="1">2</option>
					<option value="1">3</option>
					<option value="1">4</option>
					<option value="1">5</option>
					<option value="1">6</option>
					<option value="1">7</option>
					<option value="1">8</option>
					<option value="1">9</option>
					<option value="1">10</option>
				</select>
			</div>			
			<div class="np">
				<input class="form-check-input" type="radio" name="userAttractiveness" value="No" /> 
				<label class="form-check-label">No preference</label>
			</div>		
		</div>
		<div class="form-group row">
			<div>
				<label class="label">Top 3 options you would want the most:</label>
			</div>	
			<div class="select">
				<select name="rankFirst">
					<option value="location">location</option>
					<option value="hobby">hobby</option>
					<option value="attractiveness">attractiveness</option>
					<option value="relationship">relationship</option>
					<option value="age">age</option>
					<option value="personality">personality</option>
				</select>
			</div>
			<div class="select">
				<select name="rankSecond">
					<option value="location">location</option>
					<option value="hobby">hobby</option>
					<option value="attractiveness">attractiveness</option>
					<option value="relationship">relationship</option>
					<option value="age">age</option>
					<option value="personality">personality</option>
				</select>
			</div>		
			<div class="select">
				<select name="rankThird">
					<option value="location">location</option>
					<option value="hobby">hobby</option>
					<option value="attractiveness">attractiveness</option>
					<option value="relationship">relationship</option>
					<option value="age">age</option>
					<option value="personality">personality</option>
				</select>
			</div>				
		</div>
		<div class="form-group btn-container">
			<button type="submit" value="submit" class="btn btn-primary">Submit</button>
		</div>		
	</form>
</div>

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
.form {
	width: 800px;
	margin: 40px auto;
}
.btn-container {
	text-align: right;
}
.link {
	margin: auto 0px;
}
.label{
	width:200px;
}
.np{
	margin-left: 40px;
}
.select{
	margin-right: 40px;
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