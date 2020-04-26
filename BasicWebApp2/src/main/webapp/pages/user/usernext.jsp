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
		String useThis = (String) session.getAttribute("storedUsername");
	
	%>
	
	<h1>Hello <%out.println(useThis); %></h1>
	<button onclick="test()">test</button>
	
	<button onclick="pasteName()">click</button>
	<button  onclick=window.location="http://localhost:8080/userHomePage"> go back</button>
</body>
</html>