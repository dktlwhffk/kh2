<%@page import="java.util.List"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//페이징 추가
	int pno;
	try{
		pno = Integer.parseInt(request.getParameter("pno"));
		if(pno<=0) throw new Exception();
	}
	catch(Exception e){
		pno=1;
	}
	
// 	페이지 크기
	int pagesize=10;
	
	int finish = pno*pagesize;
	int start = finish - (pagesize-1);
	
	
	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	boolean isSearch = type !=null &&keyword !=null;
	BoardDao dao = new BoardDao();
	
	List<BoardDto> list;
	String context = request.getContextPath();
	if(isSearch){
		list = dao.search(type, keyword, start, finish);	
	}else{
		list = dao.getList(start, finish);
	}
	/**********************************************
		하단 네비게이터 계산하기
		-시작블록 = (현재페이지-1)/네비게이터 크기 10* 네비게이터 크기10+1
	**********************************************/
	int count = dao.getCount(type, keyword);
	int navsize=10;
	
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-100">
	<div class="row">
		<h2>자유게시판</h2>
	</div>
	<div class="row">
		<small>글은 자신의 인격입니다</small>
	</div>
	<div class="row">
		<table class="table">
		<thead>
		<tr>
				<th>번호</th>
				<th width="40%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
		</tr>
		</thead>
		<tbody align = "center">
			<%for(BoardDto dto : list) {	%>
		<tr>
			<td><%=dto.getNo() %></td>
			<td align="left">

					<!-- 제목을 depth번 만큼 띄어쓰기 후 출력 -->
					<%for(int i=0; i < dto.getDepth(); i++){ %>
						&nbsp;&nbsp;&nbsp;&nbsp;
					<%} %>

					<!-- 답글은 이미지를 추가 -->
					<%if(dto.getDepth() > 0){ %>
						<img src="<%=request.getContextPath()%>/image/reply.png" width="30" height="15">
					<%} %>

					<%if(dto.getHead() != null){ %>
						<!-- 말머리 출력 -->
						<font color="blue">
							[<%=dto.getHead()%>]
						</font>					
					<%} %>
					
					<a href="content.jsp?no=<%=dto.getNo()%>">
						<!-- 제목 출력 -->
						<%=dto.getTitle()%>
					</a>
					
					<%if(dto.getReplycount() > 0){ %>
						<!-- 댓글수 출력 -->
						<font color="red">
							[<%=dto.getReplycount()%>]
						</font>
					<%} %>
			</td>
			<td><%=dto.getWriter() %></td>
			<td><%=dto.getDate() %></td>
			<td><%=dto.getReadcount() %></td>
		</tr>
		<%} %>
		</tbody>
		</table>
	</div>
	<div class="row">
		<a href="write.jsp"><input class="btn1" type = "button" value = "글작성"></a>
	</div>
	<div class="row">
		<jsp:include page = "/template/navigator.jsp">
		<jsp:param value="<%=pno %>" name="pno"/>
		<jsp:param value="<%=count %>" name="count"/>
		<jsp:param value="<%=navsize %>" name="navsize"/>
		<jsp:param value="<%=pagesize %>" name="pagesize"/>
	</jsp:include>
	</div>
	<div class="row">
		<form action ="list.jsp" method="get">
			<select class=input-item name = "type">
				<option value ="title">제목</option>
				<option value = "writer">작성자</option>
			</select>
				<input class="input-item" type="search" name ="keyword" placeholder="검색어" required>
				<input class="btn1" type ="button" value="검색">
		</form>
	</div>
</article>


<jsp:include page="/template/footer.jsp"></jsp:include>