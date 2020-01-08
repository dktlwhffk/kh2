<%@page import="home.bean.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="home.bean.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 	페이징 추가
	int pno;
	try{
		pno = Integer.parseInt(request.getParameter("pno"));
		if(pno <= 0) throw new Exception();
	}
	catch(Exception e){
		pno = 1;
	}
	
// 	페이지 크기
	int pagesize = 10;
	
	int finish = pno * pagesize;
	int start = finish - (pagesize - 1);
// 	System.out.println("start = " + start + " , finish = " + finish);

	String type = request.getParameter("type");
	String keyword = request.getParameter("keyword");
	
	boolean isSearch = type != null && keyword != null;
	
	BoardDao dao = new BoardDao();
// 	List<BoardDto> list = 목록 or 검색;
	List<BoardDto> list;
	if(isSearch){
		list = dao.search(type, keyword, start, finish); 
	}
	else{
		list = dao.getList(start, finish);
	}
	
	/************************************************************
		하단 네비게이터 계산하기
		- 시작블록 = (현재페이지-1) / 네비게이터크기 * 네비게이터크기 + 1
	************************************************************/
	int count = dao.getCount(type, keyword);
	int navsize = 10;
	int pagecount = (count + pagesize) / pagesize;
	
	int startBlock = (pno - 1) / navsize * navsize + 1;
	int finishBlock = startBlock + (navsize - 1);
	
	//만약 마지막 블록이 페이지 수보다 크다면 수정 처리
	if(finishBlock > pagecount){
		finishBlock = pagecount;
	}
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>자유 게시판</h2>
	<h5>글은 자신의 인격입니다</h5>
	
	<table border="1" width="90%">
		<thead>
			<tr>
				<th>rn</th>
				<th>번호</th>
				<th width="45%">제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody align="center">
			<%for(BoardDto dto : list){ %>
			<tr>
				<td><%=dto.getRn()%></td>
				<td><%=dto.getNo()%></td>
				<td align="left">
					
					<%if(dto.getHead() != null){ %>
						<!-- 말머리 출력 -->
						<font color="blue">
							[<%=dto.getHead()%>]
						</font>					
					<%} %>
					
					<a href="content.do?no=<%=dto.getNo()%>">
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
				<td><%=dto.getWriter()%></td>
				<td><%=dto.getWdate()%></td>
				<td><%=dto.getReadcount()%></td>
			</tr>
			<%} %>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="6" align="right">
					<a href="write.jsp">글쓰기</a>
				</td>
			</tr>
		</tfoot>
	</table>
	
	<!-- 네비게이터(navigator) -->
	<h4>
		<%if(startBlock > 1){ %>
			<%if(isSearch){ %>
				<a href="list.jsp?type=<%=type%>&keyword=<%=keyword%>&pno=<%=startBlock - 1%>">[이전]</a>  
			<%}else{ %>
				<a href="list.jsp?pno=<%=startBlock - 1%>">[이전]</a>
			<%} %>
		<%} %>
		
		<%for(int i=startBlock; i <= finishBlock; i++){ %>
			<%if(i == pno){ %>
				<%=i%>
			<%}else{ %>
				<%if(isSearch){ %>
					<a href="list.jsp?type=<%=type%>&keyword=<%=keyword%>&pno=<%=i%>"><%=i%></a>
				<%}else{ %>
					<a href="list.jsp?pno=<%=i%>"><%=i%></a>
				<%} %>
			<%} %>
		<%} %>
		
		<%if(finishBlock < pagecount){ %>
			<%if(isSearch){ %>
				<a href="list.jsp?type=<%=type%>&keyword=<%=keyword%>&pno=<%=finishBlock + 1%>">[다음]</a>
			<%}else{ %>
				<a href="list.jsp?pno=<%=finishBlock + 1%>">[다음]</a>
			<%} %>
		<%} %>
	</h4>
	
	<form action="list.jsp" method="get">
		
		<select name="type">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
		</select>
		
		<input type="search" name="keyword" placeholder="검색어" required>
		
		<input type="submit" value="검색">
		
	</form>
	
	<h5>pno = <%=pno%>, type = <%=type%>, keyword = <%=keyword%></h5>
	<h5>pagecount = <%=pagecount%>, pagesize = <%=pagesize%></h5>
	<h5>start = <%=start%>, finish = <%=finish%></h5>
	<h5>startBlock = <%=startBlock%>, finishBlock = <%=finishBlock%></h5>
	
	<br><br>
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>





