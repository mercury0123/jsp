<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>	<!-- 이걸 써줘야 EL 사용가능 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<table border="1">
		<thead>
			<tr>
				<th>PNO</th>
				<th>PNAME</th>
				<th>REGDATE</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list}" var="pvo">
			<tr>
				<td>${pvo.pno}</td>
				<!-- 품명을 누르면 해당 품목을 상품 상세페이지로 갈 수 있도록 pno값까지 준다 -->
				<td><a href="detail.pd?pno=${pvo.pno}">${pvo.pname}</a></td>
				<td>${pvo.regdate}</td>
			</tr>
			</c:forEach>
			
		</tbody>
	</table>
	<a href="register.pd">Register</a>
</body>
</html>