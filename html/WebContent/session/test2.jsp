<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>test2.jsp</h1>
     <!-- 세션에 저장된 데이터 확인 -->
     
     <h3>how=<%=session.getAttribute("how") %></h3>

     <!-- 세션 id 확인 -->
<h3>id = <%=session.getId() %></h3>