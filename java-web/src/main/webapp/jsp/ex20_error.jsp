<%@page import="java.util.ArrayList"%>
<%@ page 
   language="java" 
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
   isErrorPage="true"
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ex20</title>
</head>
<body>
<h1>오류 발생!</h1>
<%= exception.getMessage() %>

</body>
</html>
<%--
오류가 발생했을 때 실행되는 JSP 페이지는
exeception 이라는 변수를 통해 오류 내용을 받을 수 있다
단, isErrorPage속성이 true 여야 가능함
 --%> 
 
 