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
	<title>ex07</title>
</head>

<body>

<h1>지시문(directive element)</h1>
<%
for (int i = 0; i < 1000; i++){
  out.println(". ");
}
%>
</body>
</html>
<%--
지시문
1) page
   - 서블릿 실행과 관련하여 특정 기능을 설정한다
2) include
   - 다른 파일의 내용을 복사해온다
3) taglib
   - JSTL등 외부에서 정의한 태그 정보를 가져온다
   
page 지시문
1) language="java"
   - JSP 페이지에서 코드를 작성할 때 사용할 언어를 지정한다
   - 즉, <% 코드 %>, <%= 표현식 %>, <%! 코드 %> 태그에 코드를 작성할 때 사용할 언어
   - 원래는 다양한 언어를 사용할 경우를 고려해 설계되었지만, 
   - 현재는 자바 언어만 사용가능 ==> 이 속성은 생략가능
2) contentType="text/html; charset=UTF-8"
   - 다음 자바 코드를 생성한다
     response.setContentType("text/html; charset=UTF-8");
3) pageEncoding="UTF-8"
   - JSP 파일의 인코딩을 설정한다
   - JSP 파일을 저장할 때 UTF-8로 저장한다면, 위와 같이 선언해야함
   - 생략한다면 에디터에 설정된 문자집합으로 인코딩한다 (eclipse)
4) import="java.net.socket"
   - 자바의 import문을 생성한다
   - 사용법
     import="java.net.Socket, java.net.ServerSocket, java.util.List"
     ==> 자바코드
         import java.net.Socket;
         import java.net.ServerSocket;
         import java.net.List;
   - 한 개의 page 지시문에 여러개의 import를 작성할 수 있다
   - 여러 개의 page 지시문을 작성할 수 있다
5) trimDirectiveWhitespace="true"
   - 지시문 끝에 줄바꿈 코드를 무시하고 싶을때 사용한다
6) buffer="8kb"
   - 출력 버퍼의 크기를 변경할 때 사용한다
   - 지정하지 않으면 기본이 8kb이다
   - 출력 내용이 버퍼의 크기를 넘으면 예외가 발생한다
     서블릿의 경우 자동으로 
     그러나 JSP는 예외가 발생한다
7) autoFlush="false"
   - 출력 버퍼가 찾을 때 자동으로 출력하고 싶다면
     "true"로 설정, 기본은 "true"로 설정되어 있다
     "fasle"로 설정하면 출력 버퍼가 찾을 때 예외가 발생한다

 --%>