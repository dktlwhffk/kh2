<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<style>
	table{
		border-collapse: collapse;
	}
</style>

<div align = "center">
<h2>회원등록</h2>
<body>
<form action = regist.do method="post">
	<table border="1" align = "center">
		<tr>
			<td>
				<input type ="text" name = "id" placeholder= "아이디" required>
			</td>
		</tr>
		<tr>
			<td>
			<input type="password" name="pw" placeholder="비밀번호" required>
			</td>
		</tr>	
		<tr>
			<td>
			<input type="text" name="name" placeholder="이름" required>
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="post" placeholder="우편번호">
			<input type="button" value="우편번호 찾기">
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="basic_addr" placeholder="기본주소">
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="extra_addr" placeholder="상세주소">
			</td>
		</tr>
		<tr>
			<td>
			<input type="text" name="phone" placeholder="휴대폰번호" required>
			</td>
		</tr>
		<tr>
			<td colspan="2" align = "center"><input type = submit value="가입하기"></td>
		</tr>
	</table>
<!-- 	<br> -->
</form>
</body>

</div>
<jsp:include page="/template/footer.jsp"></jsp:include>