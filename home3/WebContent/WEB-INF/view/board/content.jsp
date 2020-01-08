<%@page import="home.beans.FilesDto"%>
<%@page import="home.beans.FilesDao"%>
<%@page import="java.util.List"%>
<%@page import="home.beans.ReplyDto"%>
<%@page import="home.beans.ReplyDao"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="home.beans.MemberDto"%>
<%@page import="home.beans.MemberDao"%>
<%@page import="home.beans.BoardDto"%>
<%@page import="home.beans.BoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>게시글 보기</h2>
	
	<table border="1" width="70%">
		<tr>
			<td>${bdto.getTitle()}</td>
		</tr>
		<tr>
			<td>
				${bdto.getWriter() }
			</td>
		</tr>
		<tr height="200">
			<td valign="top">
				${bdto.getContent() }
			</td>
		</tr>
		<c:if test="${flist.size()>0 }">
		<tr>
			<td>
				<ul>
					<c:forEach var="fdto" items="${flist }">
					<li>
						<img src = "download.do?no=${fdto.getNo() }" width = "50" height = "30">
						${fdto.getUploadname() }
						("${fdto.getFilesize() }"  bytes)	
						<a href = "download.do?no=${fdto.getNo() }">
						<img src ="../image/download.png" width="15" height="15"></a>
					</li>
					</c:forEach>
				</ul>
			</td>
		</tr>
		</c:if>
		<tr>
			<td>
				조회수 ${bdto.getReadcount() } 
				댓글수 ${bdto.getReplycount() }
			</td>
		</tr>
		<!-- 댓글 목록이 표시될 자리 -->
		<tr>
			<td>
				<!-- 반복문 사용 -->
				<table border="1" width="100%">
					<c:forEach var="dto" items="${list }">
					<tr>
						<th width="100">
							<img src="http://placehold.it/30x30">
						</th>
						<c:choose>
						<c:when test="${bdto.getWriter()==dto.getRwriter() }">
						<td><font color="red">작성자</font></td>
						</c:when>
						<c:otherwise>
						<td>작성자:${dto.getRwriter() }</td>
						</c:otherwise>
						</c:choose>
						<td>작성날짜:${dto.getRdate() }</td>
						<c:if test="${id==dto.getRwriter() }">
						<td align="center">
						<a href="reply_delete.do?rno=${dto.getRno() }&no=${bdto.getNo() }">
						<input type = "button" value="댓글삭제">
						</a>
						</td>
						</c:if>
					</tr>
					<tr>
						<td colspan="4" style="word-break:break-all;">${dto.getRcontent() }</td>
					</tr>
					</c:forEach>
				</table>
				
			</td>
		</tr>
		<!-- 댓글 작성칸이 표시될 자리 -->
		<tr>
			<td>
				<form action="reply_insert.do?no=${bdto.getNo() }" method="post">
					<textarea name="rcontent" rows="4" cols="100" required></textarea>
					<input type = "submit" value ="댓글등록">
				</form>
			</td>
		</tr>
		<tr>
			<td align="right">
				<a href="write.jsp"><input type="button" value="글쓰기"></a>
				<a href="write.jsp?superno=${bdto.getNo() }"><input type="button" value="답글쓰기"></a>
				<c:if test="${isMine or isAdmin}">
<!-- 				수정/삭제 버튼은 관리자이거나 본인글에만 표시 -->
				<a href="edit.jsp?no=${bdto.getNo() }"><input type="button" value="수정"></a>
				<a href="delete.do?no=${bdto.getNo() }"><input type="button" value="삭제"></a>
				</c:if>
				<a href="list.do"><input type="button" value="목록"></a>
			</td>
		</tr>
	</table>	
</div>
<br><br>
<jsp:include page="/template/footer.jsp"></jsp:include>