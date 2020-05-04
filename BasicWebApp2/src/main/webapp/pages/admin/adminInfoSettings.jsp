<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	<h1 style="color:red">Admin</h1>
	<form action="accountInfoSettingsFunction">
			<input type="text" name="password" placeholder="PASSWORD"><br>
			<input type="text" name="firstName" placeholder="FIRST NAME"><br>
			<input type="text" name="lastName" placeholder="LAST NAME"><br>
			<hr>
			<input type="text" name="street" placeholder="STREET"><br>
			<input type="text" name="city" placeholder="CITY"><br>
			<input type="text" name="state" placeholder="STATE"><br>
			<input type="text" name="zipCode" placeholder="ZIPCODE"><br>
			<input type="text" name="country" placeholder="COUNTRY"><br>
			<input type="submit"><br>
		</form>
		
		<br>
		<br>
		<button  onclick=window.location="http://localhost:8080/accountSettingsPage">Go Back</button>
	

</body>
</html>