<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
</head>
<body>
<p>
  <button class="btn btn-primary" type="button" data-bs-toggle="collapse" data-bs-target="#collapseWidthExample" aria-expanded="false" aria-controls="collapseWidthExample">
    My First Project Board & Member!!
  </button>
</p>		
<div style="min-height: 120px;">
  <div class="collapse collapse-horizontal" id="collapseWidthExample">
    <div class="card card-body" style="width: 400px;">    	
    	${ses.email}로 로그인 하였습니다. <br>
		계정생성일 : ${ses.reg_at }<br>
		마지막 접속 : ${ses.last_login} <br>			
    </div>
  </div>
</div>		
<hr>	
		<c:if test="${ses.email ne null && ses.email ne ''}">
			<a href="/mem/modify?email=${mvo.email }"><button type="button" class="btn btn-success">회원정보수정</button></a>
			<a href="/mem/logout?email=${ses.email }"><button type="button" class="btn btn-success">로그아웃</button></a>
		</c:if>	
		<hr>
		<c:if test="${ses.email ne null && ses.email ne ''}">
			<a href="/brd/register"><button type="submit" class="btn btn-outline-primary" >글 쓰기</button></a>
		</c:if>
		<a href="/brd/pageList"><button type="submit" class="btn btn-outline-primary" >글 목록</button></a>
		<a href="/brd/list"><button type="submit" class="btn btn-outline-primary" >내 작성글 목록</button></a>
		<hr>
		<a href="/mem/login"><button type="submit" class="btn btn-outline-secondary">로그인</button></a>
		<a href="/mem/join"><button type="submit" class="btn btn-outline-secondary">회원가입</button></a>
		<a href="/mem/list"><button type="submit" class="btn btn-outline-secondary">회원명단</button></a>		
		<c:if test="${ses.email ne null && ses.email ne ''}">
			<a href="/mem/remove"><button type="submit" class="btn btn-outline-danger">회원탈퇴</button></a>
		</c:if>
	</body>
</html>