<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!DOCTYPE html>
<html lang="en">
<head>
 <meta charset="UTF-8">
    <title>내가만든 홈페이지</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/common.css">
    <style>
        
    </style>
</head>
<body >
    <main>

        

        <header align="center"><img src = "<%=request.getContextPath() %>/image/mainlogo.jpg" width = "100" height = "100" ></header>

        <nav>
            <jsp:include page="/template/menu.jsp"></jsp:include>
        </nav>
        <div class="section-border">
        <section>

           	<div class="row-empty"></div>
			<div class="row-empty"></div> 