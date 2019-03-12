//l interface 구현체 자동생성
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test01 {
  
  public static void main(String[] args) throws Exception {
    //l java.lang.reflect.proxy
    //l ==> interface 구현체 만드는 역할
    //l newProxyInstance(
    //l     클래스로더,
    //l     구현할 인터페이스 목록,
    //l     실제 작업을 수행하는 객체);
    //l ==> 파라미터로 넘겨 받은 
    
    
    //l 클래스로더?
    //l ==> 클래스 정보 로딩
    //l ==> 알아내는 방법 : 클래스정보.getClassLoader()
    //l ==> 클래스정보? : 인스턴스.getClass(), 클래스명.class
    /*
    String s = "hello";
    Class<?> c1 = String.class; // 3가지 모두 동일 - 클래스의 static 변수로 알아내기
    Class<?> c2 = s.getClass(); // 3가지 모두 동일 - 인스턴스로 알아내기
    Class<?> c3 = Class.forName("java.lang.String"); // 3가지 모두 동일 - 도구 이용
    */
    
    //l 실제 작업을 수행하는 객체?
    //l ==> InvocationHandler 인터페이스에 따라 동작하는 객체
    //l ==> 즉, InvocationHandler 구현체이다
    class MyHandler implements InvocationHandler {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //l newProxyInstance가 생성한 객체에 대해 메서드를 호출할 때마다 이 메서드가 호출됨
        int a = (int) args[0]; // auto-unboxing => ((Integer)args[0]).intValue();
        int b = (int) args[1];
        switch (method.getName()) {
          case "plus":
            return a+b;
          case "minus":
            return a-b;
        }
        return 0;
      } // invoke()
    } // Myhandler
    
    // Calculator 인터페이스를 구현한 클래스를 만들고 그 인스턴스를 생성해 return
    Calculator c1 = (Calculator) Proxy.newProxyInstance(
        Calculator.class.getClassLoader(),
        new Class[] {Calculator.class},
        new MyHandler());
    
    System.out.println(c1.plus(10, 20));
    System.out.println(c1.minus(10, 20));
    
  } // main
} // end of class
