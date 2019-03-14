//l 애노테이션 프로퍼티
//l ==> 메스더 선언하는 문법과 비슷
//l ==> 기본 값을 지정하지 않으면 필수입력
//l ==> value라는 이름을 갖는 프로퍼티 일 경우
//l     값을 지정할 때 이름 생략 가능
//l 
//l 
//l 
//l 
//l 

package ch28.e;

//@MyAnnotation // 필수 프포퍼티가 있는 경우 반드시 값을 지정해야함
public class Test01 {
  public static void main(String[] args) {
    
    @MyAnnotation(value = "okok")
    int a;
    
    @MyAnnotation("okok")
    int b;
    
    @MyAnnotation2(value2 = "okok")
    int c;
    
    //@MyAnnotation2("okok") // 프로퍼티 이름이 value2라서 생략 불가능함
    int d;
    
    @MyAnnotation3("okok")
    int e;
    
    @MyAnnotation3() // 프로퍼티 값 입력이 선택 항목인 경우 값 설정 생략가능
    int f;
    
    @MyAnnotation3 // 프로퍼티 값을 지정하지 않으면 괄호 생략 가능
    int g;
    
    
  }
} // end of class
