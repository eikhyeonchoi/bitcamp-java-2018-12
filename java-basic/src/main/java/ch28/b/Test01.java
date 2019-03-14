//l 애노테이션 유지범위
//l ==> Class :.class 파일까지는 유지된다, 그러나 runtime에는 메모리에 로딩되지 않는다
//l            애노테이션 범위를 지정하지 않으면 기본이 CLASS
//l ==> SOURCE : 컴파일할 때 제거된다 .class파일에 포함되지 않는다, 컴파일할 때 제거된다
//l              보통 소스파일 에서 애노테이션 값을 꺼내 다른 파일을 자동 생성하는 도구를 만들때 주로 사용
//l ==> RUNTIME : .class파일까지 유지되고, runtime에 메모리에 로딩된다
//l               실행 중에 애노테이션을 참조해야 할 경우 주로 사용
package ch28.b;

import java.lang.annotation.Annotation;

@MyAnnotation // .class에서 확인가능 
@MyAnnotation2 // .class에서 확인 x
@MyAnnotation3 // .class에서 확인가능 
public class Test01 {
  public static void main(String[] args) {
    
    //l 실행할 때 추출 여부 확인하기
    //l ==> 애노테이션 추출하기
    Class<?> clazz = Test01.class;
    Annotation[] annotations = clazz.getAnnotations();
    
    //l MyAnnotation은 유지범위가 CLASS라 실행할 때 로딩 x
    //l 따라서 실행중에 애노테이션 정보 추출x
    //l MyAnnotation3은 유지범위가 RUNTIME라 실행할 때 로딩 된다
    //l 따라서 실행중에 애노테이션 정보 추출 가능
    for(Annotation a : annotations) {
      System.out.println(a.annotationType().getName());
    }
  }
} // end of class
