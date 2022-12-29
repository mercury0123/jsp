<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Board Detail Page</h1>
	<table border="1">
		<tr>
			<th>BNO</th>
			<td>${bvo.bno}</td>
		</tr>
		<tr>
			<th>TITLE</th>
			<td>${bvo.title}</td>
		</tr>
		<tr>
			<th>WRITER</th>
			<td>${bvo.writer}</td>
		</tr>
		<tr>
			<th>REG_DATE</th>
			<td>${bvo.reg_date}</td>
		</tr>
		<tr>
			<th>CONTENT</th>
			<td>${bvo.content}</td>
		</tr>
	</table>
<a href="/brd/modify?bno=${bvo.bno }">수정</a><br>
<a href="/brd/remove?bno=${bvo.bno }">삭제</a><br>
<a href="/brd/list">리스트</a><br>
</body>
</html>