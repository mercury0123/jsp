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
		<th>EMAIL</th>
		<th>PASSWORD</th>		
		<th>Nick_Name</th>
		<th>Reg_At</th>
		<th>Last_Login</th>
		
	</tr>
	<c:forEach items="${list }" var="mvo">
		<tr> 
			<th>${mvo.email }</th>
			<th>${mvo.pwd }</th>		
			<th>${mvo.nick_name }</th>
			<th>${mvo.reg_at }</th>
			<th>${mvo.last_login }</th>
		</tr>
	</c:forEach>
</table>
<a href="/"><button type="submit">처음으로..</button></a>
</body>
</html>