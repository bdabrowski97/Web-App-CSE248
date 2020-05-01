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
	
	<% String store = (String) session.getAttribute("storedStoreName"); %>
	
	<h1>Manage <% out.print(store); %> </h1>
	<button>Manage Items</button>
	<button>Change Store Info</button>
	<button>View Sales</button>
	<button>Open/Close Store</button>
	<button onclick=window.location="http://localhost:8080/homePage">Go Back</button>
	

</body>
</html>