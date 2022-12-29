<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Page</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
<h1>Board Modify Page</h1>
	<form action="/brd/update" method="post" enctype="multipart/form-data">
		BNO : <input type="text" name="bno" value="${bvo.bno }" readonly="readonly"><br>
		TITLE : <input type="text" name="title" value="${bvo.title }"><br>
		WRITER : <input type="text" name="writer" value="${ses.email}" readonly="readonly"><br>
		CONTENT : <textarea rows="3" cols="30" name="content">${bvo.content }</textarea><br>
		Image_File :
		<input type="hidden" name="image_file" value="${bvo.image_file }">
		<input type="file" name="new_file" 
		accept="image/png,image/jpeg,image/gif,image/jpg"><br>
		<button type="submit" class="btn btn-outline-primary">수정</button>
	</form>
<a href="/index.jsp"><button type="submit" class="btn btn-outline-primary">처음으로</button></a>
</body>
</html>