<%@page import="beans.SnackDto"%>
<%@page import="java.util.List"%>
<%@page import="beans.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!--     목표: snack 테이블에 존재하는 데이터를 모두 불러와서 화면에 출력 -->
<%
	//데이터를 불러오기 위한 자바 코드
	SnackDao dao = new SnackDao();
	List<SnackDto> list = dao.getList();
%>

<!-- 보여주기 위한 HTML 코드 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border = "1" width = "500">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>판매가</th>
				<th>재고</th>
			</tr>
		</thead>
		<tbody>
			<% for(SnackDto dto : list){ %>
			
			<tr>
				<td><%=dto.getNo()%></td>
				<td><%=dto.getName() %></td>
				<td><%=dto.getPrice() %></td>
				<td><%=dto.getStock() %></td>
			</tr>
			
			<% } %>
		</tbody>
	</table>
</body>
</html>