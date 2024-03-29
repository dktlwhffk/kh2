<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- 네비게이터(navigator) -->
<!-- 
	반드시 받아야 하는 데이터 : type, keyword, pno, count, navsize, pagesize
 -->
 <%
 	String type = request.getParameter("type");
 	String keyword = request.getParameter("keyword");
 	boolean isSearch = type !=null &&keyword !=null;
 	int pno = Integer.parseInt(request.getParameter("pno"));
 	int count = Integer.parseInt(request.getParameter("count"));
 	int navsize = Integer.parseInt(request.getParameter("navsize"));
 	int pagesize = Integer.parseInt(request.getParameter("pagesize"));
	int pagecount = (count+(pagesize))/pagesize;
	int startBlock=(pno-1)/navsize*navsize+1;
	int finishBlock=startBlock+(navsize-1);
	//만약 마지막 블록이 페이지 수보다 크다면 수정 처리
	if(finishBlock>pagecount){
		finishBlock = pagecount;
	}
 %>
 
<!--  <ul class="page-navigator"> -->
<!--         <li><a href="#">이전</a></li> -->
<!--         <li><a href="#">1</a></li> -->
<!--         <li><a href="#">2</a></li> -->
<!--         <li><a href="#">3</a></li> -->
<!--         <li><a href="#">4</a></li> -->
<!--         <li><a href="#">5</a></li> -->
        
<!--         <li><a href="#">6</a></li> -->
<!--         <li><a href="#">7</a></li> -->
<!--         <li><a href="#">8</a></li> -->
<!--         <li><a href="#">9</a></li> -->
<!--         <li><a href="#">10</a></li> -->
<!--         <li><a href="#">다음</a></li> -->
<!-- </ul> -->
 
<h4>
<%if(startBlock > 1){ %>
	<%if(isSearch){ %>
		<a href= "list.do?type=<%=type %>&keyword=<%=keyword %>&pno=<%=startBlock-1 %>">[이전]</a> 
	<%}else{ %>
		<a href= "list.do?pno=<%=startBlock-1 %>">[이전]</a> 		
	<%} %>
<%} %>

<%for(int i=startBlock; i <= finishBlock; i++){ %>
		<%if(i == pno){ %>
			<%=i%>
		<%}else{ %>
			<%if(isSearch){ %>
				<a href="list.do?type=<%=type%>&keyword=<%=keyword%>&pno=<%=i%>"><%=i%></a>
			<%}else{ %>
				<a href="list.do?pno=<%=i%>"><%=i%></a>
			<%} %>
		<%} %>
	<%} %>

<%if(finishBlock<pagecount){ %>
	<%if(isSearch){ %>
		<a href="list.do?type=<%=type %>&keyword=<%=keyword %>&pno=<%=finishBlock + 1 %>">[다음]</a>
	<%}else{ %>
		<a href="list.do?pno=<%=finishBlock + 1 %>">[다음]</a>
	<%} %>
<%} %>
</h4>
<!-- 네비게이터 종료 -->