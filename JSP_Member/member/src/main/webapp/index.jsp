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
<h1>Login Index Page</h1>
<form action="/mem/login" method="post">
	id : <input type="text" name="id">
	password : <input type="password" name="password">
	<button type="submit">login</button>
</form>
<!-- 로그인 시 표현될 정보  ne(!= 같지않다.), eq(== 같다) -->
<c:if test="${ses.id eq null }">
Main <br>
</c:if>

<c:if test="${ses.id ne null }">
	hello!! ${ses.id } login<br>
	your email is ${ses.email }<br>
	your age is ${ses.age }<br>
	<a href="/mem/logout">logout</a>
	<a href="/mem/modify">Member modify</a>
	<a href="/mem/remove?id=${ses.id }"><button type="button">delete</button></a>
</c:if>


<a href="/mem/join">Join(회원가입)</a>
<a href="/mem/list">Member List</a>

<script type="text/javascript">
const msg_login = '<c:out value="${msg_login}" />';
if(msg_login === '0'){
	alert('로그인 실패');
}
</script>

</body>
</html>