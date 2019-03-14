//l 애노테이션 반복사용
//l ==> @Repeatable을 이용해 반복 사용 여부를 지정할 수 있음
//l 
//l 
//l 
//l 
//l 
//l 
//l 

package ch28.d;

@MyAnnotation
//@MyAnnotation // 중복사용불가
@MyAnnotation2 // @Repeatable로 선언된 애노테이션인 경우 중복 사용 가능
@MyAnnotation2
@MyAnnotation2
public class Test01 {
  public static void main(String[] args) {
    
    
    
    
  }
} // end of class
