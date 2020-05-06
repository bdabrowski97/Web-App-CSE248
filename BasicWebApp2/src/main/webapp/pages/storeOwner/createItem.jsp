<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.brandon.BasicWebApp2.model.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	
	<h1>Create Item</h1>
	
	
	<form action="createItemFunction">
		<input type="text" name="name" placeholder="NAME"><br>
		<input type="text" name="description" placeholder="DESCRIPTION"><br>
		<input type="text" name="price" placeholder="PRICE"><br>
		<input type="submit"><br>
	</form>
	
	
	<br><br><br>
	<button onclick=window.location="http://localhost:8080/manageItems">Go Back</button>

</body>
</html>