<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<% 

int i = 0;
%>
<head>
	<meta charset="UTF-8">
	<title>ex03</title>
	<% i=5; %>
</head>
<body>
<h1>스크립틀릿(scriptlet)과 JSP 주석</h1>
<%

out.println(i);
%>

<%--
JSP 주석
- 이 태그 안에 작성한 것은 자바 코드를 생성할 때 제거된다

스크립틀릿 ???
- JSP파일 안에 실행할 자바 코드를 넣은 태그
- 예)
  <% 자바코드 %>
- 자바 코드는 _jspService()안에 그대로 복사된다 
  
 --%>
<%

if (i < 10){
  for (int x = 0; x < i; x++){
    out.println("<p>" + x + "</p>\n");
  }
}

%>
</body>
</html>