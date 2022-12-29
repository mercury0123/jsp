<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List page</title>

</head>
<body>
	<h1>Board List Page</h1>
	<hr>
	<table border="1">
		<tr>
			<th>BNO</th>
			<th>TITLE</th>
			<th>WRITER</th>
			<th>REG_DATE</th>
			<th>READ_COUNT</th>
		</tr>
		<c:forEach items="${list }" var="bvo">
			<tr>
				<td>${bvo.bno }</td>
				<td>
					<!-- image 파일이 있을 때, a태그 앞쪽에 첨부파일 그림 추가 -->
					<c:if test="${bvo.image_file ne '' && bvo.image_file ne null }"> 
						<img alt="없음" src="/_fileUpload/th_${bvo.image_file }">
					</c:if>
					<a href="/brd/detail?bno=${bvo.bno }">${bvo.title }</a>
				</td>
				<td>${bvo.writer }</td>
				<td>${bvo.reg_date }</td>
				<td>${bvo.read_count}</td>
			</tr>
		</c:forEach>
	</table>
<div>
	<!-- page 표시 구현 -->
	<c:if test="${pgh.prev }">
		<a href="/brd/page?pageNo=${pgh.startPage-1 }&qty=${pgh.pgvo.qty }"><button>prev</button></a>
	</c:if>
	<c:forEach begin="${pgh.startPage }" end="${pgh.endPage }" var="i">
		<a href="/brd/page?pageNo=${i }&qty=${pgh.pgvo.qty}"><button>${i }</button></a>
	</c:forEach>
	<c:if test="${pgh.next }">
		<a href="/brd/page?pageNo=${pgh.endPage+1 }&qty=${pgh.pgvo.qty }"><button>next</button></a>
	</c:if>
</div>
<hr>
<a href="/index.jsp"><button type="submit" >처음으로</button></a>
</body>
</html>