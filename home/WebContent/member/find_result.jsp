<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 아이디 찾기 결과 페이지 -->
<!-- 	-id라는 이름의 파라미터를 받아서 결과를 화면에 표시 -->
<!-- 	-만약에 파라미터가 없다면 못찾은 상태로 간주하여 결과를 표시 -->
<%
	String id = request.getParameter("id");
%>
<jsp:include page = "/template/header.jsp"></jsp:include>
<%if(id !=null) {%>
<!--  검색 성공시  -->
<h2>당신의 아이디는 <%=id %> 입니다</h2>
<h3><a href="login.jsp">로그인 하러가기</a></h3>
<%} else{ %>
<!--  검색 실패시 -->
<h2>입력하신 정보에 해당하는 회원이 없습니다</h2>
<h3><a href="find.jsp">다시 입력하기</a></h3>
<%} %> 
<jsp:include page = "/template/footer.jsp"></jsp:include>
