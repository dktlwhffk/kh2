<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	과자 정보를 수정할 수 있도록 입력창을 제공 -->
	<h1>정보수정</h1>
	<form action="edit.do" method = "post"> 
		<input type = "text " name = "no"> <br><br>
		<input type = "text" name = "name"> <br><br>
		<input type = "text" name = "price"> <br><br>
		<input type = "text" name = "stock"> <br><br>
		<input type = submit>
	</form>
</body>
</html>