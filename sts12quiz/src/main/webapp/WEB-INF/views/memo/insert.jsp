<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div align = "center">
<h2>방명록 작성</h2>

<form action="insert" method="post">
<input type="text" name="content">
<input type="submit" value="등록">
</form>
<a href="./">홈으로 돌아가기</a>
</div>
