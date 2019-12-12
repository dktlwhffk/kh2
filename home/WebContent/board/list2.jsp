<%-- <%@page import="java.util.List"%> --%>
<%-- <%@page import="java.util.ArrayList"%> --%>
<%-- <%@page import="home.beans.BoardDto"%> --%>
<%-- <%@page import="home.beans.BoardDao"%> --%>
<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" --%>
<%--     pageEncoding="UTF-8"%> --%>
    
<%-- <% --%>
// 	String type = request.getParameter("type");
// 	String keyword = request.getParameter("keyword");
// 	boolean isSearch = type !=null &&keyword !=null;
// 	BoardDao dao = new BoardDao();
// 	List<BoardDto> list;
// 	String context = request.getContextPath();
// 	if(isSearch){
// 		list = dao.search(type, keyword);
// 	}else{
// 		list = dao.getList();
// 	}
<%-- %> --%>
<%-- <jsp:include page="/template/header.jsp"></jsp:include> --%>
<!-- <div align = "center"> -->
<!-- 	<h2>게시판</h2> -->
	
<!-- 	<table border = "1" width = "70%"> -->
<!-- 		<thead> -->
<!-- 		<tr> -->
<!-- 			<th>rn</th> -->
<!-- 			<th>글번호</th> -->
<!-- 			<th>말머리</th> -->
<!-- 			<th>글제목</th> -->
<!-- 			<th>작성자</th> -->
<!-- 			<th>작성일</th> -->
<!-- 			<th>조회수</th> -->
<!-- 		</tr> -->
<!-- 		</thead> -->
<!-- 		<tbody align = "center"> -->
<%-- 			<%for(BoardDto dto : list) {	%> --%>
<!-- 		<tr> -->
<%-- 			<td><%=dto.getRn() %></td> --%>

<%-- 			<td><%=dto.getNo() %></td> --%>
<%-- 			<td><%=dto.getHead() %></td> --%>
<%-- 			<td><a href="<%=context%>/board/content.jsp?no=<%=dto.getNo()%>"><%=dto.getTitle() %></a></td> --%>
<%-- 			<td><%=dto.getWriter() %></td> --%>
<%-- 			<td><%=dto.getDate() %></td> --%>
<%-- 			<td><%=dto.getReadcount() %></td> --%>
<!-- 		</tr> -->
<%-- 		<%} %> --%>
<!-- 		</tbody> -->
<!-- 	</table> -->
<!-- 	<h4>[이전] 1 2 3 4 5 6 7 8 9 10 [다음]</h4> -->
<!-- 	<a href="write.jsp"><input type = "submit" value = "글작성"></a> -->
<!-- 	<form action ="list.jsp" method="get"> -->
<!-- 	<select name = "type"> -->
<!-- 		<option value ="title">제목</option> -->
<!-- 		<option value = "writer">작성자</option> -->
<!-- 	</select> -->
<!-- 	<input type="search" name ="keyword" placeholder="검색어" required> -->
<!-- 	<input type ="submit" value="검색"> -->
<!-- 	</form> -->
<!-- </div> -->
<%-- <jsp:include page="/template/footer.jsp"></jsp:include> --%>