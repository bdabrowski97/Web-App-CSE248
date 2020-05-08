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
<% Store store = (Store) session.getAttribute("store");
	ArrayList<Purchase> sales = (ArrayList<Purchase>) session.getAttribute("sales"); %>
	
	<button onclick=window.location="http://localhost:8080/viewAllStores">Go Back</button><br>
	<button onclick=window.location="http://localhost:8080/forceClose">Force Close</button>
	
	<p>
	STORE<br>
	<%out.print(store.getName()); %><br><br>
	</p>
	
	
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
		<% for (int i = 0; i < sales.size(); i++) { %>
			<tr>
				<td>
					<%out.print(sales.get(i).getPurchaseID()); %>
				</td>
				<td>
					<%out.print(sales.get(i).getStoreName()); %>
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