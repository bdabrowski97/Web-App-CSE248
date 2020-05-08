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
	
	<% ArrayList<Purchase> purchases = (ArrayList<Purchase>) session.getAttribute("myPurchases"); %>
	<h1>MY PURCHASES</h1>
	
	<br>
	<br>
	<br>
	
	<button onclick=window.location="http://localhost:8080/shopSplash">Go Back</button>
	
	<br>
	<br>
	<br>
	
	<form action="viewPurchaseDetails">
		Inspect Purchase <input type="text" name="purchaseID" placeholder="PURCHASE ID">
		<input type="submit"><br>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Store</th>
				<th>Total</th>
				<th>Status</th>
				<th>Date</th>
			</tr>
		</thead>
		<% for (int i = 0; i < purchases.size(); i++) { %>
			<tr>
				<td>
					<%out.print(purchases.get(i).getPurchaseID()); %>
				</td>
				<td>
					<%out.print(purchases.get(i).getStoreName()); %>
				</td>
				<td>
					$<%out.print(purchases.get(i).getTotal()); %>
				</td>
				<td>
					<%if (purchases.get(i).isCanceled() == true) { out.print("CANCELED"); } else { out.print("open");}%>
				</td>
				<td>
					<%out.print(purchases.get(i).getDate().toString()); %>
				</td>
			
			
			</tr>
		
			<%} %>
		
		</table>
	

</body>
</html>