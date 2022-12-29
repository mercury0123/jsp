<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
</head>
<body>
<h1>
Join Page
</h1>
<form action="/mem/register" method="post">
	Email : <input type="text" name="email"><br>
	Password : <input type="password" name="pwd"><br>
	Nick_Name : <input type="text" name="nick_name"><br>
	<button type="submit">join</button>
</form>
</body>
</html>	<!-- 이거 끝나고 MemberController ㄱㄱ-->