<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao dao = new BoardDao();
	BoardDto dto = dao.get(no);
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<h2>수정하기</h2>
	<div>
	<form action="edit.do" method = "post">
	<input type = "hidden" name="no" value="<%=dto.getNo() %>">
	<table border="1">
		<tr>
			<th>말머리</th>
			<td align ="left">
				<select name="head">
    				<option value=""><%=dto.getHead()%></option>
    				<option value="공지">공지</option>
    				<option value="정보">정보</option>
    				<option value="유머">유머</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td align ="left">
				<input type = "text" name="title" value = "<%=dto.getTitle()%>"required>
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>	
				<textarea name = "content" rows="15" cols="150" required
				style="resize:vertical;"><%=dto.getContent() %></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<input type = "submit" value="수정하기">
			</td>
		</tr>
	</table>
	</form>
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>