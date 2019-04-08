<%@ page 
   language="java" 
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   import="java.net.Socket"
   import="java.net.ServerSocket"
   import="java.util.List, java.util.Map, java.util.Set"
   trimDirectiveWhitespaces="true"
   buffer="8kb"
   autoFlush="false"
%>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.Statement" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ex08</title>
</head>

<body>

<h1>지시문(directive element) - include</h1>
<%@ include file="ex08_header.txt"%>
<p>테스트</p>
<%@ include file="ex08_footer.txt"%>
</body>
</html>
<%--
include 지시문
1) file="JSP에 포함시킬 파일 경로"
   - JSP로 포함시킨 후에 자바 서블릿 클래스를 생성한다
   - 따라서 일반 텍스트 파일이면 된다, JSP 파일일 필요가 없다 
   - RequestDispatcher의 include()와 다름
   - 비록 JSP 파일이 아니더라도 다음을 선언하여 해당파일의 문자 집합을 지정해야한다
        <%@ page pageEncoding="UTF-8%>
   - JSP 엔진에 해당 파일의 내용을 가져올 때 pageEncoding에 지정된 문자집합으로 내용인식
     또한 JSP 엔젠은 <%@ page... %> 를 참고만 할 뿐 가져오지는 않는다
     
   
 --%>
 
 
 
 
 
 
 
 
 
 
 
 