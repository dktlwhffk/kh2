<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/WEB-INF/views/template/header.jsp"></jsp:include>

<form method="post">
<article class="w-50">
	<div class="row">
	<h2>회원가입</h2>	
	</div>
	<div class="row-left">
	<label class="block-item">아이디</label><br><input class="block-item" type="text" name="id" required>
	</div>
	<div class="row-left">
	비밀번호<input class="block-item" type="password" name="pw" required>
	</div>
	<div class="row-left">
	이름<input class="block-item" type="text" name="name" required>
	</div>
	<div class="row-left">
	전화번호<input class="block-item" type="tel" name="phone" required>
	</div>
	<div class="row-left">
	
	<div class="row-left">주소</div>
		<input type="text" name="post" size="6" placeholder="우편번호">
		<input class="btn1" type="button" value="우편번호 찾기">
		<input class="block-item" type="text" name="basic_addr" size="50" placeholder="기본주소">
		<input class="block-item" type="text" name="extra_addr" size="50" placeholder="상세주소">
	</div>
	<div class="row">
	<input class="btn1" type="submit" value="가입하기">
	<input class="btn1" type="reset" value="지우기">
	</div>
</article>
	</form>


<jsp:include page = "/WEB-INF/views/template/footer.jsp"></jsp:include>