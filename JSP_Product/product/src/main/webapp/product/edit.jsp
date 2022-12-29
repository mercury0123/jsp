<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify Page</title>
</head>

<body>
	<form action="./modify.pd" method="post">
		<input type="hidden" name="pno" value="${pvo.pno}">
		<table border="1">
			<tr>
				<th>PNO</th>
				<td>${pvo.pno}</td>
			</tr>
			<tr>
				<th>PNAME</th>
				<td><input type="text" name="pname" value="${pvo.pname}"></td>
			</tr>
			<tr>
				<th>PRICE</th>
				<td><input type="text" name="price" value="${pvo.price}"></td>
			</tr>
			<tr>
				<th>REGDATE</th>
				<td>${pvo.regdate}</td>
			</tr>
			<tr>
				<th>MADEBY</th>
				<td><input type="text" name="madeby" value="${pvo.madeby}"></td>
			</tr>
			<tr>
				<td colspan="2"><button type="submit">수정완료</button></td>
			</tr>
		</table>
	</form>
</body>
</html>