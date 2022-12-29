<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>What I love</title>
    <link rel = "stylesheet" href = "/css/main.css">
    <link rel = "stylesheet" href = "/css/favorites.css">
    
</head>
<style>
	@import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
   
	.container {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
		margin: auto;
		text-align: center;        
	}
	.progress {
		opacity: 0.6;
	}
	.progress:hover {
		transform: scale(1.1);
	    transition: 0.5s linear;
	    opacity: 1.0;
	}
	.progress-bar1 {
	    width: 100%;
	    height: 30px;
	    background: linear-gradient(to right, #6EB4E5 0 72%, #DEDEDE 72% 100%);
	    font-weight: 600;
	    font-size: .8rem;
	}
	.progress-bar2 {
	    width: 100%;
	    height: 30px;
	    background: linear-gradient(to right, #6EB4E5 0 92%, #DEDEDE 92% 100%);
	    font-weight: 600;
	    font-size: .8rem;
	}
	.progress-bar3 {
	    width: 100%;
	    height: 30px;
	    background: linear-gradient(to right, #6EB4E5 0 88%, #DEDEDE 88% 100%);
	    font-weight: 600;
	    font-size: .8rem;
	}
	.progress-bar4 {
	    width: 100%;
	    height: 30px;
	    background: linear-gradient(to right, #6EB4E5 0 82%, #DEDEDE 82% 100%);
	    font-weight: 600;
	    font-size: .8rem;
	}
	.menu a {
		font-size: 2em;
	}

    .menu a:hover {
    	color : yellow;
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
	a:hover {
    	color : yellow;
    }
 </style>
<body>
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
<div class="container">
    <div class="list">
        <div class="three">
            <div class = "favorites">
                <div class="lists">
                    <img class = "list_img" src="/img/java.jpg" alt="">
                    <p class = "list_text"> Java</p>
                    	<div class="progress">
							<div class="progress-bar1">72%</div>
						</div>
                </div>
  
                <div class="lists">
                    <img class = "list_img" src="/img/htmlcssjs.jpg" alt="">
                    <p class = "list_text"> Html/CSS/JS</p>
                    <div class="progress">
                    	<div class="progress-bar2">92%</div>
                    </div>
                </div>
  
                <div class="lists">
                    <img class = "list_img" src="/img/sql.jpg" alt="">
                    <p class = "list_text"> MySql</p>
                    <div class="progress">
                    	<div class="progress-bar3">88%</div>
                    </div>
                </div>
  
                <div class="lists">
                    <img class = "list_img" src="/img/jsp.jpg" alt="">
                    <p class = "list_text"> JSP</p>
                    <div class="progress">
                    	<div class="progress-bar4">82%</div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<footer>
<a href="/profile/profile.jsp">PROFILE</a>&nbsp;|&nbsp;<a href="/index.jsp">BOARD</a>&nbsp;|&nbsp;<a href="/account.jsp">ACCOUNT</a>&nbsp;&nbsp;<br>
www.michael.com COPYRIGHT(C) 2022 ALL RIGHTS RESERVED.
Created by Michael
</footer>
</body>
</html>