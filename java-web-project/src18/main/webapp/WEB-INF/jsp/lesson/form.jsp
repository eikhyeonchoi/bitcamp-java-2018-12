<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../commonCss.jsp" />
<title>수업 등록</title>
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>수업 등록</h1>
    <form action='add' method='post'>

      <div class="contents row">
        <label for="title" class="col-sm-2 col-form-label">제목</label>
        <div class="col-sm-6">
          <input class="form-control" id='title' name='title' />
        </div>
      </div>

      <div class="contents row">
        <label for="contents" class="col-sm-2 col-form-label">제목</label>
        <div class="col-sm-6">
          <textarea class="form-control" id='contents' name='contents' rows="3"></textarea>
        </div>
      </div>

      <div class="contents row">
        <label for="startDate" class="col-sm-2 col-form-label">시작일</label>
        <div class="col-sm-6">
          <input type="date" class="form-control" id='startDate' name='startDate' />
        </div>
      </div>

      <div class="contents row">
        <label for="endDate" class="col-sm-2 col-form-label">종료일</label>
        <div class="col-sm-6">
          <input type="date" class="form-control" id='endDate' name='endDate' />
        </div>
      </div>

      <div class="contents row">
        <label for="totalHours" class="col-sm-2 col-form-label">총 교육시간</label>
        <div class="col-sm-6">
          <input type="number" class="form-control" id='totalHours' name='totalHours' />
        </div>
      </div>

      <div class="contents row">
        <label for="dayHours" class="col-sm-2 col-form-label">일 교육시간</label>
        <div class="col-sm-6">
          <input type="number" class="form-control" id='dayHours' name='dayHours'/>
        </div>
      </div>

      <div class="form-group row">
        <div class="col-sm-10">
          <button class="btn btn-primary">등록</button>
          <a class="btn btn-primary" href='.'>목록</a>
        </div>
      </div>
  
    </form>

  </div>
  <!--  <div class="container">-->

  <jsp:include page="../javascript.jsp" />
</body>
</html>
