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
	<title>ex17</title>
</head>

<body>
<h1>JSP 액션 태그 - jsp:useBean</h1>

<%-- id가 가라키는 객체가 보관소에 없을 때
     class 속성에 지정된 타입의 인스턴스를 생성한다
     그래서 class속성에는 인터페이슨 추상 클래스를 지정할 수 없다
     왜? 인터페이스나 추상클래스는 인스턴스를 생성할 수 없기 때문이다 --%>
<jsp:useBean id="list" class="java.util.ArrayList" scope="page"/>
<!--  
if(list == null){
  list = new List<String>(); ??????????????????????????????????
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
 
 