<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>
<h1>
Login Page
</h1>
<form action="/mem/login_auth" method="post">
	Email : <input type="text" name="email"><br>
	Password : <input type="password" name="pwd"><br>
	<button type="submit">login</button>
</form>
</body>
</html>	