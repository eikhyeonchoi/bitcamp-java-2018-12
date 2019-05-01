<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonCss.jsp" />
<title>사진 조회</title>
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>사진 조회</h1>
    <c:choose>
      <c:when test="${empty board}">
        <p>해당 사진을 찾을 수 없습니다.</p>
      </c:when>

      <c:otherwise>
        <form action='update' method='post'
          enctype='multipart/form-data'>

          <div class="form-group row">
            <label for="no" class="col-sm-2 col-form-label">번호</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext" id="no"
                name='no' value='${board.no}' readonly>
            </div>
          </div>

          <div class="form-group row">
            <label for="title" class="col-sm-2 col-form-label">제목</label>
            <div class="col-sm-10">
              <input type="text" class="form-control" id="title"
                name='title' value='${board.title}'>
            </div>
          </div>

          <div class="form-group row">
            <label for="createdDate" class="col-sm-2 col-form-label">작성일</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext"
                id="createdDate" value='${board.createdDate}'>
            </div>
          </div>

          <div class="form-group row">
            <label for="viewCount" class="col-sm-2 col-form-label">조회수</label>
            <div class="col-sm-10">
              <input type="text" class="form-control-plaintext"
                id="viewCount" value='${board.viewCount}'>
            </div>
          </div>

          <div class="contents row">
            <label for="dropdownMenuButton"
              class="col-sm-3 col-form-label">수업</label>
            <div class="dropdown">
              <select class="btn btn-secondary dropdown-toggle"
                id="dropdownMenuButton" data-toggle="dropdown"
                aria-haspopup="true" aria-expanded="false"
                name="lessonNo">
                <c:forEach items="${lessons}" var="lesson">
                  <option value="${lesson.no}"
                    ${board.lessonNo == lesson.no ? "selected" : ""}>${lesson.title}(${lesson.startDate}
                    ~ ${lesson.endDate})</option>
                </c:forEach>
              </select>
            </div>
          </div>
          <br>

          <h4>최소 한 개의 사진 파일을 등록해야 합니다</h4>
          <div class="contents row">
            <label for="photo" class="col-sm-2 col-form-label">사진1</label>
            <div class="col-sm-6">
              <input type="file" class="form-control" id='photo'
                name='photo'>
            </div>
          </div>

          <div class="contents row">
            <label for="photo" class="col-sm-2 col-form-label">사진2</label>
            <div class="col-sm-6">
              <input type="file" class="form-control" id='photo'
                name='photo'>
            </div>
          </div>

          <div class="contents row">
            <label for="photo" class="col-sm-2 col-form-label">사진3</label>
            <div class="col-sm-6">
              <input type="file" class="form-control" id='photo'
                name='photo'>
            </div>
          </div>

          <div class="contents row">
            <label for="photo" class="col-sm-2 col-form-label">사진4</label>
            <div class="col-sm-6">
              <input type="file" class="form-control" id='photo'
                name='photo'>
            </div>
          </div>

          <div class="contents row">
            <label for="photo" class="col-sm-2 col-form-label">사진5</label>
            <div class="col-sm-6">
              <input type="file" class="form-control" id='photo'
                name='photo'>
            </div>
          </div>

          <c:forEach items="${board.files}" var="file">
            <img
              src='${contextRootPath}/upload/photoboard/${file.filePath}'
              class="img-thumbnail">
          </c:forEach>
          <table border='1'>
          </table>
          
          <div class="form-group row">
            <div class="col-sm-10">
              <button class="btn btn-primary">변경</button>
              <a class="btn btn-primary" href='.'>목록</a> <a
                class="btn btn-primary" href='delete/${board.no}'>삭제</a>
            </div>
          </div>
        </form>
      </c:otherwise>
    </c:choose>
  </div>

  <jsp:include page="../javascript.jsp" />
</body>
</html>