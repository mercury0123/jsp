<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account Page</title>
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
    
    footer{
    	position: fixed; bottom:0px; width:100%; height: 80px;
		background-color: #0D6EFD; 
		color:white; text-align: center; line-height: 40px;
		font-size: 20px
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
	
	
	.head {
		margin-top: 50px;	 	
	}
	.head h1 {
	 	font-family: 'Pacifico', cursive;
		text-align: center;
		font-size: 4em;
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
	 
	.card_card-body{
		position: relative;
		margin: auto;
		text-align: center;  
	}
	hr {
	 	width : 50%;
	 	margin-left : auto;
	 	margin-right : auto;
		border : 0px;
		border-top: 5px solid #663399;
	}
</style>
<body>
<header>
계정통합관리 페이지
</header>
<nav>
<a href="member/join.jsp">회원가입</a> &nbsp;|&nbsp; <a href="member/login.jsp">로그인</a>&nbsp;|&nbsp; <a href="home.jsp"> 홈으로</a>
</nav>

<section>
	<div class="container">	
		<div class="head">
		<h1>Account Page</h1> <br>
		</div>
		<p>
		  <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
		    계정 및 접속정보 확인(클릭)
		  </button>
		</p>
		<div class="main">
			<div style="min-height: 120px;">
			  <div class="collapse collapse-horizontal" id="collapseWidthExample">
			    <div class="card_card-body" style="width: 700px;">    	
			    	<b>${ses.email} (${ses.nick_name})</b> 로 로그인 하였습니다. <br>
					계정생성일 : ${ses.reg_at }<br>
					마지막 접속 : ${ses.last_login}			
			    </div>
			  </div>
			</div>
		</div>
	
		<hr>
		<div class="footer">
			<c:if test="${ses.email ne null && ses.email ne ''}">
				<a href="/mem/modify?email=${mvo.email }"><button type="button" class="btn btn-success">회원정보수정</button></a>
				<a href="/mem/logout?email=${ses.email }"><button type="button" class="btn btn-success">로그아웃</button></a>
				<a href="/index.jsp"><button type="button" class="btn btn-outline-success">게시판</button></a>
			</c:if>
		<hr>			
			<a href="/mem/join"><button type="submit" class="btn btn-outline-secondary">회원가입</button></a>
			<a href="/mem/login"><button type="submit" class="btn btn-outline-secondary">로그인</button></a>
			<a href="/mem/list"><button type="submit" class="btn btn-outline-secondary">회원명단</button></a>		
			<a href="/home.jsp"><button type="button" class="btn btn-secondary">홈으로</button></a>
			<c:if test="${ses.email ne null && ses.email ne ''}">
				<a href="/mem/remove"><button type="submit" class="btn btn-outline-danger">회원탈퇴</button></a>
			</c:if>
		</div>
		<div class="bottom">
			
		</div>
		
	</div>
</section>

<footer>
<a href="profile/profile.jsp">PROFILE</a>&nbsp;|&nbsp;<a href="/index.jsp">BOARD</a>&nbsp;|&nbsp;<a href="account.jsp">ACCOUNT</a>&nbsp;&nbsp;<br>
www.michael.com COPYRIGHTⓒ 2022 ALL RIGHTS RESERVED.
Created by Michael
</footer>
</body>
</html>