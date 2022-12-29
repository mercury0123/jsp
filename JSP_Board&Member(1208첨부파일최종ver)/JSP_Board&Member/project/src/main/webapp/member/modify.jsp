<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</head>
<body>
<h1>Member Modify Page</h1>
<form action="/mem/update" method="post">
E-Mail : <input type="text" name="email" value="${ses.email }" readonly><br>
Password : <input type="text" name="pwd" value="${ses.pwd }"><br>
Nick_Name : <input type="text" name="nick_name" value="${ses.nick_name }"><br>
<input type="hidden" name="reg_at" value="${ses.reg_at }"><br>
<input type="hidden" name="last_loagin" value="${ses.last_login }"><br>
<button type="submit" class="btn btn-outline-primary">수정</button>
<a href="/index.jsp"><button type="submit" class="btn btn-outline-primary">처음으로</button></a>
</form>
</body>
</html>