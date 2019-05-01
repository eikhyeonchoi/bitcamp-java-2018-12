<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonCss.jsp" />
<title>회원 검색</title>
</head>
<body>
  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>회원 검색</h1>

    <div id="bit-list">
    
    <table class='table table-hover'>
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">이름</th>
            <th scope="col">이메일</th>
            <th scope="col">전화</th>
            <th scope="col">가입일</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach items="${list}" var="member">
            <tr>
              <th scope="row">${member.no}</th>
              <td><a href='${member.no}'>${member.name}</a></td>
              <td>${member.email}</td>
              <td>${member.tel}</td>
              <td>${member.registeredDate}</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
      
      <p>
        <a class="btn btn-primary" href='.'>목록</a>
      </p>
      
    </div>
    
  </div><!-- <div class="container"> -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>
