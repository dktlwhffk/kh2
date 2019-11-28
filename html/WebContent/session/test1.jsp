<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>test1.jsp</h1>
 <%
 	//세션에 데이터를 저장
 	//세션은 map<string, object> 형태의 저장소
 	//설정할 때 setAttribute() 명령 사용
 	//추출할 때 getAttribute() 명령 사용
 	//지울 때 removeAttribute() 명령 사용
 	
 	session.setAttribute("how", 777);
 %>
    <h3>how=<%=session.getAttribute("how") %></h3>

<!-- 세션 id 확인 -->
<h3>id = <%=session.getId() %></h3>
 
 