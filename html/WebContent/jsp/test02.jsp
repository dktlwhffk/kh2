<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 테이블</title>
</head>
<body>
<div align = "center">
<h1> 구구단 테이블</h1>
<table border = "1" width="50%">
	<thead bgcolor = "orange">
		<tr>
			<th>2단</th>
			<th>3단</th>
			<th>4단</th>
			<th>5단</th>
			<th>6단</th>
			<th>7단</th>
			<th>8단</th>
			<th>9단</th>
		</tr>
	</thead>
	<tbody align = "center">
	<% for(int i =1; i<10; i++){%>
		<tr>
			<br>
		<%for(int j = 2; j<10; j++){%>
			<td><%=j%> X <%=i%>=<%=i*j %></td>
<%}}%>
		</tr>		
	</tbody>
</table>


</div>
</body>
</html>