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
	
	<form action="adminViewPurchase2">
		<input type="text" name="purchaseID" placeholder="PURCHASE ID">
		<input type="submit">
	</form>
	
	<br>
	<br>
	<br>
	
	<table>
	<thead>
		<tr>
			<th>Order ID</th>
			<th>Store</th>
			<th>Total</th>
			<th>Status</th>
		
		</tr>
	</thead>
		<% ArrayList<Purchase> array =  (ArrayList<Purchase>) session.getAttribute("theirPurchases"); %>
			<%for (int i = 0; i < array.size(); i++) { %>
				<tr>
					<td>
						<% out.print(array.get(i).getPurchaseID()); %>
					</td>
					
					<td>
						<% out.print(array.get(i).getStoreName()); %>
					</td>
					
					<td>
						$<% out.print(array.get(i).getTotal()); %>
					</td>
					<td>
						<% if (array.get(i).isCanceled() == true) { out.print("CANCELLED"); } else { out.print("open");} %>
					</td>
					
					
				</tr>
			
			<%} %>
		
	</table>
	

</body>
</html>