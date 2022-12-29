<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Modify Page</h1>
<form action="/mem/update" method="post">
ID : <input type="text" name="id" value="${ses.id }" readonly><br>
Password : <input type="text" name="password" value="${ses.password }"><br>
email : <input type="text" name="email" value="${ses.email }"><br>
age : <input type="text" name="age" value="${ses.age }"><br>
<button type="submit">modify</button>
</form>

</body>
</html>