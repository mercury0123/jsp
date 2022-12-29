<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Login Page</title>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
    
</head>
	<style>
		@font-face{
            font-family: 'Pacifico', cursive;
            src:url(font/Pacifico/Pacifico-Regular.ttf)
         }
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        h1 {
			font-family: 'Pacifico', cursive;                
        	text-align: center;
        	color: rgb(9, 104, 110);
        }
        body{
            background-color: rgb(9, 104, 110);
        }
        .container{
            width: 300px;
            margin: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: aliceblue;
            text-align: center;
            padding: 20px;
            border-radius: 5px;
        }
        input {
            width: 250px;
            margin: 5px;
            padding: 8px;
            border: 0px;
            border-radius: 5px;
        }
        .login {
            margin-bottom: 25px;           
            background-color: rgb(9, 104, 110);
            cursor: pointer;
        }
        a {
            font-size: 1rem;
        }
    </style>
<body>


	<div class="container">
	<h1>
		Login Page
	</h1>
       <form action="/mem/login_auth" method="post">
           <input type="text" name="email" placeholder="이메일"><br>
           <input type="password" name="pwd" placeholder="비밀번호"><br>
           <input class="login" type="submit" style="color:white" value="로그인">
       </form>       
       <a href="/mem/join" target="_blank">회원가입</a>&nbsp;|&nbsp;
       <a href="/home.jsp" target="_blank">홈으로</a>
       
       
    </div>    
</body>
</html>	