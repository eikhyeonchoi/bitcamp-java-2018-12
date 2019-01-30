// 예외 던지기 - Exception 예외 던지기 
package ch21.d;

public class Test04 {
  public static void main(String[] args) throws Exception {
    // main()에서 조차 예외를 처리하지 않는다면 JVM에게 보고해야 한다
    // 물론 JVM은 예외를 보고받자 마자 즉시 예외 정보를 상세하게 출력한 다음 종료할 것이다
    
    m3();
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
