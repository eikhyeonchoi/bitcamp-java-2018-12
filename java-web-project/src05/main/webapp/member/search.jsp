<%@page import="com.eomcs.lms.domain.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
List<Member> members = (List<Member>) request.getAttribute("members");
%>
<html>
<head>
<title>회원 검색(JSP)</title>
</head>
<jsp:include page="/header.jsp"/>

<body>
	<h1>회원 검색(JSP)</h1>
	
		<%if(members.size() == 0){%>
		  <p>회원이 존재하지 않습니다</p>
		  
		<%} else {%>
		
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
		<% } %>
	
	</table>
	<p>
		<a href='list'>목록</a>
	</p>
</body>
</html>
