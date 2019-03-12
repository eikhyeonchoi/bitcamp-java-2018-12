//l reflection API - 특정 메서드만 조회
package ch27.b;

import java.lang.reflect.Method;

public class Test04 {

  public static void main(String[] args) throws Exception {

    Class<?> clazz = C.class;

    //l 메서드명과 파라미터 타입으로 메서드 정보를 알아낼 수 있다
    //l primitive type 정보를 꺼낼 때는 타입명.class를 사용하면 된다
    //l 즉 primitive type이 클래스가 아니지만 타입 정보를 꺼낼 떄 class정보를 사용할 수 있음
    Method m = clazz.getMethod("plus", int.class, int.class);
    System.out.println(m.getName());

    //l 메서드의 파라미터가 없을경우 안적으면댐
    m = clazz.getMethod("c_public");
    System.out.println(m.getName());

  } // main
} // end of class
