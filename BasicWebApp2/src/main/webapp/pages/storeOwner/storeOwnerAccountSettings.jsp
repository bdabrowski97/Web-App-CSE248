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
	<h1>StoreOwner <%out.print(username); %> Account Settings</h1>
	<br>
	<p><button onclick=window.location="http://localhost:8080/accountInfoSettings">Change Account Info</button>
	<button onclick=window.location="http://localhost:8080/viewMyAccountInfo">View Account Info</button>
	<button onclick=window.location="http://localhost:8080/homePage">Go Back</button>
	

</body>
</html>