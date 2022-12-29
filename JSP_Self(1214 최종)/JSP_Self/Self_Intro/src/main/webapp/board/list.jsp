<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List page</title>
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
	
	.header h1 {
		font-family: 'Pacifico', cursive;
		margin-top:50px;
		text-align: center;
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
	
	.btn1{
		display :inline-block;
	}
	
	table {
		margin-left:auto; 
		margin-right:auto;
	}

	table, td, th {
	    border-collapse : collapse;
	    border : 1px solid black;
	    text-align: center;
	}
	
	td #tit {
		color : black;
	}
	td #tit:hover{
		color : green;
		font-weight: 400;
	}
	
	.footer_btn {
		text-align: center;
		
	}
	.btn2{
		display :inline-block;
	}
	
	hr {
	 	width : 60%;
	 	margin-left : auto;
	 	margin-right : auto;
	 	border : 0px;
		border-top: 5px solid #ff7b00;
	}
	
	
</style>
<body>
<header>
전체 글 목록 페이지
</header>
<nav>
<a href="member/join.jsp">회원가입</a> &nbsp;|&nbsp; <a href="member/login.jsp">로그인</a>&nbsp;|&nbsp; <a href="home.jsp"> 홈으로</a>
</nav>

<section>	
	<div class="container">
		<div class="header">
			<h1>Board List Page</h1>
		</div>
		<hr>
		<table>
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
			<c:forEach items="${list }" var="bvo">
				<tr>
					<td>${bvo.bno }</td>
					<td>
						<!-- image 파일이 있을 때, a태그 앞쪽에 첨부파일 그림 추가 -->
						<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }"> 
							<img alt="없음" src="/_fileUpload/th_${bvo.image_file }">
						</c:if>
						<a id="tit" href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a>
					</td>
					<td>${bvo.writer }</td>
					<td>${bvo.reg_date }</td>
					<td>${bvo.read_count}</td>
				</tr>
			</c:forEach>
		</table>
		<hr>
			
	<div class="body">
		<!-- page 표시 구현 -->
		<p>
		<c:if test="${pgh.prev }">
			<a href="/brd/page?pageNo=${pgh.startPage-1 }&qty=${pgh.pgvo.qty }"><button class="btn btn-outline-success btn1">prev</button></a>
		</c:if>
	
		
		<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
			<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}"><button class="btn btn-success btn1">${i }</button></a>
		</c:forEach>
		
		<c:if test="${pgh.next }">
			<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty }"><button class="btn btn-outline-success btn1">next</button></a>
		</c:if>
		</p>
		
	</div>

	<div class="footer_btn">
		<c:if test="${ses.email ne null && ses.email ne ''}">
			<a href="/brd/register"><button type="submit" class="btn btn-outline-primary btn2" >글 쓰기</button></a>
		</c:if>
			<a href="/"><button type="submit" class="btn btn-outline-primary btn2" >게시판 홈으로</button></a>
			<a href="/home.jsp"><button type="submit" class="btn btn-outline-primary btn2">홈으로</button></a>
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