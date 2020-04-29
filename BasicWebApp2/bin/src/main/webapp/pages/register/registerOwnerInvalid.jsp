<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="styles/registerUserStyle.css" />
	<title>Register Store Owner</title>
</head>
<body>
<h1>ENTER STORE OWNER INFO</h1>
	<p style="color:red">Invalid Entry</p>
	<form action="addStoreOwner">
		User Name: <input type="text" name="username"> First Name: <input type="text" name="firstname"><br>
		Password: <input type="text" name="password"> Last Name: <input type="text" name="lastname"><br>
		<hr>
		Street: <input type="text" name="street"> City: <input type="text" name="city"><br>
		State: <input type="text" name="state"> Zip Code: <input type="text" name="zipcode"> Country: <input type="text" name="country"><br>
		<input type="submit"><br>

	WE NEED A PAGE TO GENERATE STORE INFORMATION AS WELL, SHOULD THIS GO BEFORE OR AFTER THO??

	</form>
</body>
</html>