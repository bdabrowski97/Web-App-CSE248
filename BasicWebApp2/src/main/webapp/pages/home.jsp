<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="com.brandon.BasicWebApp2.model.*" %>
<%@ page import="java.util.ArrayList" %>
<html>
<head>

	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ghost Kitchen Web App Project</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
	<script src="js/homeScript.js"></script>

</head>


<body>
	<p><%= TestClass.capsMsg("stay at home club") %></p>
	<h1 onclick="goToMeme()">FINAL PROJECT</h1>
	<br>
	<p><button onclick=window.location="http://localhost:8080/register">REGISTER</button> <button onclick=window.location="http://localhost:8080/login">LOGIN</button></p>

	<!--  
	<form action="addMsg" onsubmit="msgConfirmed()">
		<input  type="text" name="aid"><br>
		<input type="text" name="aname"><br>
		<input type="submit"><br>
	</form>
	<br>
	
	<button onclick="goToConsole()">Console</button>
	<button onclick="testAlert()">Test</button> -->
	
	<table>
	<thead>
		<tr>
			<th>Username</th>
			<th>OwnsStore?</th>
		</tr>
	</thead>
		<% Account[] array = (Account[]) session.getAttribute("array"); %>
			<%for (int i = 0; i < array.length; i++) { %>
				<tr>
					<td>
						<% out.print(array[i].getUsername()); %>
					</td>
					<td>
						<%if (array[i].isStoreOwner() == true) { out.print("StoreOwner");} if (array[i].isAdmin() == true){ out.print("Admin");} else { out.print("User");}%>
					</td>
				</tr>
			
			
			<%} %>
		
	</table>
	
	
	
	
	
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<p>Project by Brandon Dabrowski</p>
	


</body>
</html>