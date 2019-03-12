//l 여러개의 interface 구현한 객체를 자동생성
package ch27.a;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test02 {
  
  public static void main(String[] args) throws Exception {
    
    Object proxy =  Proxy.newProxyInstance(
        Test02.class.getClassLoader(),
        new Class[] {Calculator.class, Calculator2.class, Calculator3.class},
        new InvocationHandler() {
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
              case "multiple":
                return a*b;
              case "divide":
                return a/b;
              case "mod":
                return a%b;
            }
            return 0;
          } // invoke
        });
    
    System.out.println(((Calculator) proxy).plus(10, 20));
    System.out.println(((Calculator) proxy).minus(10, 20));
    System.out.println(((Calculator2) proxy).multiple(10, 20));
    System.out.println(((Calculator2) proxy).divide(10, 20));
    System.out.println(((Calculator3) proxy).mod(10, 20));
    
  } // main
} // end of class
