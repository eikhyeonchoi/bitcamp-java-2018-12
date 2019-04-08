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
	<title>ex14</title>
</head>

<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>
<%
ArrayList<String> names = new ArrayList<>();
names.add("홍길동");
names.add("임꺽정");
names.add("안중근");
names.add("윤봉길");
pageContext.setAttribute("list", names);
%>


<jsp:useBean id="list" type="java.util.List<String>" scope="page"/>
<!--  
== ArrayList<String> list = (ArrayList<String>) applicaiton.getAttribute("s1");
== List<String> list = (List<String>) applicaiton.getAttribute("s1");

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
 
 