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

<title>새 글</title>
</head>
<body>
  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>새 글</h1>

    <form action='add' method='post'>
      <div class="contents row">
        <label for="contents" class="col-sm-2 col-form-label">내용</label>
        <div class="col-sm-6">
          <textarea class="form-control" id='contents' name='contents' rows='3'></textarea>
        </div>
      </div>

      <div class="form-group row">
        <div class="col-sm-10">
          <button class="btn btn-primary">등록</button>
          <a class="btn btn-primary" href='.'>목록</a>
        </div>
      </div>
    </form>
  </div> <!-- <div class="container"> -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>
