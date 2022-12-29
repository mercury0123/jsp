<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
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
	 	margin-bottom: 10px;
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
	
	 .body #image{
	 	width : 20%;
	 }
	table {
		margin-top:10px;
		margin-left:auto; 
		margin-right:auto;
	}

	table, td, th {
	    border-collapse : collapse;
	    border : 1px solid black;
	}
</style>
<body onload="printCommentList(${bvo.bno})">
<div class="container">
	<div class="header">
		<h1>Board Detail Page</h1>
	</div>
	<div class="body">
		<!-- image 파일이 있을 때, a태그 앞쪽에 첨부파일 그림 추가 -->
		<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }"> 
			<img id ="image" alt="없음" src="/_fileUpload/${bvo.image_file}">
		</c:if>	
	
		<table border="1">
			<tr>
				<th>게시글 번호</th>
				<td>${bvo.bno}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>${bvo.title}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${bvo.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td>${bvo.reg_date}</td>
			</tr>
			<tr>
				<th>조회수</th>
				<td>${bvo.read_count}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>${bvo.content}</td>
			</tr>
		</table>
	
		<!--  작성자가 일치해야만 수정삭제 가능  -->
		<!-- c태그 "" 사이에 빈공간 없어야만 작동 -->
		<c:if test="${ses.email eq bvo.writer}">
			<a href="/brd/modify?bno=${bvo.bno }"><button type="submit" class="btn btn-outline-primary">수정</button></a>
			<a href="/brd/remove?bno=${bvo.bno }"><button type="submit" class="btn btn-outline-danger">삭제</button></a>
		</c:if>
		<a href="/brd/pageList"><button type="submit" class="btn btn-outline-primary" >리스트</button></a>
		<a href="/home.jsp"><button type="submit" class="btn btn-outline-primary">홈으로</button></a>
	</div>
<hr>

<!-- 댓글 입력 영역 -->
<div>
	comment line<br>	
	<input type="text" id="cmtWriter" value="${ses.email}" readonly="readonly"><br>
	<input type="text" id="cmtText" placeholder="댓글입력란"><br>
	<p><button type="button" id="cmtAddBtn" class="btn btn-success">댓글등록</button></p>
</div>
<hr>
<!-- 댓글 출력 영역 -->
<div class="accordion" id="accordionExample">	
	<div class="accordion-item">
	    <h2 class="accordion-header" id="headingOne">
	      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
		        cno, bno, writer <!-- 내용 -->
	      </button>
	    </h2>
	    <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
	      <div class="accordion-body">
				content, reg_at	<!-- 댓글 내용 -->	        
	      </div>
	    </div>
	  </div>
</div>
</div>
<script type="text/javascript">
const bnoVal = '<c:out value="${bvo.bno}"/>';
</script>
<script src="/resources/board_detail.js"></script>
<script type="text/javascript">
printCommentList(bnoVal);
</script>
</body>
</html>