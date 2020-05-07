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
	<%String username = (String) session.getAttribute("storedUsername"); %>
	
	<h1><%out.print(username); %> Shopping</h1>
	<br>
	<br>
	<br>
	<button onclick=window.location="http://localhost:8080/browseStores">Browse Stores</button>
	<button>View/Cancel Purchases</button>
	<button onclick=window.location="http://localhost:8080/homePage">Go Back</button>
	
	<p>Note: You can only purchase from one store at a time.<br> Leaving a store's page will erase all contents of shopping cart.</p>
	
	

</body>
</html>