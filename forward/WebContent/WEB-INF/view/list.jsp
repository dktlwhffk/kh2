<%@page import="home.beans.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberDto> list = (List<MemberDto>)request.getAttribute("list");
%>

<% for(MemberDto dto : list){ %>
	<h3><%=dto %></h3>
<%}%>