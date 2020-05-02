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
	<p style="color:red">Error: Entry Invalid</p>
	<h1>CREATE STORE</h1>
	<form action="createStoreFunction">
		<input type="text" name="storeName" placeholder="NAME"><br>
		<input type="text" name="storeTag" placeholder="TAG"><br>
		<input type="submit"><br>
	</form>
	<br><br>
	<p>"Tag" your store with a brief description of what you're selling. <br> ex: "Pizza"</p>

</body>
</html>