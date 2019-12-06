<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	//[1] 번호를 받고 [2] 조회수 증가 후 [3] 게시글을 불러오고 [4] 출력
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDao bdao = new BoardDao();
	BoardDto bdto = bdao.get(no); 
	
// 	MemberDao mdao = new MemberDao();
// 	MemberDto mdto = mdao.get(bdto.getWriter());

// 	본인글인지 여부와 관리자인지 여부를 미리 계산
	String userId = (String)session.getAttribute("id");
	String grade = (String)session.getAttribute("grade");
	
	boolean isMine = userId.equals(bdto.getWriter()); //사용자 id = 작성자 id
	boolean isAdmin = grade.equals("관리자"); //사용자권한==관리자
	
	//추가: set<integer> 형태의 저장소를 이용하여 이미 읽은 글은 조회수 증가를 방지
	//[1] 세션에 있는 저장소를 꺼내고 없으면 신규생성한다.
	Set<Integer> memory = (Set<Integer>)session.getAttribute("memory");
	//memory가 없는 경우에는 null 값을 가진다
	if(memory==null){
		memory = new HashSet<>();
	}
	//[2]처리를 수행한다
	boolean isFirst = memory.add(no);
	System.out.println(memory);
	//[3]처리를 마치고 저장소를 다시 세션에 저장한다
	session.setAttribute("memory", memory);
	
	
	//남의글이라면 ==!isMine
	//처음읽는 글이라면 == isFirst
	if(!isMine && isFirst){
	bdto.setReadcount(bdto.getReadcount()+1);
	bdao.cu(no); //조회수 증가
	}
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>게시글 보기</h2>
	
	<table border="1" width="70%">
		<tr>
			<td><%=bdto.getTitle()%></td>
		</tr>
		<tr>
			<td>
				<%=bdto.getWriter()%>
<%-- 				(<%=mdto.getGrade()%>) --%>
			</td>
		</tr>
		<tr height="200">
			<td valign="top">
				<%=bdto.getContent()%>
			</td>
		</tr>
		<tr>
			<td>
				조회수 <%=bdto.getReadcount()%> 
				댓글수 <%=bdto.getReplycount()%> 
			</td>
		</tr>
		
		<!-- 댓글 목록이 표시될 자리 -->
		<tr>
			<td>
				<!-- 반복문 사용 -->
				<table border="1" width="100%">
					<tr>
						<th width="100">
							<img src="http://placehold.it/150x150">
						</th>
						<td>
							작성자 자리
							작성일
							답글
							<br><br>
							내용이 나오는 자리
						</td>
					</tr>
				</table>
				
			</td>
		</tr>
		<!-- 댓글 작성칸이 표시될 자리 -->
		<tr>
			<td>
				<form action="" method="post">
					<textarea name="" rows="4" cols="100" required></textarea>
					<a href="/list.jsp?no=<%=bdto.getNo()%>"><input type = "submit" value ="등록"></a>
						<%System.out.println(bdto.getNo()); %>
				</form>
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<a href="write.jsp"><input type="button" value="글쓰기"></a>
				<a href="write.jsp?superno=<%=bdto.getNo()%>"><input type="button" value="답글쓰기"></a>
				<%if(isMine||isAdmin){ %>
<!-- 				수정/삭제 버튼은 관리자이거나 본인글에만 표시 -->
				<a href="edit.jsp?no=<%=bdto.getNo()%>"><input type="button" value="수정"></a>
				<a href="delete.do?no=<%=bdto.getNo()%>"><input type="button" value="삭제"></a>
				<%} %>
				<a href="list.jsp"><input type="button" value="목록"></a>
	
			</td>
		</tr>
	</table>	
	
</div>

<br><br>

<jsp:include page="/template/footer.jsp"></jsp:include>