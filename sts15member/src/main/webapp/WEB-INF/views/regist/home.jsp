<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>가입페이지</h3>

<form action="regist" method="post" enctype="multipart/form-data">
	아이디: <input type="text" name="member_id"><br><br>
	비밀번호: <input type="password" name="member_pw"><br><br>
	닉네임: <input type="text" name="member_nick"><br><br>
	<input type="file" name="file" multiple accept="image/*"><br><br>
	<input type="submit" value="등록"> 
</form>