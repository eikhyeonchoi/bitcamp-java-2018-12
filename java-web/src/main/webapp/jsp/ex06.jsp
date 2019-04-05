<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
public void init() throws ServletException{
  System.out.println("ex06.jsp.init()");
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex06</title>
</head>
<body>

<h1>선언부(declaration element)</h1>
100,000,000 입금 = <%= calculator(100000000) %>
<ul>
</ul>

</body>

<%!
double interest = 0.025;
private String calculator(long money){
  return String.format("%.2f",(money + (money * interest)));
}
%>

</html>
<%--
선언부 
- 클래스에 멤버를 추가할 때 사용한다
- jspInit()이나 jspDestroy()와 같은 메서드를 오버라이딩 할 때도 사용할 수 있다
- 문법
  <%! 멤버 선언 %>
- 자바 코드
  
 --%>