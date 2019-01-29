// 예외 던지기 - 예외를 보고하지 않는경우 
package ch21.d;

import java.util.ArrayList;

public class Test03 {
  static ArrayList<String> list = new ArrayList<String>();

  public static void main(String[] args) {
    addName("홍길동");
    addName("임꺽정");
    addName("유관순");
    addName(null);
    addName(null);

    for (int i = 0; i <= list.size(); i++) {
      try {
        // throw 명령으로 전달된 예외 정보는 catch 블록을 통해 별개의 경로로 받을 수 있다
        // 따라서 예전 처럼 리턴 값으로 받을 때의 문제점이 없다
        String name = getName(i);
        System.out.println(getName(i));
      } catch (Exception e) {
        System.out.println("list.get Exception ...");
      }
    }

    System.out.printf("입력된 이름 갯수는 %d 입니다\n", list.size());



    try {
      int result = divide(191919, 0);
      System.out.println(result);
    } catch (Exception e) {
      System.out.println("divide Exception ...");
    } 



  }

  static void addName(String name) {
    list.add(name);
  }

  // 1) 예외 상황을 보고하지 않는 경우
  // ==> 보통 예외 상황을 리턴 값으로 알린다
  static String getName(int index) throws Exception {
    if (index < 0 || index >= list.size())
      throw new Exception();
    // throw new Object(); compile error
    // throw 명령으로 던질 수 있는 예외는 Throwable타입 이어야함
    // 다른 타입의 객체는 던질 수 없다
    // 어플리케이션에서 발생하는 예외는 가능한 java.lang.Exception을 사용하라
    // java.lang.Error 클래스는 JVM에서 발생하는 시스템 예외를 위한 클래스 사용하지마라
    // 그리고 Throwable 클래스의 객체로 가능한 사용하지 말라
    // return null;
    return list.get(index);
  }

  static int divide(int a, int b) throws Exception {
    if(b==0) {
      throw new Exception();
    }
    return a / b;
  }
}
