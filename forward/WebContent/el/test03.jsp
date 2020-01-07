<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 
	EL의 scope
	-page :pageScope(생략가능)
	-request: requestScope(생략가능)
	-session: sessionScope(생략가능)
	-application: applictaionScope(생략가능)
 -->
 
 <%
 	int a = 10;
 	pageContext.setAttribute("b", 20); //페이지 영역 객체
 	request.setAttribute("c", 30);
 	session.setAttribute("d", 40);
 	application.setAttribute("e", 50);
 %>
 
 <h3>a = <%=a %>, ${a}</h3>
 <h3>b = <%=pageContext.getAttribute("b") %>, ${b}</h3>
 <h3>c = <%=request.getAttribute("c") %>, ${c}</h3>
 <h3>d = <%=session.getAttribute("d") %>, ${d}</h3>
 <h3>e = <%=application.getAttribute("e") %>, ${e}</h3>