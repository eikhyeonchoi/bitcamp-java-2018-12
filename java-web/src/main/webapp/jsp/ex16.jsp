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
	<title>ex16</title>
</head>

<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>

<%-- type 속성 대신에 class 속성을 사용하면
     id로 지정한 객체를 찾지 못했을 때 해당 객체를 만들고,
     그 id로 보관소에 저장한다
     단, 클래스 속성에는 generic속성을 사용할 수 없다
     쓸 때 타입을 지정해서 사용할 수 없다는 말임--%>
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"/>
<!--  
== ArrayList<String> list = (ArrayList<String>) applicaiton.getAttribute("s1");
== List<String> list = (List<String>) applicaiton.getAttribute("s1");
if(list == null){
  list = new ArrayList<String>();
  pageContext.setAttribute("list", list);
}

 -->
<%
// 제네릭 문법을 사용하지 못했기 때문에 list타입은 java.util.ArrayList이다
// 따라서 for 문에서 항목의 타입을 지정할 때 String으로 지정할 수 없다
// 만약 Object 대신 String으로 하면 
// 다음 오류가 발생한다
// JSP 파일 [/jsp/ex16.jsp]의 [37] 행에서 오류가 발생했습니다.
// Type mismatch: cannot convert from element type Object to String
for (Object n : list){
  out.println(n + "<br>");
}
%>

</body>
</html>
<%--
jsp:useBean
==> type : 
 --%>
 
 