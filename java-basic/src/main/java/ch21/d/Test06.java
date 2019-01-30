// 예외 던지기 - RuntimeException 예외 던지기 
package ch21.d;

public class Test06 {
  public static void main(String[] args) {
    // main()에서 RuntimeException을 처리 하지 않으면 예외가 JVM에게 전달되어 프로그램을 종료함
    // RuntimeException은 Exception에 비해 다루기 편리함 
    // 각 메서드마다 throws 절을 추가 안해도됨
    m3();
    System.out.println("end");
  }

  static void m3() {
    // Exception 예외를 발생시키는 메서드는
    // throws 절을 추가 안해도 됨 + try~catch로 처리 안해도 오류안뜸 
    m2();
  }

  static void m2() {
    // Exception 예외를 발생시키는 메서드는
    // throws 절을 추가 안해도 됨 + try~catch로 처리 안해도 오류안뜸 
    m1();
  }

  static void m1() {
    // Exception 예외를 발생시키는 메서드는
    // throws 절을 추가 안해도 됨
    throw new RuntimeException("m1() exception ...");
  }
}
