<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="money" value="${param.money}"/>

<h1>money = ${money}</h1>

<!-- 단순 조건 -->

<c:if test="${money >= 1000000000}"> <!-- gt lt는 초과 미만 -->
<h1>돈이 많으시네요~</h1>
</c:if>

<!-- 복합 조건 -->
<c:choose>										
	<c:when test="${money ==1250 }">성인요금</c:when>		
	<c:when test="${money ==720 }">청소년요금</c:when>		
	<c:when test="${money ==450 }">어린이요금</c:when>		
	<c:otherwise>몰라</c:otherwise>
</c:choose>
