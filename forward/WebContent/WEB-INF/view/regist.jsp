<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="regist.do" method="post">
		<input type="text" name="id" placeholder="아이디"><br>
		<input type="password" name="pw" placeholder="비밀번호"><br>
		<input type="text" name="name" placeholder="이름"><br>
		<input type="text" name="post" placeholder="우편번호"><br>
		<input type="text" name="basic_addr" placeholder="기본주소"><br>
		<input type="text" name="extra_addr" placeholder="상세주소"><br>
		<input type="text" name="phone" placeholder="전화번호"><br>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>