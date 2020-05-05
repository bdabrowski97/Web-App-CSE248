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
	<% String username = (String) session.getAttribute("viewThisAccount"); %>
	
	<h1>INSPECTING <%out.print(username); %></h1>
	<p>NAME<br>${theirName}<br><br>PASSWORD<br>${theirPassword}<br><br>ADDRESS<br>${theirAddress}<br><br></p>
	<button>View Purchase History</button>
	<button onclick=window.location="http://localhost:8080/viewAllAccounts">Go Back</button>
	
	
	

</body>
</html>