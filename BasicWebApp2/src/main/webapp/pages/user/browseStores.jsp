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
	<% ArrayList<Store> stores = (ArrayList<Store>) session.getAttribute("allStores"); %>
	<h1>Browse Stores</h1>
	<br>
	<br>
	<br>
	<button onclick=window.location="http://localhost:8080/shopSplash">Go Back</button>
	
	<br>
	<br>
	<br>
	
	<form action="searchForStores">
		<input type="text" name="search" placeholder="SEARCH STORE NAME OR TAG">
		<input type="submit">
	</form>
	
	<br>
	<br>
	<br>
	
	
	<form action="browseItems">
		<input type="text" name="shopID"	placeholder="SHOP ID">
		<input type="submit">
	</form>
	<br>
	<br>
	
		<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Tag</th>
			</tr>
		</thead>
		<% for (int i = 0; i < stores.size(); i++) { %>
			<tr>
				<td>
					<% out.print(stores.get(i).getStoreID()); %>
				</td>
				<td>
					<% out.print(stores.get(i).getName()); %>
				</td>
				
				<td>
					<% out.print(stores.get(i).getTags()); %>
				</td>
			
			</tr>
		
			<%} %>
		
		</table>
	
	

</body>
</html>