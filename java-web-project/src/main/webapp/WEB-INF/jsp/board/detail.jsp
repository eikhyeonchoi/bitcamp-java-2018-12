<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css" />

<title>게시물 조회</title>
</head>
<body>
  <jsp:include page="../header.jsp" />

  <div class="container">
    <h1>게시물 조회</h1>
    <c:choose>
      <c:when test="${empty board}">
        <p>해당 게시물이 없습니다</p>
      </c:when>
      <c:otherwise>
        <form action='update' method='post'>

          <div class="form-group row">
            <label for="no" class="col-sm-2 col-form-label">번호</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="no" name='no' value='${board.no}'readonly>
            </div>
          </div>

          <div class="contents row">
            <label for="contents" class="col-sm-2 col-form-label">내용</label>
            <div class="col-sm-10">
              <textarea class="form-control" id='contents' name='contents' rows='3'>${board.contents}</textarea>
            </div>
          </div>

          <div class="form-group row">
            <label for="createdDate" class="col-sm-2 col-form-label">작성일</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="createdDate" readonly
                value="${board.createdDate}">
            </div>
          </div>

          <div class="form-group row">
            <label for="viewCount" class="col-sm-2 col-form-label">조회수</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="viewCount" readonly
                value="${board.viewCount}">
            </div>
          </div>
          
          <div class="form-group row">
            <div class="col-sm-10">
              <button class="btn btn-primary">변경</button>
              <a class="btn btn-primary" href='.'>목록</a> 
              <a class="btn btn-primary" href='delete/${board.no}'>삭제</a>
            </div>
          </div>
          
          
        </form>
      </c:otherwise>
    </c:choose>
  </div><!-- <div class="container"> -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>






