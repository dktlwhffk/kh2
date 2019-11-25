<%@page import="java.util.List"%>
<%@page import="beans.KHMemberDto"%>
<%@page import="beans.KHMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!--     자바 코드 -->
    <%
    KHMemberDao dao = new KHMemberDao();
    List<KHMemberDto> list = dao.getList();
    %>
<!--     보여주기 위한 코드 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align = "center">
	<h1>KH 수강생 명단</h1>
	<table border="1" width = "50%" >
		<thead>
			<tr>
				<th >번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th >포인트</th>
				<th >가입 날짜</th>
			</tr>
		</thead>
		<tbody align = "center">
		
			<% for(KHMemberDto dto: list) { %>
				<tr>
					<td><%=dto.getNo() %></td>
					<td><%=dto.getName() %></td>
					<td><%=dto.getId() %></td>
					<td><%=dto.getPw() %></td>
					<td><%=dto.getPoint() %></td>
					<td><%=dto.getJoindate().substring(0, 10)%></td>
				</tr>
			<% } %>
	
		</tbody>
	</table>
</div>
</body>
</html>