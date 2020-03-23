<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Ghost Kitchen Web App Project</title>
	<link rel="stylesheet" href="styles/homeStyle.css" />
	<script src="js/homeScript.js"></script>

</head>


<body>

	<h1 onclick="goToMeme()">NOTTA FORUM</h1>
	<p><strong>Leave a message or something idk</strong></p>

	
	<form action="addMsg" onsubmit="msgConfirmed()">
		<input  type="text" name="aid"><br>
		<input type="text" name="aname"><br>
		<input type="submit"><br>
	</form>
	<br>
	
	<button onclick="goToConsole()">Console</button>
	<button onclick="testAlert()">Test</button>
	


</body>
</html>