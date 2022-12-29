<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Register</title>
</head>
<body>
	<!-- ProductController의 분기로 정보를 전달 -->
	<form action="product/insert.pd" method="post">
		Pname : <input type="text" name="pname"> <br>
		Price : <input type="number" name="price"> <br>
		Madeby : <input type="text" name="madeby"> <br>
		<button type="submit">등록</button>
	</form>
</body>
</html>