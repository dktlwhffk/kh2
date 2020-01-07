<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!-- 
	param은 EL에서 파라미터를 접근하기 위한 내장객체
	즉, 다음 두 구문은 같다
	-param.test
	-request.getParameter("test")
	
	(참고) EL은 null에 관대하다(출력하지않음)
 -->
 <form action="test02.jsp">
 	<input type="text" name="test" value="${param.test}">
 	<input type="submit">
 </form>
 <h1>test=<%=request.getParameter("test") %></h1>
 <h1>test=${param.test}</h1>