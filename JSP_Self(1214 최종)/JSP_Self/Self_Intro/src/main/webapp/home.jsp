<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
<style>
	@font-face{
	   font-family: 'Pacifico', cursive;
	   src:url(font/Pacifico/Pacifico-Regular.ttf)
	}
	html, body {
	    margin: 0;
	    padding: 0;
	    height: 100%;
	}  
	.container {
	    margin: 0;
	    padding: 0;
	    display: flex;
	    height: 100%;
	    color : grey;
	}
	
	.nav {
	    background-color: rgb(182, 220, 255);
	    margin: 0;
	    padding: 0;
	    width: 20%;
	}
	
	.nav h1 {
	    font-family: 'Pacifico', cursive;
	    margin-top: 20px;
	    text-align: center;
	    font-size: 2em;
	    color : grey;
	}
	
	ul {
	    margin-top: 60px;
	    padding-left: 30px;
	    list-style-type: none;
	}
	
	li{        
	    margin-bottom: 20px;
	}            
	
	.nav a {
	    text-decoration: none;
	    font-size: 1.5em;
	    color: white;
	}
	
	.nav a:hover {
	    color : grey;
	}
	
	.icon {            
	    text-align: center;  
	}  
	.icon i {
	    margin-top: 40px;
	    padding: 10px;
	}
	#icon2:hover {
	    color : rgb(0, 174, 255);
	}
	#icon1:hover {
	    color : #05446e;
	}
        
	.main {
	    width: 100%;
	    display: flex;
	    flex-direction: column;
	    justify-content: center;
	    align-items: center;
	    background: linear-gradient(rgba(0, 0, 0, 0),rgba(0, 0, 0, 0.7)),url(img/비행기.jpg);
	    background-size: cover;
	}


	.title {  
	    font-size: 3em;
	    color : white;
	}

	.btn {    
	    width: 150px;    
	    height: 50px;    
	    border: 2px solid white;    
	    background: linear-gradient(rgba(0, 0, 0, 0),rgba(0, 0, 0, 0));    
	    font-size: 20px;
	    color: white;
	    cursor: pointer;
	}
	.btn:hover {
		color : white;
	    font-weight: 400;
		font-size: 1.5em;
		transition: 0.3s linear;
	}        
</style>
</head>
<body>
	 <div class="container">
        <nav class="nav">
            <a href="#"><h1>Michael Mercury</h1></a>
            <ul>
                <li><a href="#">HOME</a></li>
                <li><a href="profile/profile.jsp">PROFILE</a></li>
                <li><a href="/index.jsp">BOARD</a></li>
                <li><a href="member/login.jsp">LOGIN</a></li>
                <li><a href="member/join.jsp">JOIN US</a></li>
                <li><a href="account.jsp">ACCOUNT</a></li>                
            </ul>
            <div class="icon">
               <a href=""><i id="icon1" class="fa fa-facebook-f fa-2x nav--icons-i"></i></a>
               <a href=""><i id="icon2" class="fa fa-twitter fa-2x nav--icons-i"></i></a>
            </div>
        </nav>
        <div class="main">
            <h1 class="title" >Welcome to Michael World!</h1>
            <a href="/profile/profile.jsp"><button class="btn">PROFILE</button></a>
        </div>
    </div>
</body>
</html>