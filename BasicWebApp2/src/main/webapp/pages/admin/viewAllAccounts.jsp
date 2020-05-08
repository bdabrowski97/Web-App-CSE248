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
	
	<form action="inspectAccount">
		<input type="text" name="username" placeholder="VIEW ACCOUNT">
		<input type="submit"><br>
	</form>
	<br>
	<br>
	<br>
	
	<table>
	<thead>
		<tr>
			<th>Username</th>
			<th>Name</th>
			<th>AccountType</th>
		</tr>
	</thead>
		<% Account[] array = (Account[]) session.getAttribute("allAccounts"); %>
			<%for (int i = 0; i < array.length; i++) { %>
				<tr>
					<td>
						<% out.print(array[i].getUsername()); %>
					</td>
					<td>
						<% out.print(array[i].getName().toString()); %>
					</td>
					<td>
						<%if (array[i].isStoreOwner() == true) { out.print("StoreOwner");} else if (array[i].isAdmin() == true){ out.print("Admin");} else { out.print("User");}%>
					</td>
				</tr>
			
			
			<%} %>
		
	</table>
	

</body>
</html>