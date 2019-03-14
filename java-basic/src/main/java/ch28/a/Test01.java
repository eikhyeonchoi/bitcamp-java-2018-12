//l 애노테이션
//l ==> 클래스, 필드, 메서드, 로컬변수에 붙이는 특별한 주석
//l ==> 다른 주석과 달리 컴파일이나 실행할 때 추출할 수 있음
//l ==> 일반 주석과 달리 프로퍼티=값 형태로 값을 다룰 수 있다
//l ==> 사용법
//l     - 애노테이션 정의 또는 기존 정의된 애노테이션사용
//l     - 클래스나 인터페이스에 적용
package ch28.a;

@MyAnnotation // 클래스 선언에 붙일 수 있음
public class Test01 {

  @MyAnnotation // 필드에도 붙일 수 있다
  static int a;
  
  @MyAnnotation
  // @MyAnnotation 중복 불가
  int b;
  
  @MyAnnotation // 메서드 선언에 붙일 수 있음
  void m1(
      @MyAnnotation int p1, // 로컬변수(파라미터)에 붙일 수 있다
      @MyAnnotation String p2) {
    
    @MyAnnotation // 로컬변수(파라미터)에 붙일 수 있다
    int local; 

    // @MyAnnotation // 일반 문장에 붙일 수 없다
    System.out.println("");
    
    // @MyAnnotation // 일반 문장에 붙일 수 없다
    for(int i = 0; i < 100; i++) {
      @MyAnnotation // 로컬변수(파라미터)에 붙일 수 있다
      int a;
      
    }
  } // m1()
  
  @MyAnnotation // 메서드 선언에 붙일 수 있음 (static, non-static 모두 가능)
  static void m2() {
    
  } // m2()
  
  
} // end of class
