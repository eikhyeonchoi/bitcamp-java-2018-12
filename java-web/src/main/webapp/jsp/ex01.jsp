<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ex01</title>
</head>

<body>
<h1>JSP 구동원리</h1>
<pre>
1) 웹브라우져 ==> 서블릿 컨테이너
   - JSP 실행 요청
2) 서블릿 컨테이너가 실행
   - JSP의 서블릿 객체를 찾는다
   - 있으면, 
     그 서블릿 객체를 호출한다
   - 없으면,
     JSP 엔진을 이용해 JSP파일을 가지고 서블릿 자바 소스 파일을 생성한다
     자바 컴파일러를 이용해 소스파일을 컴파일 한다
     서블릿 객체를 생성한다 ==> init() 호출
     그 서블릿 객체를 호출한다 ==> service() 호출
   - JSP 파일이 변경된 상태라면,
     "- 없으면" 항목을 반복한다
3) 서블릿 컨테이너 ==> 웹브라우저
   - 서블릿 실행 결과를 응답
   
JSP 파일을 가지고 생성한 서블릿 소스와 클래스 파일의 위치
   - 배치파일의 work 폴더에 있음
   
정리 !!
   - JSP 파일은 Python이나 PHP처럼 직접 그 스크립트가 인터프리팅 되는 것이 아니다
   - JSP 엔진의 역할은 JSP 파일을 분석해 서블릿 클래스를 생성하는 것이다
   - 즉 JSP 파일이 직접 실행되지 않는다
   
JSP
   - 자바 서블릿 클래스를 만드는 재료임!
   - 그래서 서블릿 클래스를 만드는 "틀" 이라서 "템플릿"이라고 부른다
   - JSP를 템플릿 기술이라고 부르기도 한다!!!

JSP 공부법
   - JSP를 작성할 때 사용하는 특정 태그들이 어떤 자바 코드를 생성하는지 이해해야함
   
JSP 실행 요청
   - JSP 파일이 있는 위치를 지정한다
   - localhost:8080/java-web/jsp/ex01.jsp
   
</pre>

</body>
</html>