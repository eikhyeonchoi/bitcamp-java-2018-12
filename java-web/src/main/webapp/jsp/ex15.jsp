<%@page import="java.util.ArrayList"%>
<%@ page 
   language="java" 
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
%>
<%@ page import="bitcamp.vo.Board" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ex15</title>
</head>

<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>

<%-- id로 지정된 객체를 찾지 못하면 예외가 발생한다  --%>
<jsp:useBean id="list" type="java.util.List<String>" scope="page"/>
<!--  
== ArrayList<String> list = (ArrayList<String>) applicaiton.getAttribute("s1");
== List<String> list = (List<String>) applicaiton.getAttribute("s1");
if(list == null){
  throw new Throwable("list라는 이름의 빈이 없습니다");
}

 -->
<%
for (String n : list){
  out.println(n + "<br>");
}
%>

</body>
</html>
<%--
jsp:useBean
==> type : 
 --%>
 
 