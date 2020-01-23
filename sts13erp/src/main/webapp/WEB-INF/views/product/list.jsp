<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>조회페이지</h1>
<c:choose>
<c:when test=" ${not empty search.get(1)}">
<c:forEach var="productDto" items="${search }">
<p>${productDto.no}</p>
<p>${productDto.name}</p>
<p>${productDto.price }</p>
<p>${productDto.when}</p>
</c:forEach>
</c:when>
<c:otherwise>
<c:forEach var="productDto" items="${list }">
<fmt:parseDate var="t" value="${productDto.when}" pattern="yyyy-MM-dd HH:mm:ss.S"/>
<p>${productDto.no}</p>
<p>${productDto.name}</p>
<p>${productDto.price }</p>
(<fmt:formatDate value="${t}" type="both" dateStyle="short" timeStyle="short"/>)
</c:forEach>
</c:otherwise>
</c:choose>

<form action="search" method="get">
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>
