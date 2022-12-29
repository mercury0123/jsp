<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
</head>
<style>
 	@import url('https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap');
 		
    *{              
        margin: 0;
        padding: 0;
        box-sizing: border-box;            
    }
   
    h1 {
    	
    	text-align: center;
    	margin : 50px 50px;
    }
    a {    
		text-decoration : none;
		color : white;
	}
	
    header{    
		position: fixed; top:0px; width:100%; height: 60px;
		background-color: #0D6EFD; 
		font-family: 'Dongle', sans-serif;
		color:white; 
		text-align: center; 
		line-height: 60px;
		font-size: 60px	
  	}
    
	nav{
	   	position:fixed; top:60px; width:100%; height:40px;
		background-color:lightblue; 
		font-family: 'Dongle', sans-serif;
		color : white; 
		text-align: right;  
		line-height: 40px; 
		padding-right: 40px;  
		font-size: 30px  	
    }
	    
    footer{
    	position: fixed; bottom:0px; width:100%; height: 80px;
		background-color: #0D6EFD; 
		color:white; text-align: center; line-height: 40px;
		font-size: 20px
    }
	
    .container{
        width: 600px;
        margin: 0;
        position: absolute;
        top: 50%;
        left: 50%;
        transform: translate(-50%,-50%);
        text-align: center;
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
</style>
<body>
<header>
글 작성 페이지
</header>
<nav>
<a href="/brd/register">게시글 등록</a>&nbsp;|&nbsp;<a href="/brd/list">리스트로</a> &nbsp;|&nbsp; <a href="/index.jsp"> 홈으로</a>
</nav>

<section>
<div class="container">

	<div class="header"><h1>Board Register Page</h1></div>
	
	<div class="main">

		<form action="/brd/insert" method="post">
			<input type="text" name="title" placeholder="제목입력"><br>
	        <input type="text" name="writer" placeholder="작성자입력"><br>
	        <textarea rows="10" cols="30" name="content" placeholder="내용입력"></textarea><br>
			<button type="submit" class="btn btn-danger">등록</button>
			<a href="/brd/list"><button type="button" class="btn btn-outline-primary">리스트</button></a>
			<a href="/index.jsp"><button type="button" class="btn btn-primary">홈으로</button></a>
		</form>
	
	</div>
</div> 
</section>
<footer>
<a href="/brd/register">REGISTER</a>&nbsp;|&nbsp;<a href="/brd/list">LIST</a>&nbsp;|&nbsp;<a href="/index.jsp">HOME</a><br>
Hong Soon Gyu COPYRIGHTⓒ 2022 ALL RIGHTS RESERVED.
Created by Hong
</footer>
</body>
</html>