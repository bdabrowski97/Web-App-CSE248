<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Basic Web App Milestone</title>
<style>
	body {background-color: limegreen; font-family: verdana; }
	h1 {font-size: 10vw; text-align: center;}
	p {text-align: center;}
</style>

<script>
function goToMeme(){
	window.location="http://localhost:8080/meme";
}
</script>

</head>
<body>

	<h1 onclick="goToMeme()">NOTTA FOURM</h1>

	<form action="addAlien">
		<input type="text" name="aid"><br>
		<input type="text" name="aname"><br>
		<input type="submit"><br>
	</form>
	
	<p><strong>Hopefully This Works...</strong></p>


</body>
</html>