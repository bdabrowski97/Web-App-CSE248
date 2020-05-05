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
	<h1>All Stores</h1>
	<button onclick=window.location="http://localhost:8080/managementMenu">Go Back</button>
	<br><br><br>
	
	<form action="inspectAccount">
		<input type="text" name="username" placeholder="VIEW ACCOUNT"><br>
		<input type="submit"><br>
	</form>
	<br>
	<br>
	<br>
	
	<table>
	<thead>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Owner</th>
		</tr>
	</thead>
		<% Store[] array = (Store[]) session.getAttribute("allStores"); %>
			<%for (int i = 0; i < array.length; i++) { %>
				<tr>
					<td>
						<% out.print(array[i].getStoreID()); %>
					</td>
					<td>
						<% out.print(array[i].getName()); %>
					</td>
					<td>
						<% out.print(array[i].getOwner().toString()); %>
					</td>
				</tr>
			
			
			<%} %>
		
	</table>
	

</body>
</html>