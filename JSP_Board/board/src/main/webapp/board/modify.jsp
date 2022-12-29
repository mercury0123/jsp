<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Page</title>
</head>
<body>
<h1>Board Modify Page</h1>
	<form action="/brd/update" method="post">
		BNO : <input type="text" name="bno" value="${bvo.bno }" readonly="readonly"><br>
		TITLE : <input type="text" name="title" value="${bvo.title }"><br>
		WRITER : <input type="text" name="writer" value="${bvo.writer }" readonly="readonly"><br>
		CONTENT : <textarea rows="3" cols="30" name="content">${bvo.content }</textarea><br>
		<button type="submit">수정</button>
	</form>
</body>
</html>