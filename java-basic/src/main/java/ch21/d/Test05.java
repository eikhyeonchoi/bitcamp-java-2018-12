// 예외 던지기 - Exception 예외 던지기 
package ch21.d;

public class Test05 {
  public static void main(String[] args) {
    // 가능한 main()에서라도 예외를 받아 처리해야 한다
    // JVM에게 그냥 전달하지 말라 그럼 프로그램이 종료된다
    // 예외가 발생하더라도 프로그램을 정상 실행하려면 반드시 main()에서라도 예외를 처리해야한다
    try {
      m3();
    } catch (Exception e) {
      System.out.println(e.toString());
    }
    
    
    System.out.println("end");
  }
  
  static void m3() throws Exception {
    // Exception 예외를 발생시키는 메서드를 호출할 때는
    // 1) try catch로 예외를 처리하거나
    // 2) throws 절을 사용해 어떤 예외가 발생하는지 선언해야함
    
    // 예외가 발생하든 안하든 throws절을 추가하면 메서드를 호출한 쪽에서는 무조건
    // try catch, throws절로 처리 해야 한다
    m2();
  }
  
  static void m2() throws Exception {
    // Exception 예외를 발생시키는 메서드를 호출할 때는
    // 1) try catch로 예외를 처리하거나
    // 2) throws 절을 사용해 어떤 예외가 발생하는지 선언해야함
    m1();
  }
  
  static void m1() throws Exception {
    // Exception 예외를 발생시키는 메서드는
    // 반드시 메서드 선언부에 어떤 예외를 던지는지 throws절을 추가해야한다
    throw new Exception("m1() exception ...");
  }
}
