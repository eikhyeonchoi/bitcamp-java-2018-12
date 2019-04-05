<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
String[] names = {"홍길동","임꺽정","유관순"};
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex05</title>
</head>
<body>

<h1>표현식(express element)</h1>
<%--
1) 문장(statement)
   if() { ... }
   else { ... }
   for () { ... } 등등
   
2) 표현식(expression)
   - 값을 리턴하는 문장
     a * b ==> 곱하기 결과 return 
     ( ... ) ? a : b ==> 조건에 따라 a 또는 b return
     plus(10, 20); ==> plus 메서드의 실행 값 return
     out.println(" ... "); ==> 이 문장은 값을 return 하지 않아서 expression이 아니다
     
문법 : 
   <%= 표현식 %>
자바 코드 :
   out.println(표현식)
   또는
   out.write(표현식)
 --%>
<ul>

<%for(String name : names){%>
<li><%=name%></li>
<%}%>

</ul>

</body>
</html>