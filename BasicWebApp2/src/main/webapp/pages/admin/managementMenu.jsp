<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	<% String username = (String) session.getAttribute("storedUsername"); %>
	<h1><% out.print(username); %> Admin Management</h1>
	<br>
	<p>
	<button onclick=window.location="http://localhost:8080/viewAllAccounts">View Accounts</button>
	<button onclick=window.location="http://localhost:8080/viewAllStores">View Stores</button>
	<button onclick=window.location="http://localhost:8080/viewAllPurchases">View Purchases</button>
	<button onclick=window.location="http://localhost:8080/homePage">Go Back</button>
	</p>

</body>
</html>