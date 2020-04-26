/**
 * 
 */

function goToMeme(){
	window.location="http://localhost:8080/meme";
}

function goToConsole(){
	window.location="http://localhost:8080/h2-console"
}

function msgConfirmed(){
	alert("Message Submitted");
}


function testAlert(){
	alert("Test");
}

function storeName(){
	
	sessionStorage.setItem('storedName', document.getElementById('username').innerHTML ); 
	/*
	 * THIS WORKS FOR TAKING THE TEXT FROM A SPACE ON THE WEBPAGE
	 */
	
	window.location="http://localhost:8080/usernext";
	
}

function pasteName(){
	document.getElementById("result").innerHTML = localStorage.getItem("lastname");
}

function test(){
	alert(sessionStorage.getItem("storedName"));
	
}