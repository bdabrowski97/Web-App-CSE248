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
	
	<form action="adminViewPurchase">
		<input type="text" name="purchaseID" placeholder="PURCHASE ID">
		<input type="submit">
	</form>
	
	<table>
	<thead>
		<tr>
			<th>Order ID</th>
			<th>Username</th>
			<th>Store</th>
			<th>Status</th>
			<th>Total</th>
			
		</tr>
	</thead>
		<% ArrayList<Purchase> array = (ArrayList<Purchase>) session.getAttribute("storeWidePurchases"); %>
			<%for (int i = 0; i < array.size(); i++) { %>
				<tr>
					<td>
						<% out.print(array.get(i).getPurchaseID()); %>
					</td>
					<td>
						<% out.print(array.get(i).getUserID()); %>
					</td>
					<td>
						<%out.print(array.get(i).getStoreName()); %>
					</td>
					<td>
						<% if (array.get(i).isCanceled() == true) { out.print("CANCELLED"); } else { out.print("open");} %>
					</td>
					<td>
						$<%out.print(array.get(i).getTotal()); %>
					</td>
					
				</tr>
			
			<%} %>
		
	</table>
	

</body>
</html>