<%@page import="beans.SnackDto"%>
<%@page import="java.util.List"%>
<%@page import="beans.SnackDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SnackDao dao = new SnackDao();
	String keyword = request.getParameter("keyword");
	List<SnackDto> searchlist = dao.search(keyword);
	List<SnackDto> justlist = dao.getList();
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문제7</title>
</head>
<body>
	<div align="center">
		<h1>상품목록검색</h1>
		<form action="test07.jsp">
			<input type="text" name="keyword" placeholder="검색어 입력">
		</form>
		<br> <br>
		<%
			if (searchlist.size() == 0) {
		%>
			<h3>검색 결과가 없습니다</h3>
		<%
			} else if(keyword ==null){
		%>
			<h1></h1>
		<%
			} else{
		%>
				<h1>검색 결과</h1>
		<table align="center" border="1" width="50%">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>가격</th>
					<th>재고</th>
				</tr>
			</thead>
			<tbody align="center">
				<%
					for (SnackDto dto : searchlist) {
				%>
				<tr>
					<td><%=dto.getNo()%></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getPrice()%></td>
					<td><%=dto.getStock()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>
		<%
			}
		%>
	</div>
</body>
</html>