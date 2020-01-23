<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h3>업로드 페이지</h3>

<form action="upload3" method="post" enctype="multipart/form-data">
	<input type="text" name="name" placeholder="작성자"><br><br>
	<input type="file" name="file" multiple accept="image/*"><br><br>
	<input type="submit" value="업로드!">
</form>