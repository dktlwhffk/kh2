<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">

<h2>아이디 찾기</h2>

<form action="find.do" method="post">
	<table border="0">
		<tr>
			<th>이름</th>
			<td>
				<input type="text" name="name" required>
			</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>
				<input type="tel" name="phone" required>
			</td>
		</tr>
		<tr>
			<th colspan="2">
				<input type="submit" value="찾기">
			</th>
		</tr>
	</table>
</form>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>