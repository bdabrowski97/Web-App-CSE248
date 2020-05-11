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

	<h1>CART</h1>
	<br>
	<br>
	<br>
	
	
	<%
		ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
		cart.calculatePrice();
		cart.calculateSubtotal();
		ArrayList<Item> items = cart.getItems();
		
		double total = cart.getPrice();
		double subtotal = cart.getSubtotal();
	%>
	
	<p>SUBTOTAL: $<%out.print(subtotal); %>
	<br>TOTAL: $<%out.print(total); %></p>
	

<table class="center">
		<thead>
			<tr>
				<th>Item</th>
				<th>Price</th>
			</tr>
		</thead>
		
		<% for (int i = 0; i < items.size(); i++) { %>
			<tr>
				<td>
					<%out.print(items.get(i).getName()); %>
				</td>
				<td>
					$<%out.print(items.get(i).getPrice()); %>
				</td>
			</tr>
			<%} %>
			
	</table>		
		
	<br><br><br>
	<p><button onclick=window.location="http://localhost:8080/checkOut">CHECKOUT</button></p>
	
	
	

</body>
</html>