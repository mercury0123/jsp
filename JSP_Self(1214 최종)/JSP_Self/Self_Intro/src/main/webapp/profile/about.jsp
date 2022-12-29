<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>About</title>
    <link rel = "stylesheet" href = "/css/main.css">
    <link rel = "stylesheet" href = "/css/about.css">
    <style>
    @import url('https://fonts.googleapis.com/css2?family=Roboto+Slab&display=swap');
       
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
</head>
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
      <div class ="two">
          <img class = "me" src="/img/boy.png" alt="" width="350px;" height="400px">
          <h3 class ="intext"> <strong>What would I lose if I learn coding?<br>Absoultely nothing!</strong><br><br>
            Hello! I'm Michael. Welcome to my homepage.<br>
            I majored in Law and worked as a law firm manager in South Korea. <br>
            After I 've retired a law firm. I 've study in this EZEN-Academy. <br>
            I don't want to see myself in the law service industry in the few years. <br>
            The reason I want to be a fullstack program engineer is that <br>
            there is no limits for studying and developing myself! <br>
            Passion is one of my motivation of my life. <br><br>
            To be a great engineer, <br>
            studying and developing myself constantly <br>
            is the most important thing, I think.
            <br><br>
            For the future junior program engineer!</h3>
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