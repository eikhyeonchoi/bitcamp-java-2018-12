// Wrapper 클래스와 오토박싱(auto-boxing)/오토언박싱(auto-unboxing)
package ch11;

import java.util.Date;
import java.util.Scanner;

public class Test10 {
  public static void main(String[] args) {
    
    // primitive type의 값을 인스턴스에 담고 ( boxing 이라고 부름)
    // 인스턴스에 담긴 primitive 값을 다시 꺼내는 작업이 매우 불편하다(unboxing 이라고 부름)
    // 그래서 자바는 박싱과 언박싱을 코드 문맥에 따라 자동으로 수행한다
    
    Integer obj1 = Integer.valueOf(100); // 박싱
    Integer obj2 = 100; // 오토 박싱, 내부적으로 Integer.valueOf(200); 수행
    // obj1, obj2는 레퍼런스임 primitive type이 아니다 주소가 return
    
    int i1 = obj1.intValue(); // 언박싱
    int i2 = obj1; // 오토언박싱, 내부적으로 obj1.intValue()를 호출
    
    System.out.println(obj1 == obj2); // heap에 저장되긴 하지만 상수풀 처럼 하나만 만듬
    if(obj1.equals(obj2)) {
      System.out.println("obj1 == obj2");
    } // wrapper 클래스도 equals() 메서드를 오버라이드 한것 ( +String class의 equals()도)
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
