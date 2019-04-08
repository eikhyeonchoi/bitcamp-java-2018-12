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
	<title>ex18</title>
</head>

<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>
<%-- 향상된 for문을 제대로 사용하려면 목록에 보관된 객체의 타입이 무엇인지
     제네릭으로 지정해야 한다 그러나 class에서는 제네릭을 지정할 수 없다
     해결 책?
     - type과 class를 함께써라
     - type으로 제네릭을 표현하고 class로 객체를 생성할 클래스를 지정
     
--%>
<jsp:useBean id="list" type="java.util.List<String>" class="java.util.ArrayList" scope="page"/>
<!--  
== ArrayList<String> list = (ArrayList<String>) applicaiton.getAttribute("s1");
== List<String> list = (List<String>) applicaiton.getAttribute("s1");
if(list == null){
  list = new ArrayList<String>();
  pageContext.setAttribute("list", list);
}

 -->
<%
// type 속성에서 제네릭으로 String을 지정했기 때문에 Object말고 String으로 지정가능
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
 
 