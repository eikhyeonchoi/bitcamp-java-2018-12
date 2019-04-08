<%@page import="com.eomcs.lms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
List<Member> members = (List<Member>)request.getAttribute("list");
%>
<html>
<head>
<title>회원 목록(JSP)</title>
</head>

<h1>회원 목록(JSP)</h1>

<body>
  <jsp:include page="/header.jsp"/>
  
	<p>
		<a href='add'>새 회원</a>
	</p>
	
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>이메일</th>
			<th>전화</th>
			<th>가입일</th>
		</tr>
		<% for (Member m : members) { %>
		<tr>
			<td><%= m.getNo() %></td>
			<td><a href='detail?no=<%= m.getNo()%>'><%= m.getName() %></a></td>
			<td><%= m.getEmail() %></td>
			<td><%= m.getTel() %></td>
			<td><%= m.getRegisteredDate() %></td>
		</tr>
		<% } %>
		
	</table>
	
	<form action='search'>
		<input type='text' name='keyword'>
		<button type='submit'>검색</button>
	</form>
	
	<a href='../index.html'>처음화면</a>
	
</body>
</html>
