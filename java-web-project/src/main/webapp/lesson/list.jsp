<%@page import="com.eomcs.lms.domain.Lesson"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
List<Lesson> lessons = (List<Lesson>) request.getAttribute("lessons");
%>
<html>
<head>
<title>수업 목록(JSP)</title>
</head>
<body>
  <jsp:include page="/header.jsp"/>
	<h1>수업 목록(JSP)</h1>
	<p>
		<a href='add'>새 수업</a>
	</p>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>수업</th>
			<th>기간</th>
			<th>총교육시간</th>
		</tr>
		
		<% for (Lesson l : lessons) { %>
		<tr>
			<td><%= l.getNo() %></td>
			<td><a href='detail?no=<%= l.getNo()%>'><%= l.getTitle() %></a></td>
			<td><%= l.getStartDate()%> ~ <%= l.getEndDate()%></td>
			<td><%= l.getTotalHours() %></td>
		</tr>
		
		<% } %>
	</table>
	
	<a href='../index.html'>처음화면</a>
</body>
</html>
