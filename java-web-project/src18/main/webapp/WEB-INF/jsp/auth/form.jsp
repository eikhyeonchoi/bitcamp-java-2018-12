<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>로asdasd그인</title>
<!-- jsp url 기준이 아님, WEB-INF/jsp 기준이 아님
     웹브라우저에서의 경로를 찾아야 함  
     jsp를 할꺼면 절대경로로 조지셈-->
  <jsp:include page="../commonCss.jsp" />
</head>
<body>

  <jsp:include page="../header.jsp" />
  <div class="container">

    <h1>로그인(JSP)</h1>
    <form action='login' method='post'>
      <div class="form-group">
        <label for="email">이메일</label>
        <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Enter email" value='${cookie.email.value}'>
          <small id="emailHelp" class="form-text text-muted">당신의 이메일을 다른사이트와 공유하지 않습니다</small>
      </div>
      
      <div class="form-group">
        <label for="password">암호</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="Password">
      </div>
      
     <div class="form-group form-check">
      <input type="checkbox" class="form-check-input" id="saveEmail" name="saveEmail">
      <label class="form-check-label" for="saveEmail">이메일 저장</label>
     </div>
      
      <button class="btn btn-primary">로그인</button>
    </form> <!-- <form action='login' method='post'> -->
    
    
  </div><!-- .container -->

  <jsp:include page="../javascript.jsp" />
</body>
</html>
