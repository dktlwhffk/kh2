<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>게시글 보기</h2>
	
	<table border="1" width="70%">
		<tr>
			<td>${bdto.title}</td>
		</tr>
		<tr>
			<td>
				${bdto.writer}
			</td>
		</tr>
		<tr height="200">
			<td valign="top">
				${bdto.content}
			</td>
		</tr>
		
		
		<c:if test="${flist.size() > 0}">
		<!-- 첨부파일 출력줄 : 있을 때만 출력 -->
		<tr>
			<td>
				 
				 <ul>
				 	<c:forEach var="fdto" items="${flist}"> 
					 	<li>
					 		<!-- 미리보기 출력 -->
					 		<img src="download.do?no=${fdto.no}" width="80" height="50">
					 	
					 		${fdto.uploadname}
					 		(${fdto.filesize} bytes)
					 		
					 		<a href="download.do?no=${fdto.no}">
					 			<img src="../image/download.png" width="15" height="15">
					 		</a>
					 	</li>
				 	</c:forEach>
				 </ul>
				 
			</td>
		</tr>
		</c:if>
		
		<!-- 댓글수 , 조회수 출력줄 -->
		<tr>
			<td>
				댓글수 ${bdto.replycount}
				조회수 ${bdto.readcount} 
			</td>
		</tr>
		
		<!-- 댓글 목록이 표시될 자리 -->
		<tr>
			<td>
				
				<table border="1" width="100%">
					<c:forEach var="rdto" items="${list}">
					<tr>
						<th width="100">
							<img src="http://placehold.it/100x100">
						</th>
						<td>
							${rdto.writer}
							
							<c:if test="${bdto.writer == rdto.writer}">
								<!-- 글 작성자의 댓글에만 작성자 표시 -->
								<font color="red">(작성자)</font>
							</c:if>
							
							${rdto.wdate}
							
							답글
							
							<c:if test="${id == rdto.writer}">
								<!-- 수정/삭제버튼은 본인의 댓글에만 표시 -->
								<a href="#">수정</a>
								<a href="reply_delete.do?no=${rdto.no}&origin=${bdto.no}">삭제</a>
							</c:if>
							
							
							<br><br>
							${rdto.content}
						</td>
					</tr>
					</c:forEach>
				</table>
				
			</td>
		</tr>
		
		<!-- 댓글 작성칸이 표시될 자리 -->
		<tr>
			<td align="right">
				
				<form action="reply_insert.do" method="post">
				
					<input type="hidden" name="origin" value="${bdto.no}">
					
					<textarea name="content" rows="4" cols="100" required></textarea>
					
					<input type="submit" value="등록">
					
				</form>
				
			</td>
		</tr>
		
		<tr>
			<td align="right">
				<a href="write.jsp"><input type="button" value="글쓰기"></a>
				<a href="write.jsp?superno=${bdto.no}"><input type="button" value="답글쓰기"></a>

				<c:if test="${isAdmin or isMine}">
					<!-- 수정/삭제 버튼은 관리자이거나 본인글에만 표시 -->
					<a href="edit.jsp?no=${bdto.no}"><input type="button" value="수정"></a>
					<a href="delete.do?no=${bdto.no}"><input type="button" value="삭제"></a>
				</c:if>
				
				<a href="list.jsp"><input type="button" value="목록"></a>
			</td>
		</tr>
	</table>	
	
</div>

<br><br>

<jsp:include page="/template/footer.jsp"></jsp:include>



