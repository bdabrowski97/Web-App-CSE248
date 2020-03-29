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

	<form action="addUser">
		User Name: <input type="text" name="username"> First Name: <input type="text" name="firstname"><br>
		Password: <input type="text" name="password"> Last Name: <input type="text" name="lastname"><br>
		<hr>
		Street: <input type="text" name="street"> City: <input type="text" name="city"><br>
		State: <input type="text" name="state"> Zip Code: <input type="text" name="zipcode"> Country: <input type="text" name="country"><br>
		<input type="submit"><br>


	</form>
</body>
</html>