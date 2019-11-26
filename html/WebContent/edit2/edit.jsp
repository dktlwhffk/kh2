<%@page import="beans.SnackDto"%>
<%@page import="beans.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
//     이 페이지를 실행하려면 반드시 파라미터에 "번호"가 있어야한다.
		int no = Integer.parseInt(request.getParameter("no"));
    
    	SnackDao dao = new SnackDao();
    	SnackDto dto = dao.get(no);
    	
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 	과자 정보를 수정할 수 있도록 입력창을 제공 -->
	<h1>정보수정</h1>
	<form action="edit.do" method = "post"> 
		<input type = "text " name = "no" value = "<%=dto.getNo()%>"> <br><br>
		<input type = "text" name = "name" value = "<%=dto.getName()%>"> <br><br>
		<input type = "text" name = "price" value = "<%=dto.getPrice()%>"> <br><br>
		<input type = "text" name = "stock" value = "<%=dto.getStock()%>"> <br><br>
		<input type = submit>
	</form>
</body>
</html>