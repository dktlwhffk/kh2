<%@page import="home.bean.MemberDto"%>
<%@page import="home.bean.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<jsp:include page="/template/header.jsp"></jsp:include>

<div align="center">
	
	<h2>${dto.id} 님의 정보</h2>
	
	<table border="1" width="450">
		<tr>
			<th width="25%">아이디</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td>${dto.name}</td>
		</tr>
		<tr>
			<th>등급</th>
			<td>${dto.grade}</td>
		</tr>
		<tr>
			<th>포인트</th>
			<td>${dto.point} point</td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td>${dto.phone}</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
<%-- 				${dto.address} --%>
				${dto.getAddress()}
			</td>
		</tr>
		<tr>
			<th>가입일</th>
			<td>${dto.getJoindateWithFormat()}</td>
		</tr>
		<tr>
			<th>최종로그인</th>
			<td>${dto.getLast_loginWithFormat()}</td>
		</tr>
	</table>
	
	<!-- 다른 기능으로 링크 -->
	<h4><a href="check.jsp?go=/member/change_pw.jsp">비밀번호 변경</a></h4>
	<h4><a href="check.jsp?go=/member/change_info.jsp">회원정보 수정</a></h4>
	<h4><a href="check.jsp?go=/member/exit.do">회원 탈퇴</a></h4>	
	
</div>

<jsp:include page="/template/footer.jsp"></jsp:include>


