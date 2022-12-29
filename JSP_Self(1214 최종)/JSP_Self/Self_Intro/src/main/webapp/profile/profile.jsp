<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile</title>
    <link rel = "stylesheet" href = "/css/main.css">
    <link rel = "stylesheet" href = "/css/scroll.css">
<style>
@import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
	
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
	
	.menu a {
		font-size: 2em;
	}

    .menu a:hover {
    	color : yellow;
    }
    a:hover {
    	color : yellow;
    }
</style>
</head>
<body>

<div id="container">
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
  <div class="list">
      <div class="one">
        <span class="profile"><img class="profile_img" src="/img/boy.png" width="300px" height="300px" alt=""/></span> 
        <h3><strong>Hello! I'm Michael.</strong> <br>You can click on nav_var if you want to see me more!</h3>
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