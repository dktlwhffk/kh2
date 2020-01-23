<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${search.size()==0 }">
<h3>검색결과가 없습니다.</h3>
</c:if>
<c:forEach var="productDto" items="${search }">
<fmt:parseDate var="t" value="${productDto.when}" pattern="yyyy-MM-dd HH:mm:ss.S"/>
<p>${productDto.no}</p>
<p>${productDto.name}</p>
<p>${productDto.price }</p>
(<fmt:formatDate value="${t}" type="both" dateStyle="short" timeStyle="short"/>)
</c:forEach>
<form action="search" method="get">
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>