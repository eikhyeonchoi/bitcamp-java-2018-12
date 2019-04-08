<%@page import="com.eomcs.lms.domain.PhotoBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<%
List<PhotoBoard> photoBoards = (List<PhotoBoard>)request.getAttribute("photoBoards");

%>
<html>
<head>
<title>사진 검색(JSP)</title>
</head>

<body>
  <jsp:include page="/header.jsp"/>
  
	<h1>사진 검색 결과(JSP)</h1>
	<table border='1'>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
			<th>수업</th>
		</tr>
		<% for (PhotoBoard p : photoBoards) { %>
		<tr>
			<td>1</td>
			<td><a href='detail?no=<%= p.getNo()%>'><%= p.getTitle() %></a></td>
			<td><%= p.getCreatedDate() %></td>
			<td><%= p.getViewCount() %></td>
			<td><%= p.getLessonNo() %></td>
		</tr>
		<% } %>
	</table>
	<p>
		<a href='list'>목록</a>
	</p>
</body>
</html>
