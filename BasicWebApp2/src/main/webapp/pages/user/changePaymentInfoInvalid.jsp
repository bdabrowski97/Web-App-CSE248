<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<script src="js/homePageScript.js"></script>
	<link rel="stylesheet" href="styles/homeStyle.css" />
</head>
<body>
	<p style="color:red">Error: Invalid Entry</p>
	
		<form action="changePaymentInfoFunction">
			Note: Enter 0 for every category to delete current payment information<br><br>
			<input type="text" name="num" placeholder="NUMBER 0000 0000 0000 0000"><br>
			<input type="text" name="cvc" placeholder="CVC 000"><br>
			<input type="text" name="expdate" placeholder="EXPDATE 0000"><br>
			<hr>
			<input type="submit"><br>
		</form>
		<br>
		<br>
		<button onclick=window.location="http://localhost:8080/accountSettings">Go Back</button>
	
	
</body>
</html>