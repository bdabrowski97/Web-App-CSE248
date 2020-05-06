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
	
	<button onclick=window.location="http://localhost:8080/viewAllAccounts">Go Back</button>
	<br>
	<br>
	<br>
	
	<table>
	<thead>
		<tr>
			<th>Order ID</th>
			<th>Subtotal</th>
			<th>Total</th>
		
		</tr>
	</thead>
		<% ArrayList<Purchase> array =  (ArrayList<Purchase>) session.getAttribute("theirPurchases"); %>
			<%for (int i = 0; i < array.size(); i++) { %>
				<tr>
					<td>
						<% out.print(array.get(i).getOrderID()); %>
					</td>
					
					<td>
						<% out.print(array.get(i).getSubtotal()); %>
					</td>
					
					<td>
						<% out.print(array.get(i).getTotal()); %>
					</td>
					
					
				</tr>
			
			<%} %>
		
	</table>
	

</body>
</html>