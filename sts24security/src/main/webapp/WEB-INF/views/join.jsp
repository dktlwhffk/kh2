<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crypto/crypto-js.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/crypto/hmac-sha256.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/secom.js"></script>

<h1>join.jsp</h1>

<form action="join" method="post">
	<input type="text" name="id" required><br><br>
	<input type="password" name="pw" required><br><br>
	<input type="submit" value="가입">
</form>