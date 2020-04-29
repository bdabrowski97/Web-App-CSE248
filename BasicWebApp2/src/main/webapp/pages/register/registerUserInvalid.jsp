<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles/registerUserStyle.css" />
	<title>Register User</title>
</head>
<body>
<h1>ENTER USER INFO</h1>
	<p style="color:red">Invalid Entry</p>
	<form action="addUser">
		<input type="text" name="username" placeholder="USERNAME"> <input type="text" name="firstname" placeholder="FIRST NAME"><br>
		<input type="text" name="password" placeholder="PASSWORD"> <input type="text" name="lastname" placeholder="LAST NAME"><br>
		<hr>
		<input type="text" name="street" placeholder="STREET"> <input type="text" name="city" placeholder="CITY"><br>
		<input type="text" name="state" placeholder="STATE"> <input type="text" name="zipcode" placeholder="ZIP CODE">
		<input type="text" name="country" placeholder="COUNTRY"><br>
		<input type="submit"><br>


	</form>
</body>
</html>