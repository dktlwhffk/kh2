<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div align = "center">
<h2>방명록 보기</h2>

<c:forEach var="list" items="${list }">

    <p><c:out value="${list.no}" /> 
    <c:out value="${list.content}" /> 
    <c:out value="${list.when}" />
    </p>
	
</c:forEach>
<a href="./">홈으로 돌아가기</a>
</div>