<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	관리자 회원검색 페이지
--%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">

	<h2>회원 검색</h2>
	
	<!-- 검색창 -->
	<form action="list.do" method="get">
	
<!-- 		<input type="text" name="type"> -->
		<select name="type">
			<option value="id">아이디</option>
			<option value="name">이름</option>
			<option value="grade">등급</option>
			<option value="phone">전화번호</option>
		</select>
		
		<input type="text" name="keyword">
		
		<input type="submit" value="검색">
	
	</form>	
	
	<h3>
		type = ${param.type}, 
		keyword = ${param.keyword}
	</h3>
	
	<%-- 결과 list가 null인지 아닌지에 따라 다른 결과를 보여주겠다 --%>
	<c:choose>
	
		<c:when test="${empty list}">
			<h3>검색어를 입력해주세요</h3>	
		</c:when>
		
		<c:otherwise>
			<!-- 검색 결과 -->
			<table border="1" width="80%">
				
				<!-- 테이블 헤더 -->
				<thead>
					<tr>
						<th>ID</th>
						<th>이름</th>
						<th>등급</th>
						<th>전화번호</th>
						<th>가입일</th>
						<th>포인트</th>
						<th>관리메뉴</th>
					</tr>
				</thead>
				
				<!-- 데이터 출력 -->
				<tbody align="center">
					<c:forEach var="dto" items="${list}">
					<tr>
						<td>${dto.id}</td>
						<td>${dto.name}</td>
						<td>${dto.grade}</td>
						<td>${dto.phone}</td>
						<td>${dto.getJoindateWithFormat()}</td>
						<td>${dto.point}</td>
						<!-- 관리 메뉴 -->
						<td>
							<a href="detail.jsp?id=${dto.id}">상세정보</a> |
		<!-- 					<a href="#">휴면계정 전환</a> | -->
							<a href="#">회원탈퇴</a>
						</td>
					</tr>
					</c:forEach>
				</tbody>
						
			</table>
		</c:otherwise>
	</c:choose>
	
		


</div>

<jsp:include page="/template/footer.jsp"></jsp:include>




