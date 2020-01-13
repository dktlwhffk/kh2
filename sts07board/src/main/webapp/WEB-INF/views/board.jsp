<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>board.jsp</h1>

<c:forEach var="boardDto" items="${list}">
	<div>
		${boardDto.title}
	</div>
</c:forEach>