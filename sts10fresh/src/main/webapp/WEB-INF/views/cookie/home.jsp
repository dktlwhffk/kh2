<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<h1>쿠키</h1>

<h3>id : ${cookie.id }</h3> 
<h3>이름 : ${cookie.id.name }</h3>
<h3>값 : ${cookie.id.value }</h3>
<h3>값 : ${URLDecoder.decode(cookie.id.value, 'UTF-8')}</h3>

<input type="text" name="id" value="${cookie.id.value }">
 
 <c:if test="${empty cookie.id }">
 	광고를 출력하세요!
 </c:if>
 
<a href="create">쿠키 생성하기</a>
<a href="remove">쿠키 제거하기</a>
