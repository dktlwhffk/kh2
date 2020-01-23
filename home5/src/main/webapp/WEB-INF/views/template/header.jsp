<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
    <title>내가만든 홈페이지</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/res/css/common.css">
    <style>
        
    </style>
</head>
<body >
    <main>

        

        <header align="center"><img src = "${pageContext.request.contextPath }/res/image/mainlogo.jpg" width = "100" height = "100" ></header>

        <nav>
            <jsp:include page="/WEB-INF/views/template/menu.jsp"></jsp:include>
        </nav>
        <div class="section-border">
        <section>

           	<div class="row-empty"></div>
			<div class="row-empty"></div> 