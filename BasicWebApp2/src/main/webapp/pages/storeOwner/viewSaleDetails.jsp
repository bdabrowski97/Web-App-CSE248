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
	<% Purchase purchase = (Purchase) session.getAttribute("inspectSale"); %>
	<% ArrayList<ItemBought> itemsBought = (ArrayList<ItemBought>) session.getAttribute("itemsInSale"); %>
	
	<h1>PURCHASE DETAILS</h1>
	<p>
	SOLD TO<br>
	<%out.print(purchase.getUserID()); %><br><br>
	
	SUBTOTAL<br>
	$<%out.print(purchase.getSubTotal()); %><br><br>
	
	TOTAL<br>
	$<% out.print(purchase.getTotal()); %><br><br>
	
	DATE PURCHASED<br>
	<% out.print(purchase.getDate().toString()); %><br><br>
	
	ITEMS BOUGHT<br></p>
	<table class="center">
	<thead>
		<th>Item</th>
		<th>Price</th>
	</thead>
		<% for (int i = 0; i < itemsBought.size(); i++) { %>
			<tr>
				<td>
					<%out.print(itemsBought.get(i).getName()); %>
				</td>
				<td>
					$<%out.print(itemsBought.get(i).getPrice()); %>
				</td>
			</tr>
		
			<%} %>
		</table>
	
	
	<br><br><br>
	<p>
	
	<button onclick=window.location="http://localhost:8080/cancelSale">CANCEL ORDER</button>
	<br><br><br>
	<button onclick=window.location="http://localhost:8080/viewMyPurchases">Go Back</button>
	
	</p>
	

</body>
</html>