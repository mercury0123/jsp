<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Pacifico&display=swap" rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com"><link rel="preconnect" href="https://fonts.gstatic.com" crossorigin><link href="https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap" rel="stylesheet">
</head>
<style>
	@font-face{
    font-family: 'Pacifico', cursive;
    src:url(font/Pacifico/Pacifico-Regular.ttf)
    }
    
    @import url('https://fonts.googleapis.com/css2?family=Dongle:wght@700&display=swap');
    
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
    
    a {    
		text-decoration : none;
		color : white;
	}
	
	*{
	    margin: 0;
	    padding: 0;
	    box-sizing: border-box;	    
	}
	 
	body {
		background-color:bisque;
	}
	
	.container {
		position: absolute;
		top: 50%;
		left: 50%;
		transform: translate(-50%,-50%);
		margin: auto;
		text-align: center;        
	}
	.header h1{
		font-family: 'Pacifico', cursive;
	}
	table {		
		margin-left:auto; 
		margin-right:auto;
	}

	table, th {
	    border-collapse : collapse;
	    border : 1px solid black;
	    text-align: center;
	}
	
	.footer_btn {
		text-align: center;
		
	}
	.btn1{
		display :inline-block;
	}
	
	hr {
	 	width : 66%;
	 	margin-left : auto;
	 	margin-right : auto;
	 	border : 0px;
	  	border-top: 5px solid #663399;
	}
</style>
<body>
<header>
회원 리스트
</header>
<nav>
<a href="/member/join.jsp">회원가입</a> &nbsp;|&nbsp; <a href="/member/login.jsp">로그인</a>&nbsp;|&nbsp; <a href="/home.jsp"> 홈으로</a>
</nav>

<section>


<div class="container">
	<div class="header">
		<h1>Member List Page</h1>
	</div>
	<hr>
	<div class="main">
		<table border="1">
			<tr>
				<th>EMAIL</th>
				<th>PASSWORD</th>		
				<th>별명</th>
				<th>가입일</th>
				<th>최종접속일</th>
				
			</tr>
			<c:forEach items="${list }" var="mvo">
			<tr> 
				<th>${mvo.email }</th>
				<th>${mvo.pwd }</th>		
				<th>${mvo.nick_name }</th>
				<th>${mvo.reg_at }</th>
				<th>${mvo.last_login }</th>
			</tr>
			</c:forEach>
		</table>
	</div>
	<hr>
	<div class="footer_btn">
		<a href="/account.jsp"><button type="submit" class="btn btn-outline-success btn1">계정관리</button></a>
		<a href="/home.jsp"><button type="submit" class="btn btn-outline-success btn1">홈으로</button></a>
	</div>
</div>
</section>
<footer style="position: fixed; bottom:0px; width:100%; height: 80px;
background-color: #0D6EFD; color:white; text-align: center; line-height: 40px;
font-size: 20px">
<a href="/profile/profile.jsp">PROFILE</a>&nbsp;|&nbsp;<a href="/index.jsp">BOARD</a>&nbsp;|&nbsp;<a href="/account.jsp">ACCOUNT</a>&nbsp;&nbsp;<br>
www.michael.com COPYRIGHTⓒ 2022 ALL RIGHTS RESERVED.
Created by Michael
</footer>
</body>
</html>