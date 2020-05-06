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
	<h1>All Accounts</h1>
	<button onclick=window.location="http://localhost:8080/managementMenu">Go Back</button>
	<br><br><br>
	
	<table>
	<thead>
		<tr>
			<th>Order ID</th>
			<th>Username</th>
			<th>Total</th>
		</tr>
	</thead>
		<% Purchase[] array = (Purchase[]) session.getAttribute("siteWidePurchases"); %>
			<%for (int i = 0; i < array.length; i++) { %>
				<tr>
					<td>
						<% out.print(array[i].getOrderID()); %>
					</td>
					<td>
						<% out.print(array[i].getUserID()); %>
					</td>
					<td>
						<%out.print(array[i].getStoreName()); %>
					</td>
					<td>
						$<%out.print(array[i].getTotal()); %>
					</td>
					
				</tr>
			
			<%} %>
		
	</table>
	

</body>
</html>