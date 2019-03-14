//l 애노테이션 사용범위
//l ==> @Target을 이용해 애노테이션을 붙일 수 있는 위치를 지정할 수있다
//l 
//l 
//l 
//l 
//l 
//l 
//l 

package ch28.c;

@MyAnnotation // 클래스, 인터페이스
//@MyAnnotation2 // 필드 
//@MyAnnotation3  // 메서드
//@MyAnnotation4  // 로컬
public class Test01 {

  //@MyAnnotation // 클래스, 인터페이스
  @MyAnnotation2 // 필드 
  //@MyAnnotation3  // 메서드
  //@MyAnnotation4  // 로컬
  int i;

  //@MyAnnotation // 클래스, 인터페이스
  @MyAnnotation2 // 필드 
  //@MyAnnotation3  // 메서드
  //@MyAnnotation4  // 로컬
  static int j;

  //@MyAnnotation // 클래스, 인터페이스
  //@MyAnnotation2 // 필드 
  @MyAnnotation3  // 메서드
  //@MyAnnotation4  // 로컬
  public static void main(String[] args) {

    //@MyAnnotation // 클래스, 인터페이스
    //@MyAnnotation2 // 필드 
    //@MyAnnotation3  // 메서드
    @MyAnnotation4  // 로컬
    int local;
    
  }
} // end of class
