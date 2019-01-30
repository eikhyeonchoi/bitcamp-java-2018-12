// 예외 던지기 - RuntimeException 예외 던지기 
package ch21.d;

public class Test08 {
  public static void main(String[] args) {
    try {
      m3();
    }catch (Exception e) {
      System.out.println(e.toString());
    }
    System.out.println("end");
  }

  static void m3() {
    m2();
  }

  static void m2() {
    m1();
  }

  static void m1() throws RuntimeException {
    // RuntimeException 예외가 최초로 발생되는 메서드를 만들 때는
    // 가능한 메서드 선언부의 throws절에 어떤 예외가 발생하는지 적어라
    // 오ㅐ? 다른 개발자강 알아볼 수 있도록,, 안적어도 오류 안나긴하는데 최초 발생 메서드에선 적어
    throw new RuntimeException("m1() exception ...");
  }
  
  
  
  
}
