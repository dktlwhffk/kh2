<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 		목표: 정보를 입력한 뒤 regist.do로 전송하는 것 -->
	<form action="regist.do" method="post">
	
		<input type = "text" name = "name">
	
		<input type = "text" name = "price">
	
		<input type = "text" name = "stock">
		
		<br>
		<input type = submit>
	</form>
</body>
</html>