<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<jsp:include page="/template/header.jsp"></jsp:include>
<article class="w-100">
	<div class="row">
		<h2>자유게시판</h2>
	</div>
	<div class="row">
		<small>글은 자신의 인격입니다</small>
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
		<tbody align = "center">
			<c:forEach var="dto" items="${list}">
		<tr>
			<td>${dto.getNo()}</td>
			<td align="left">

					<!-- 제목을 depth번 만큼 띄어쓰기 후 출력 -->
					<c:forEach begin="1" end="${dto.getDepth() }">
						&nbsp;&nbsp;&nbsp;&nbsp;
					</c:forEach>
					<!-- 답글은 이미지를 추가 -->
					<c:if test="${dto.getDepth()>0}">
						<img src="<%=request.getContextPath()%>/image/reply.png" width="30" height="15">
					</c:if>
					<c:if test="${not empty dto.getHead() }">
						<!-- 말머리 출력 -->
						<font color="blue">
							[${dto.getHead() }]
						</font>					
					</c:if>
					<a href="content.do?no=${dto.getNo() }">
						<!-- 제목 출력 -->
						${dto.getTitle() }
					</a>
					<c:if test="${dto.getReplycount()>0 }">
						<!-- 댓글수 출력 -->
						<font color="red">
							[${dto.getReplycount() }]
						</font>
					</c:if>
			</td>
			<td>${dto.getWriter() }</td>
			<td>${dto.getDate() }</td>
			<td>${dto.getReadcount() }</td>
		</tr>		
		</c:forEach>
		</tbody>
		</table>
	</div>
	<div class="row">
		<a href="write.jsp"><input class="btn1" type = "button" value = "글작성"></a>
	</div>
	<div class="row">
	<jsp:include page = "/template/navigator.jsp">
		<jsp:param value="${pno }" name="pno"/>
		<jsp:param value="${count }" name="count"/>
		<jsp:param value="${navsize }" name="navsize"/>
		<jsp:param value="${pagesize }" name="pagesize"/>
	</jsp:include>
	</div>
	<div class="row">
		<form action ="list.do" method="get">
			<select class=input-item name = "type">
				<option value ="title">제목</option>
				<option value = "writer">작성자</option>
			</select>
				<input class="input-item" type="search" name ="keyword" placeholder="검색어" required>
				<input class="btn1" type ="submit" value="검색">
		</form>
	</div>
</article>

<jsp:include page="/template/footer.jsp"></jsp:include>