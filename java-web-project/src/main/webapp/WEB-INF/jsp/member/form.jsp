<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
  trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
  href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
  integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
  crossorigin="anonymous">
<link rel="stylesheet" href="${contextRootPath}/css/common.css" />

<title>새 회원</title>
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">
    <h1>새 회원</h1>

    <form action='add' method='post' enctype='multipart/form-data'>
      <div class="contents row">
        <label for="name" class="col-sm-2 col-form-label">이름</label>
        <div class="col-sm-6">
          <input class="form-control" id='name' name='name'>
        </div>
      </div>

      <div class="contents row">
        <label for="email" class="col-sm-2 col-form-label">이메일</label>
        <div class="col-sm-6">
          <input class="form-control" id='email' name='email'>
        </div>
      </div>

      <div class="contents row">
        <label for="password" class="col-sm-2 col-form-label">암호</label>
        <div class="col-sm-6">
          <input type="password" class="form-control" id='password' name='password'>
        </div>
      </div>

      <div class="contents row">
        <label for="photoFile" class="col-sm-2 col-form-label">사진</label>
        <div class="col-sm-6">
          <input type="file" class="form-control" id='photoFile' name='photoFile'>
        </div>
      </div>

      <div class="contents row">
        <label for="tel" class="col-sm-2 col-form-label">전화</label>
        <div class="col-sm-6">
          <input type="text" class="form-control" id='tel' name='tel'>
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
  <!-- <div class="container"> -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>




