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
	<h1>Hello StoreOwner <%out.print(username); %></h1>
	<br>
	<p><button onclick=window.location="http://localhost:8080/accountSettingsPage">Account Settings</button>
	<button onclick=window.location="http://localhost:8080/storeSplash">Store Management</button>
	<button onclick=window.location="http://localhost:8080">Logout</button>
	
	
	
</body>
</html>