<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	EL을 이용한 객체 데이터 접근
	EL은 메소드 추론이 가능하다.
	dto.id는 dto.getId()로 추론된다
	dto.name은 dto.getName()으로 추론된다
	그러나 해당하는 getter 메소드가 없으면 오류가 발생한다
 -->
 
 <%
 	//원래 서블릿에서 해야할 코드
 	//-아이디가 "test"인 회원 정보를 찾아서 출력 페이지에 전달
 	MemberDao dao = new MemberDao();
 	MemberDto dto = dao.get("dktlwhffk");
 	
 	request.setAttribute("dto", dto);
 %>
 
 <h1>아이디 : ${dto.getId()}</h1>
 <h1>아이디 : ${dto.id }</h1>
 <h1>이름 : ${dto.name }</h1>
 <h1>포인트 : ${dto.point }</h1>
 <h1>가입일 : ${dto.joindate }</h1>
 