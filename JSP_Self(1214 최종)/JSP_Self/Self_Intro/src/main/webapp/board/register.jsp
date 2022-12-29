<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">    
<title>Register Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
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
        	margin : 50px 50px;
        }
       
        .container{
            width: 600px;
            margin: 0;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translate(-50%,-50%);
            background-color: rgb(255, 238, 216);
            text-align: center;
            padding: 20px;
            border-radius: 5px;
        }
        input {
            width: 250px;
            margin: 5px;
            padding: 8px;
            border: 1px solid brown; 
            border-radius: 5px;
        }
        
        textarea {
        	border: 1px solid brown; 
            border-radius: 5px;
        }
        .login {
            margin-bottom: 25px;           
            background-color: rgb(9, 104, 110);
            cursor: pointer;
            background-color:rgb(255, 207, 149);
        }
        a {
            font-size: 0.4rem;
        }
    </style>
<body>
<div class="header"></div>

<div class="container">
	<h1>Board Register Page</h1>
	<div class="main">
		<form action="/brd/insert" method="post" enctype="multipart/form-data">
		 	<input type="text" name="title" placeholder="제목입력"><br>
	        <input type="text" name="writer" value="${ses.email }" readonly="readonly"><br>
	        <textarea rows="10" cols="30" name="content" placeholder="내용입력"></textarea><br>
	        <input type="file" id="file" name="image_file" 
				accept="image/png,image/jpeg,image/gif,image/jpg"><br>
	        <input class="login" type="submit" style="color:brown" value="등록">		
		</form>
		<a href="/index.jsp"><button type="submit" class="btn btn-outline-primary" >게시판</button></a>
		<a href="/home.jsp"><button type="submit" class="btn btn-outline-primary">홈으로</button></a>
	</div>
</div> 
<div class="footer"></div>
</body>
</html>