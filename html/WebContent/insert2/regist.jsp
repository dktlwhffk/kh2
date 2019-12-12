<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원등록</title>
</head>
<body>

	<form action="regist.do" method = "post">
	<input type = "text"	 name = "name" placeholder = "이름" required>
	<input type = "text"	 name = "id" placeholder = "아이디">
	<input type = "text"	 name = "pw" placeholder = "비밀번호">
	<input type ="number" name ="point" placeholder = "포인트">
	<br>
	<br>
	<input type = submit>
	</form>
<!-- 	<input type = "text"	 name = "point"> -->
</body>
</html>