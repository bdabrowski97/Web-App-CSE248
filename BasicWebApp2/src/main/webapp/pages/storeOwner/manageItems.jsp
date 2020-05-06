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

	<button onclick=window.location="http://localhost:8080/storeSplash">Go Back</button>
	<br><br><br>
	<button onclick=window.location="http://localhost:8080/createItem">Add Item</button>
	<br><br><br>
	<form action="deleteThisItem">
		Delete This Item: <input type="text" name="id" placeholder="ITEM ID">
		<input type="submit">
	</form>
	<br><br><br>
	
	<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Item</th>
			<th>Description</th>
			<th>Price</th>
		
		</tr>
	</thead>
		<% ArrayList<Item> array =  (ArrayList<Item>) session.getAttribute("myItems"); %>
			<%for (int i = 0; i < array.size(); i++) { %>
				<tr>
					<td>
						<% out.print(array.get(i).getItemID()); %>
					</td>
					
					<td>
						<% out.print(array.get(i).getName()); %>
					</td>
					
					<td>
						<% out.print(array.get(i).getDescription()); %>
					</td>
					
					<td>
						$<% out.print(array.get(i).getPrice()); %>
					</td>
				</tr>
			
			<%} %>
		
	</table>

</body>
</html>