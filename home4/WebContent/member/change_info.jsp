<%@page import="home.bean.MemberDto"%>
<%@page import="home.bean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//사용자의 아이디를 이용하여 정보를 불러와서 출력
	String id = (String) session.getAttribute("id");
	MemberDao dao = new MemberDao();
	MemberDto dto = dao.get(id);
%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>회원 정보 수정</h2>
	
	<form action="change_info.do" method="post">
		
		<table border="0"> 
			<tr>
				<th>전화번호</th>
				<td>
					<input type="tel" name="phone" value="<%=dto.getPhone()%>" required>
				</td>
			</tr>		
			<tr>
				<th rowspan="3">주소</th>
				<td>
					<input type="text" name="post" value="<%=dto.getPostStr()%>" placeholder="우편번호" size="6">
				</td> 
			</tr>	
			<tr>
				<td>
					<input type="text" name="basic_addr" value="<%=dto.getBasic_addrStr()%>" placeholder="기본주소" size="50">
				</td>
			</tr>	
			<tr>
				<td>
					<input type="text" name="extra_addr" value="<%=dto.getExtra_addrStr()%>" placeholder="상세주소" size="50">
				</td>
			</tr>	
			<tr>
				<th colspan="2">
					<input type="submit" value="수정하기">
				</th>
			</tr>
		</table>
		
	</form>
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>