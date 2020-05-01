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
	<button>Change Account Info</button>
	<button>View Account Info</button>
	<button onclick=window.location="">Go Back</button>
	

</body>
</html>