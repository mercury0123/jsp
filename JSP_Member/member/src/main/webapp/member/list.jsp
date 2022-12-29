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
<h1>Member List Page</h1>
<table border="1">
	<tr>
		<th>ID</th>
		<th>PASSWORD</th>
		<th>EMAIL</th>
		<th>AGE</th>
	</tr>
	<c:forEach items="${list }" var="mvo">
	<tr> 
		<th>${mvo.id }</th>
		<th>${mvo.password }</th>
		<th>${mvo.email }</th>
		<th>${mvo.age }</th>
	</tr>
	
	</c:forEach>
</table>
<a href="/">index..</a>
</body>
</html>