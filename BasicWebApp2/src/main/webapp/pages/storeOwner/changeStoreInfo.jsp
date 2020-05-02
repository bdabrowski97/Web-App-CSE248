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
	<form action="changeStoreInfoFunction">
		<input type="text" name="storeName" placeholder="NAME"><br>
		<input type="text" name="storeTag" placeholder="TAG"><br>
		<input type="submit"><br>
	</form>
	<br><br>
	<p>"Tag" your store with a brief description of what you're selling. <br> ex: "Pizza"</p><br>
	<button onclick=window.location="http://localhost:8080/storeSplash">Go Back</button>
	
</body>
</html>