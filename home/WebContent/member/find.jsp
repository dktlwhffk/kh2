<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>

<div align = "center">
<h2>아이디 찾기</h2>
<%
String context = request.getContextPath(); 
%>
<form action = "find.do">
	<table border="1">
		<tr>
			<td>
				<input type = "text" name = "name" placeholder = "이름입력" required>
			</td>
		</tr>
		<tr>
			<td>
				<input type = "text" name = "phone" placeholder = "휴대번호입력" required>
			</td>
		</tr>
		<tr align="center">
			<td><input type = submit value = "입력"></td>
		</tr>
	</table>
</form>
</div>