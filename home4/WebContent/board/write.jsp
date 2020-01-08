<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	boolean isReply = request.getParameter("superno") != null;
%>
<jsp:include page="/template/header.jsp"></jsp:include>

<link href="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/css/suneditor.min.css" rel="stylesheet">
<!-- <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/assets/css/suneditor.css" rel="stylesheet"> -->
<!-- <link href="https://cdn.jsdelivr.net/npm/suneditor@latest/assets/css/suneditor-contents.css" rel="stylesheet"> -->
<style>
    textarea[name=content]{
        width:100%;
        height:150px;
    }
</style>

<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/dist/suneditor.min.js"></script>
<!-- languages (Basic Language: English/en) -->
<script src="https://cdn.jsdelivr.net/npm/suneditor@latest/src/lang/ko.js"></script>
<script>
    function loadEditor(){
        var editor = SUNEDITOR.create((document.querySelector('textarea[name=content]')),{
            //언어 설정
            lang: SUNEDITOR_LANG['ko'],
            
            //버튼 목록
            buttonList:[
                ['font', 'fontSize', 'fontColor'], 
                ['underline', 'italic', 'paragraphStyle', 'formatBlock'],
                ['align', 'table', 'image']
            ],
            //글꼴 설정
            font:[
                '굴림', '궁서', 'Verdana', 'Arial'
            ],
            //크기 설정
            fontSize:[
                10, 16, 32
            ],
            
        });
    
	  	//중요 : 키입력시마다 값을 원래위치(textarea)에 복사
	    editor.onKeyUp = function(e){
	    	var content = document.querySelector("textarea[name=content]");
	    	content.value = editor.getContents();
	    }

//         수정일 때는 아래의 코드가 필요(초기데이터 출력)
<%--         editor.setContents('<%=dto.getContent()%>'); --%>
    }
    
    //윈도우 로딩 시 loadEditor를 실행하도록 설정(body에 onload 한 효과)
    window.onload = loadEditor;
</script>

<div align="center">

	<h2>게시글 작성</h2>
	<h5>타인에 대한 비방글은 예고 없이 삭제될 수 있습니다</h5>
	
	<form action="write.do" method="post" enctype="multipart/form-data">
		<%if(isReply){ %>
		<!-- 답변글일 경우에는 no가 있기 때문에 등록시 사용하도록 숨김 첨부해야한다 -->
		<input type="hidden" name="superno" value="<%=request.getParameter("superno")%>">
		<%} %>
	
		<table border="1" width="70%">
			<tr>
				<th>말머리</th>
				<td>
					<select name="head">
						<option value="">선택하세요</option>
						<option>공지</option>
						<option>정보</option>
						<option>유머</option>
					</select>		
				</td>
			</tr>
			<tr>
				<th>제목</th>
				<td>
					<%if(isReply){ %>
					<input type="text" name="title" value="RE:" required>
					<%}else{ %>
					<input type="text" name="title" required>
					<%} %>
				</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td>
					<input type="file" name="file" accept=".jpg, .png, .gif">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<textarea name="content" required></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="등록하기">
					<a href="list.jsp">
						<input type="button" value="목록보기">
					</a>
				</td>
			</tr>
		</table>
		
	</form>

</div>

<jsp:include page="/template/footer.jsp"></jsp:include>




