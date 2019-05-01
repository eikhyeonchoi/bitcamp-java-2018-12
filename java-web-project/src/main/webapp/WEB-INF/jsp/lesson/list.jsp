<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonCss.jsp" />
<title>수업 목록</title>
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>수업 목록</h1>
    <p>
      <a href='form' class="btn btn-primary btn-sm">새 수업</a>
    </p>


    <div id="bit-list">
      <table class='table table-hover'>
        <thead>
          <tr>
            <th scope="col">번호</th>
            <th scope="col">수업</th>
            <th scope="col">기간</th>
            <th scope="col">총교육시간</th>
          </tr>
        </thead>

        <tbody>
          <c:forEach items="${list}" var="lesson">
            <tr>
              <th scope="row">${lesson.no}</th>
              <td><a href='${lesson.no}'>${lesson.title}</a></td>
              <td>${lesson.startDate}~${lesson.endDate}</td>
              <td>${lesson.totalHours}</td>
            </tr>
          </c:forEach>
        </tbody>

      </table>
    </div>
    <!-- <div id="bit-list"> -->
    
    <nav aria-label="목록 페이지 이동">
      <ul class="pagination justify-content-center">
        <li class="page-item ${pageNo <= 1 ? 'disabled' : '' }"><a class="page-link"
          href="?pageNo=${pageNo - 1 }&pageSize=${pageSize}">이전</a></li>

        <%-- <li class="page-item active"><span class="page-link">${pageNo}</span></li>
         강사님 코드
          <c:if test="${totalPage == 1 }">
          
          </c:if>--%>
        <c:choose>
          <c:when test="${rowsCount == 0 }">
            <li class="page-item active">
              <a class="page-link">1</a>
            </li>
          </c:when> 
          
          <c:when test="${totalPage == 1 }">
            <li class="page-item active">
              <a class="page-link">${pageNo }</a>
            </li>
          </c:when>
          
          <c:otherwise>
            <c:forEach begin="${pageNo-1 }" end="${pageNo+1}" step="1" var="page">
              <li class="page-item ${page == pageNo ? 'active' : '' } ${(page < 1) || (page > totalPage) ? 'disabled' : ''}">
                <a class="page-link" href="?pageNo=${page }&pageSize=${pageSize }">${page }</a>
              </li>
            </c:forEach>
          </c:otherwise>
        </c:choose>

        <li class="page-item ${pageNo >= totalPage ? 'disabled' : '' }">
          <a class="page-link" href="?pageNo=${pageNo + 1 }&pageSize=${pageSize}">다음</a>
        </li>
      </ul>
    </nav>


  </div>
  <!-- <div class="container"> -->


  <jsp:include page="../javascript.jsp" />
</body>
</html>







