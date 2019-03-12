//l reflection API - 클래스가 갖고 있는 메서드 정보 알아내기
//l ==> 클래스 안을 들여다 볼 떄 사용하는 도구
package ch27.b;

import java.lang.reflect.Method;

public class Test03 {

  public static void main(String[] args) throws Exception {
    
    Class<?> clazz = C.class;
    
    //l getMethods()
    //l ==> public 메서드만 return
    //l ==> 수퍼 클래스의 메서드도 return 
    Method[] methods = clazz.getMethods();
    for(Method m : methods) {
      System.out.println(m.getName());
    }
    
    System.out.println("----------------------------------");
    
    //l getDeclaredMethods()
    //l ==> 모든 접근지정자 메서드 return
    //l ==> 현재 클래스의 메서드만 return 
    methods = clazz.getDeclaredMethods();
    for(Method m : methods) {
      System.out.println(m.getName());
    }
    
    
    
    
    
  }
}
