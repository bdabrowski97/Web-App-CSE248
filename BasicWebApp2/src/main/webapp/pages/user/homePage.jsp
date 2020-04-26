<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
	<script src="js/homePageScript.js"></script>
	
</head>
<body>
	
	<h1>Welcome </h1> <h1 id='username'>${username}</h1> 
	<button onclick="storeName()" >store</button>
	<button onclick=window.location="http://localhost:8080/usernext">nextpage</button>

</body>
</html>