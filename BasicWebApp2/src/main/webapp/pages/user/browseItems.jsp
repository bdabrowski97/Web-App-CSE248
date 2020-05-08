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
<% Store store = (Store) session.getAttribute("shopHere");
	ArrayList<Item> items = (ArrayList<Item>) session.getAttribute("itemsInThisStore");%>
	
	<h1>Browsing <%out.print(store.getName()); %> Items</h1>
	
	
	<br>
	<br>
	<br>
	
	<button onclick=window.location="http://localhost:8080/browseStores">Go Back & Empty Cart</button>
	<button onclick=window.location="http://localhost:8080/viewCart">View Cart</button>
	
	<br>
	<br>
	<br>
	
	<form action="addToCart">
		<input type="text" name="itemID"	placeholder="ITEM ID">
		<input type="submit">
	</form>
	
	<br>
	<br>
	<br>
	
	
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Price</th>
			</tr>
		</thead>
		<% for (int i = 0; i < items.size(); i++) { %>
			<tr>
				<td>
					<% out.print(items.get(i).getItemID()); %>
				</td>
				<td>
					<% out.print(items.get(i).getName()); %>
				</td>
				<td>
					<% out.print(items.get(i).getDescription()); %>
				</td>
				<td>
					$<% out.print(items.get(i).getPrice()); %>
				</td>
				
				
				
			
			</tr>
		
			<%} %>
		
		</table>
	
	

</body>
</html>