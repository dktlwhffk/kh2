<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">

<h2>로그인</h2>

<!-- 어느 페이지에서 왔는지 알려주는 코드(링크로 이동한 경우 생성) -->
<h3>referer = <%=request.getHeader("referer")%></h3>

<!-- <form action="/home/member/login.do" method="post"> -->
<form action="login.do" method="post">
	<table border="0">
		<!-- 아이디 입력창, 비밀번호 입력창, 아이디 저장하기, 로그인 버튼, 찾기 링크 -->
		<tr>
			<td>
				<input type="text" name="id" placeholder="ID" required>
			</td>
		</tr>
		<tr>
			<td>
				<input type="password" name="pw" placeholder="Password" required>
			</td>
		</tr>
		<tr>
			<td>
				<input type="checkbox">
				아이디 저장하기
			</td>
		</tr>
		<tr>
			<td align="right">
				<input type="submit" value="Login">
			</td>
		</tr>
		<tr>
			<td>
				<a href="find.jsp">아이디 찾기</a><br>
				<a href="#">비밀번호 찾기</a><br>
				<a href="regist.jsp">회원가입</a>
			</td>
		</tr>
	</table>
</form>

<%if(request.getParameter("error") != null){ %>
	<!-- error라는 이름의 파라미터가 있다면 오류 메시지를 출력 -->
	<h5><font color="red">입력하신 정보가 일치하지 않습니다</font></h5>
<%} %>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>





