<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//q라는 이름의 파라미터를 받는 코드
	String q = request.getParameter("q");
	out.println(q);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 내장객체</title>
</head>
<body>
	<h1> q = <%=q %></h1>
</body>
</html>