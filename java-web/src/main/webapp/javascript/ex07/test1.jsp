<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test1.jsp실행</h1>
</body>
</html>
<%
  // 다른 도메인에서 AJAX 요청이 들어왔을 때 이 JSP의 결과를 가져가도록 허락한다
  // ==> 이 헤더를 붙이지 않는다면, 다른 도메인의 AJAX 요청은 거절된다
  response.setHeader("Access-Control-Allow-Origin","*");
%>