<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String context = request.getContextPath();
	//로그인 상태판정
	String id = (String)session.getAttribute("id");
	boolean login = id != null;
	//관리자인지 판정
	String grade = (String)session.getAttribute("grade");
	boolean admin = grade != null && grade.equals("관리자");
%>

<div class="menu">
    <label for="hamburg">&equiv;</label>
    <input type="checkbox" id="hamburg">
    <a href="<%=context%>/index.jsp" class="menu-item left-menu">홈으로</a>
    <a href="<%=context%>/board/list.jsp" class="menu-item left-menu">게시판</a>
    <%if(admin){ %>
    <a href="<%=context%>/admin/list.jsp" class="menu-item left-menu">회원찾기</a>
   <%} %>
   
   <%if(login) {%>
    <a href="<%=context%>/member/logout.do" class="menu-item right-menu">로그아웃</a>
    <a href="<%=context%>/member/info.jsp" class="menu-item right-menu">회원정보</a>
    <%}else{ %>
    <a href="<%=context %>/member/login.jsp" class="menu-item right-menu">로그인</a>
    <a href="<%=context%>/member/regist.jsp" class="menu-item right-menu">회원가입</a>
	<%} %>
</div>
