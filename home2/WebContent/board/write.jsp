<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/template/header.jsp"></jsp:include>
<div align = "center">
	<h2>글쓰기</h2>
<!-- 	<div align = "left"> -->
<!-- 	<form action = "file.do" method="post"> -->
<!-- 		<input type = "file" name = "file" value = "파일 첨부" accept=".jpg,.png,.gif"> -->
<!-- 	</form> -->
<!-- 	</div> -->
<form action="write.do" method = "post" enctype="multipart/form-data">
	
	<%if(request.getParameter("superno") !=null){ %>
	<!-- 답변글일 경우에는 no가 있기 때문에 등록시 사용하도록 숨김 첨부해야하한다. -->
	<Input type = "hidden" name = "superno" value = "<%=request.getParameter("superno") %>">
	<%} %>	
		
	<table border="1">
		<tr>
			<th>말머리</th>
			<td>
				<select name="head">
    				<option value="">말머리 선택</option>
    				<option value="공지">공지</option>
    				<option value="정보">정보</option>
    				<option value="유머">유머</option>
				</select>
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>
				<input type = "text" name="title" required>
			</td>
		</tr>
		
		<tr>
			<th>내용</th>
			<td>	
				<textarea name = "content" rows="15" cols="150" required
				style="resize:vertical;"></textarea>
			</td>
		</tr>
		<tr>
			<td>
			<input type = "submit" value="글올리기">
			</td>
			<td>
			<input type = "file" name = "file" value = "파일 첨부" accept=".jpg,.png,.gif">
			</td>
		</tr>
	</table>
	</form>
</div>
<jsp:include page="/template/footer.jsp"></jsp:include>
