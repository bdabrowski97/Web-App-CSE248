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
	
	<% ArrayList<Purchase> sales = (ArrayList<Purchase>) session.getAttribute("sales"); %>
	<h1>SALES</h1>
	
	<br>
	<br>
	<br>
	
	<button onclick=window.location="http://localhost:8080/storeSplash">Go Back</button>
	
	<br>
	<br>
	<br>
	
	<form action="viewSaleDetails">
		Inspect Purchase <input type="text" name="purchaseID" placeholder="PURCHASE ID">
		<input type="submit"><br>
	</form>
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>User</th>
				<th>Total</th>
				<th>Status</th>
				<th>Date</th>
			</tr>
		</thead>
		<% for (int i = 0; i < sales.size(); i++) { %>
			<tr>
				<td>
					<%out.print(sales.get(i).getPurchaseID()); %>
				</td>
				<td>
					<%out.print(sales.get(i).getUserID()); %>
				</td>
				<td>
					$<%out.print(sales.get(i).getTotal()); %>
				</td>
				<td>
					<%if (sales.get(i).isCanceled() == true) { out.print("CANCELED"); } else { out.print("open");}%>
				</td>
				<td>
					<%out.print(sales.get(i).getDate().toString()); %>
				</td>
			
			
			</tr>
		
			<%} %>
		
		</table>
	

</body>
</html>