<%@page import="java.util.ArrayList"%>
<%@ page 
   language="java" 
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
   errorPage="ex20_error.jsp"
%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ex20</title>
</head>
<body>
<h1>errorPage, isErrorPage</h1>
10 / 0 <%= 10 / 0 %>

</body>
</html>
<%--
errorPage
==> JSP를 실행하는 중에 오류가 발생했을 때 실행할 JSP를 지정할 수 있다
==> 어떻게?
    <%@ page errorPage="URL"%>
==> 이 속성에 URL을 지정하지 않으면
isErrorPage
==>
 --%> 
 
 