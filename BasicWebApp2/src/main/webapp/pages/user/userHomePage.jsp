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
<%
	// use % symbols to use java codes 
	String username = (String) session.getAttribute("storedUsername");

%>
	
	<h1>Welcome User <% out.println(username); %></h1>
	<button onclick=window.location="http://localhost:8080/accountSettingsPage">Account Settings</button>
	<button>Shop</button>
	<button onclick=window.location="http://localhost:8080/">Logout</button>

</body>
</html>