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
	form {display: table}
</style>

<script>
function goToMeme(){
	window.location="http://localhost:8080/meme";
}
</script>
<script>
	function goToConsole(){
		window.location="http://localhost:8080/h2-console"
	}
</script>

</head>
<body>

	<h1 onclick="goToMeme()">NOTTA FORUM</h1>
	<p><strong>Leave a message or something idk</strong></p>

	
	<form action="addMsg">
		<input  type="text" name="aid"><br>
		<input type="text" name="aname"><br>
		<input type="submit"><br>
	</form>
	<br>
	
	<button onclick="goToConsole()">Console</button>




</body>
</html>