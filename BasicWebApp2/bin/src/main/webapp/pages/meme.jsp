<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>meme page</title>
<link rel="stylesheet" href="styles/memeStyle.css" />
<script>
function goToHome(){
	window.location="http://localhost:8080/"
}
</script>
</head>


<body>

<img src="images/meme.png" alt="woops" onclick="goToHome()">

</body>
</html>