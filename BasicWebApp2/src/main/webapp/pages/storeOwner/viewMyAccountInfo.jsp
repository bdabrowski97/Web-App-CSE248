<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="js/homePageScript.js"></script>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	<%
		String username = (String) session.getAttribute("storedUsername");
	%>
	
	<p>NAME<br>${modelName}<br><br>ADDRESS<br>${modelAddress}<br><br></p>
	
	
	<p><button  onclick=window.location="http://localhost:8080/accountSettingsPage">Go Back</button></p>
	
</body>
</html>