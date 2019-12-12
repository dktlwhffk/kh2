<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
	<h1>정보 수정</h1> <br>
	<form action="update.do" method = "post">
		아이디					<input type = "text" name = "id"> <br><br>
		비밀번호 					<input type = "text" name = "pw"> <br><br>
		새로운 비밀번호      	<input type = "text" name = "newpw"> <br><br>
		<input type = submit>
	</form>
</body>
</html>