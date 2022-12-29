<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Contact</title>
    <link rel = "stylesheet" href = "/css/main.css">
    <link rel = "stylesheet" href = "/css/contact.css">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
    
    
    .menu a {
		font-size: 2em;
	}

    .menu a:hover {
    	color : yellow;
    }
    a:hover {
    	color : yellow;
    }
    .container {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
		margin: auto;
		text-align: center;        
	}
    .ct_image:hover {
    	transform: scale(1.1);
	    transition: 0.5s linear;
	    opacity: 1.0;
    }
    
    footer{
    	position: fixed; bottom:0px; width:100%; height: 80px;		 
		background: linear-gradient(rgba(0, 0, 0, 0),rgba(0, 0, 0, 0));
		color:white; text-align: center; line-height: 40px;
		font-size: 20px
    }
    a {    
		text-decoration : none;
		color : white;
	}
    </style>
</head>
<body>
<div class="header">
    <header id = "header"> 
        <nav class ="menu">
            <ul>
                <li><a href = "/profile/profile.jsp"><b>Profile</b></a></li>
                <li><a href = "/profile/about.jsp"><b>About</b></a></li>
                <li><a href = "/profile/favorites.jsp"><b>What I Can</b></a></li>
                <li><a href = "/profile/contact.jsp"><b>Contact Me</b></a></li>
                <li><a href = "/home.jsp"><b>Home</b></a></li>
            </ul>
        </nav>
    </header> 
    </div>
<div class="container">
    <div class="list">        
      	<a href="" class="ct" ><img class="ct_image" src="/img/유튜브.png" alt="">Youtube</a>
      	<a href="" class="ct" ><img class="ct_image" src="/img/인스타.png" alt="">Insta</a>
      	<a href="" class="ct" ><img class="ct_image" src="/img/트위터.jpg" alt="">Twitter</a>
    </div>
</div>
<footer>
<a href="/profile/profile.jsp">PROFILE</a>&nbsp;|&nbsp;<a href="/index.jsp">BOARD</a>&nbsp;|&nbsp;<a href="/account.jsp">ACCOUNT</a>&nbsp;&nbsp;<br>
www.michael.com COPYRIGHT(C) 2022 ALL RIGHTS RESERVED.
Created by Michael
</footer>
</body>

</html>