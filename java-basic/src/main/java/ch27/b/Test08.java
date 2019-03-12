//l reflection API - 클래스가 구현한 인터페이스 알아내기
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import static java.lang.reflect.Modifier.*;
import java.lang.reflect.Constructor;
//l 어떤 클래스나 인터페이스의 스태틱 멤버를 import할 수 있음

public class Test08 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;
    
    Class<?>[] interfaces = clazz.getInterfaces();
    for(Class<?> c : interfaces) {
      System.out.println(c);
    }
    
    
    
    
  } // main
} // end of class
