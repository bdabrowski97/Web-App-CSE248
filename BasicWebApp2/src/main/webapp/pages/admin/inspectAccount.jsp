<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.brandon.BasicWebApp2.model.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	<% Account acc = (Account) session.getAttribute("inspectingAccount"); %>
	
	<h1>INSPECTING <%out.print(acc.getUsername()); %></h1>
	<p>NAME<br><%out.print(acc.getName().toString()); %><br><br>PASSWORD<br><%out.print(acc.getPassword()); %><br><br>ADDRESS<br><%out.print(acc.getAddress().toString()); %><br><br>
	<button onclick=window.location="http://localhost:8080/inspectAccountPurchases">View Purchase History</button>
	<br>
	<br>
	<br>
	<button onclick=window.location="http://localhost:8080/viewAllAccounts">Go Back</button>
	</p>
	
	
	

</body>
</html>