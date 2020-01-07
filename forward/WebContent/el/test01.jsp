<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<h1>EL(Expression Language)</h1>
<p>
	표현식을 대체하기 위해 만들어진 언어. 즉, 표현(get)만 하는 언어
</p>

<h3>표현식 / 표현언어</h3>
<h3><%=1+2 %> , ${1+2}</h3>
<h3><%=3*2 %> , ${3*2}</h3>
<h3><%=2/3 %> , ${2/3}</h3>
<h3><%=2%3 %> , ${2%3}, ${2 mod 3}</h3>
<h3><%=100 == 200 %>, ${100==200}, ${100 eq 200}</h3>
<h3><%="hello".equals("hi") %>, ${'hello'=='hi'}</h3>
