//l reflection API - 메서드의 상세정보 꺼내기 2
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import static java.lang.reflect.Modifier.*;
//l 어떤 클래스나 인터페이스의 스태틱 멤버를 import할 수 있음

public class Test06 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = C.class;
    
    
    //l 수퍼클래스 상속메서드 + public
    Method[] methods = clazz.getMethods();
    //l 메서드가 실제 정의된 클래스의 이름 출력하기
    for(Method m : methods) {
      System.out.printf("클래스명 : %s\n",
          m.getDeclaringClass().getSimpleName());
      System.out.printf("  ==> %s\n",m.getName());

      System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
    }



  } // main
} // end of class
