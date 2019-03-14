//l 애노테이션 프로퍼티
//l ==> 메스더 선언하는 문법과 비슷
//l ==> 기본 값을 지정하지 않으면 필수입력
//l ==> value라는 이름을 갖는 프로퍼티 일 경우
//l     값을 지정할 때 이름 생략 가능
package ch28.e;

public class Test02 {
  /*
  @MyAnnotation4 (
      "okok", // value외에 다른 속성의 값도 함께설정할 경우 value이름 생략 x
      name = "홍길동",
      age = 20,
      working = true)*/
  int b;
  
  @MyAnnotation5("okok") // value 프로퍼티 값만 설정해도될 경우 이름 생략가능
  int c;
  
  
} // end of class
