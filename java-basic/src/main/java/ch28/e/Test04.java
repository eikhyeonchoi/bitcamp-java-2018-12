//l 애노테이션 프로퍼티
//l ==> 메스더 선언하는 문법과 비슷
//l ==> 기본 값을 지정하지 않으면 필수입력
//l ==> value라는 이름을 갖는 프로퍼티 일 경우
//l     값을 지정할 때 이름 생략 가능
package ch28.e;

import java.lang.annotation.Annotation;

@MyAnnotation7(
    name = "홍길동",
    age = 20)
public class Test04 {
  public static void main(String[] args) {
    
    MyAnnotation7 anno = Test04.class.getAnnotation(MyAnnotation7.class);
    for(String s : anno.value()) {
      System.out.println(s);
    }
    System.out.println(anno.name());
    System.out.println(anno.age());
    System.out.println(anno.working());

    
    Annotation[] annotations = Test04.class.getAnnotations();
    MyAnnotation7 asd = (MyAnnotation7) annotations[0];
    for(String a : asd.value()) {
      System.out.println(a);
    }
    
    
    
    
    
  }
} // end of class
