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
	
	<p>NAME<br>${modelName}<br><br>ADDRESS<br>${modelAddress}<br><br>CREDITCARD<br>${modelPaymentInfo}<br></p>
	
	
	<button  onclick=window.location="http://localhost:8080/accountSettings">Go Back</button>
	
</body>
</html>