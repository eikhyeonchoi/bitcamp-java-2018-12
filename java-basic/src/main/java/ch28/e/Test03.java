//l 애노테이션 프로퍼티
//l ==> 메스더 선언하는 문법과 비슷
//l ==> 기본 값을 지정하지 않으면 필수입력
//l ==> value라는 이름을 갖는 프로퍼티 일 경우
//l     값을 지정할 때 이름 생략 가능
package ch28.e;

public class Test03 {
  
  
  @MyAnnotation6(value = {"aaa"}) // 배열의 값을 지정할 때는 중괄호로 묶는다 value이름 생략가능
  int a;
  
  @MyAnnotation6({"aaa"}) // 배열의 값을 지정할 때는 중괄호로 묶는다 value이름 생략가능
  int b;
  
  @MyAnnotation6("aaa") // 배열의 값이 하나 일경우 중괄호 생략가능
  int c;
  
  //@MyAnnotation6("aaa","bbb") // 배열의 값이 여러개 일경우 중괄호 생략 불가능
  int d;
  
  @MyAnnotation6({"aaa","bbb"}) // 배열의 값이 여러개 일경우 중괄호 생략 불가능
  int e;
} // end of class
