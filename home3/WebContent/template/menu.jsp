<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="context" value="${pageContext.request.contextPath}"></c:set> <!-- 절대경로 -->

<c:set var="login" value="${not empty id}"></c:set>
<c:set var="admin" value="${grade=='관리자'}"></c:set>


<div class="menu">
    <label for="hamburg">&equiv;</label>
    <input type="checkbox" id="hamburg">
    <a href="${context}/index.jsp" class="menu-item left-menu">홈으로</a>
    <a href="${context}/board/list.do" class="menu-item left-menu">게시판</a>
    <c:if test="${admin}">
    <a href="${context}/admin/list.do" class="menu-item left-menu">회원찾기</a>
   </c:if>
   
   <c:choose>
   <c:when test="${login}">
    <a href="${context}/member/logout.do" class="menu-item right-menu">로그아웃</a>
    <a href="${context}/member/info.do" class="menu-item right-menu">회원정보</a>
    </c:when>
    <c:otherwise>
    <a href="${context}/member/login.jsp" class="menu-item right-menu">로그인</a>
    <a href="${context}/member/regist.jsp" class="menu-item right-menu">회원가입</a>
    </c:otherwise>
	</c:choose>
</div>
