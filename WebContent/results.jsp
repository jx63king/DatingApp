<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" %>
<html>
<head>
<!-- Bootstrap4 CSS -->
<link rel="stylesheet"
	href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
	<title>Matching Results</title>
</head>
<body>
<div class="container">
	<h1 class="title">Matching Results</h1>
	<table class="table table-striped">
		<thead>
		    <tr>
		      <th scope="col">User ID</th>
		      <th scope="col">First Name</th>
		      <th scope="col">Last Name</th>
		      <th scope="col">Age</th>
		      <th scope="col">Gender</th>
		      <th scope="col">Sexual Orientation</th>
		      <th scope="col">Location</th>
		      <th scope="col">Relationship Type</th>
		      <th scope="col">Attractiveness</th>
		      <th scope="col">Hobby</th>
		      <th scope="col">Personality</th>
		    </tr>
	  	</thead>
	  	<tbody>
		  	<c:forEach var="usr" items="${listUsr}" varStatus="status">
				<tr>
					<!-- td>${status.index + 1}</td-->
					<td>${usr.userId}</td>
					<td>${usr.userFName}</td>
					<td>${usr.userLName}</td>
					<td>${usr.userAge}</td>
					<td>${usr.userGender}</td>
					<td>${usr.userOrientation}</td>
					<td>${usr.userZip}</td>
					<td>${usr.userRelationship}</td>
					<td>${usr.userAttractiveness}</td>
					<td>${usr.userHobby}</td>
					<td>${usr.userPersonality}</td>

					
					
			
				</tr>
			</c:forEach>	  	
	  	</tbody>		
	</table>
</div>
	
${msg}
</body>

<style type="text/css">
.title {
	text-align: center;
	margin: 20px;
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
