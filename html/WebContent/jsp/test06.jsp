<%@page import="java.util.ArrayList"%>
<%@page import="beans.KHMemberDto"%>
<%@page import="java.util.List"%>
<%@page import="beans.KHMemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	KHMemberDao dao = new KHMemberDao();
// 	post방식은 복원 코드가 필요
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	List<KHMemberDto> list = dao.search(name);
	String nameStr;
	if(name==null){
	nameStr="";
		}else{
	nameStr=name;			
		}
%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>검색기능</title>
</head>
<body>
	<div align="center">
		<form action="test06.jsp" method="post">
			<input type="text" name="name" placeholder="이름 입력" required
				value="<%=nameStr%>"> <input type="submit" value="검색">
		</form>

		<%
		if (name==null) {
	%>
		<h3>검색어를 입력하세요</h3>
		<%
		} else if (list.size() == 0){
	%>
		<h3>검색 결과가 없습니다</h3>
		<%
		} else{
	%>
		<h1>검색결과</h1>
		<table border="1" width="50%">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>포인트</th>
					<th>가입 날짜</th>
				</tr>
			</thead>
			<tbody align="center">
				<%
				for (KHMemberDto dto : list) {
			%>
				<tr>
					<td><%=dto.getNo()%></td>
					<td><%=dto.getName()%></td>
					<td><%=dto.getId()%></td>
					<td><%=dto.getPw()%></td>
					<td><%=dto.getPoint()%></td>
					<td><%=dto.getJoindate().substring(0, 10)%></td>
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