//l reflection API - 생성자정보
package ch27.b;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import static java.lang.reflect.Modifier.*;
import java.lang.reflect.Constructor;
//l 어떤 클래스나 인터페이스의 스태틱 멤버를 import할 수 있음

public class Test07 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = String.class;
    
    Constructor<?>[] constructors = clazz.getConstructors();
    for(Constructor<?> c : constructors) {
      System.out.printf("%s():\n", c.getName());
      Parameter[] params = c.getParameters();
      for(Parameter p : params) {
        System.out.printf("    %s:%s\n", 
            p.getName(),
            p.getType().getSimpleName());
      }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
  } // main
} // end of class
