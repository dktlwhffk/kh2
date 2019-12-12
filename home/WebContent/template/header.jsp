<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내가 만든 홈페이지</title>
</head>
<body>
<!-- 	
	홈페이지 영역 생성 
	- 고정형: 화면이 변해도 크기가 일정한 것
	- 반응형: 화면이 변하면 크기가 변하는 것
-->


	<table border="1" width="1080" align = "center">
		<!-- 	4줄 1칸 생성 -->
		<tbody>
			<tr>
				<th valign = "middle">
					<br>
<!-- 					더미이미지 생성 -->
<!-- 					<img src = "http://placehold.it/200x30?text=Logo"> -->
					<img src = "/home/image/mainlogo.jpg" width = "100" height = "100" >
					<br>
					
					<font size="5">홈페이지 2주만에 마스터하기</font>
<!-- 					<h1>홈페이지 2주만에 마스터하기</h1> -->
					<br><br>
				</th>
			</tr>
			<tr>
				<th align="left">
<!-- 				메뉴불러오기 -->
					<jsp:include page="/template/menu.jsp"></jsp:include>
				</th>
			</tr>
			<tr height="300" valign="top">
				<th>
<!-- 	상단 조각을 보관한 페이지 -->