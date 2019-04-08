<%@ page 
   language="java" 
   contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"
   trimDirectiveWhitespaces="true"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>ex09</title>
</head>

<body>
<h1>지시문(directive element) - taglib</h1>
 <c:forEach items="유관순, 홍길동, 안중근, 김구" var="n">
 이름= <%=pageContext.getAttribute("n")%>, ${n}<br>
 </c:forEach>
 
</body>
</html>

<%--
taglib 지시문
==> 외부에 따로 정의된 JSP 확장 태그를 가져올 때 사용한다
==> JSP 확장태그
    1) JSTL(JSP Standard Tag Library)
        - JSP 명세에 추가로 정의된 태그이다
        - Servlet/JSP API에서는 JSTL 구현체를 제공하지 않는다
        - 따로 구현된 라이브러리를 다운로드 받아야 한다
        - 보통 apache.org 사이트에 구현한 것을 사용한다
    2) 개발자가 정의한 태그
        - 개발자가 따로 태그를 정의할 수 있다
        - 그러나 실무에서는 유지보수의 일관성을 위해 JSTL과 같은 표준 API를 사용
        - 즉 개발자가 자신의 회사에서만 사용할 태그를 따로 정의x 

==> 사용법
<%@ taglib uri="확장 태그를 정의할 때 부여한 확장 태그 URI" 
            prefix="확장 태그를 사용할 때 사용하는 접두사" %>
    JSP 페이지에서 사용하기
        <확장태그접두사:사용자태그명 속성명="값"
 --%>
 
 
 
 
 
 
 
 
 
 
 
 