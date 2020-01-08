<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/header.jsp"></jsp:include>

<article class="w-100">
	<div class="row">
		<h2>자유 게시판</h2>
	</div>
	<div class="row">
		<h5>글은 자신의 인격입니다</h5>	
	</div>
	<div class="row">
		<table class="table">
			<thead>
				<tr>
					<th>번호</th>
					<th width="40%">제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody align="center">
				<c:forEach var="dto" items="${list}">
				<tr>
					<td>${dto.no}</td>
					<td align="left">
						
						<!-- 제목을 depth번 만큼 띄어쓰기 후 출력 -->
						<c:forEach var="i" begin="1" end="${dto.depth}">
							&nbsp;&nbsp;&nbsp;&nbsp;
						</c:forEach>
						
						<!-- 답글은 이미지를 추가 -->
						<c:if test="${dto.depth > 0}">
							<img src="${pageContext.request.contextPath}/image/reply.png" width="30" height="15">
						</c:if>
						
						<c:if test="${not empty dto.head}">
							<!-- 말머리 출력 -->
							<font color="blue">
								[${dto.head}]
							</font>					
						</c:if>
						
						<a href="content.do?no=${dto.no}">
							<!-- 제목 출력 -->
							${dto.title}
						</a>
						
						<c:if test="${dto.replycount > 0}">
							<!-- 댓글수 출력 -->
							<font color="red">
								[${dto.replycount}]
							</font>
						</c:if>
					</td>
					<td>${dto.writer}</td>
					<td>${dto.getWdate()}</td>
					<td>${dto.readcount}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row-right">
		<a href="write.jsp">
			<input class="btn" type="button" value="글쓰기">
		</a>
	</div>
	<div class="row">
		<!-- 네비게이터(navigator) -->
		<jsp:include page="/template/navigator.jsp">
			<jsp:param name="pno" value="${pno}"/>
			<jsp:param name="count" value="${count}"/>
			<jsp:param name="navsize" value="${navsize}"/>
			<jsp:param name="pagesize" value="${pagesize}"/>
		</jsp:include>
	</div>
	<div class="row">
		<form action="list.jsp" method="get">
		
			<select name="type" class="input-item">
				<option value="title">제목</option>
				<option value="writer">작성자</option>
			</select>
			
			<input class="input-item" type="search" name="keyword" placeholder="검색어" required>
			
			<input class="btn" type="submit" value="검색">
			
		</form>
	</div>
</article>

<jsp:include page="/template/footer.jsp"></jsp:include>





