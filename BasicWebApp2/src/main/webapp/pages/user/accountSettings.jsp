<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="js/homePageScript.js"></script>
</head>
<body>
	<%
		String username = (String) session.getAttribute("storedUsername");
	%>
	
	<h1>Hello <%out.println(username); %></h1>
	<button onclick=window.location="http://localhost:8080/userInfoSettings">Change Account Info</button>
	<button onclick=window.location="http://localhost:8080/viewMyAccountInfo">View Account Info</button>
	<button onclick=window.location="http://localhost:8080/changeCreditInfo">Payment Method</button>
	<button  onclick=window.location="http://localhost:8080/userHomePage">Logout</button>
	
</body>
</html>