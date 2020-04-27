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
	<button onclick=window.location="http://localhost:8080/userInfoSettings">Change User Info</button>
	<button onclick="test()">click</button>
	<button  onclick=window.location="http://localhost:8080/userHomePage"> go back</button>
</body>
</html>