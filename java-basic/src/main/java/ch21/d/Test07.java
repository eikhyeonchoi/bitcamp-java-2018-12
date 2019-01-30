// 예외 던지기 - RuntimeException 예외 던지기 
package ch21.d;

public class Test07 {
  public static void main(String[] args) {
    // RuntimeException도 Exception과 마찬가지로
    // 정상적인 프로그램 종료를 위해 main()에서는 예외를 처리해야한다
    // try ~ catch를 사용하지 않아도 된다는 것이 예외를 자동으로 처리하는 것이 아님
    // 진짜 마지막에라도 RuntimeException도 최후로 main()에서는 예외처리를 해서 
    // 프로그램이 정상적으로 종료되게 해야함
    
    // RuntimeException예외는 메서드 선언부에 throws절을 붙이지 않아도 되기 때문에
    // 스텔스처럼 조용히 전달된다, 코딩하기 편함, 그래서 대부분의 라이브러리, 프레임워크에선
    // 개발자가 예외처리를 위해 throws절을 사용하는 번거로움을 덜고자 내부에서 발생하는
    // 예외를 보통 RuntimeException에 담아 던진다
    // ==> 개발자에게 적절한 위치에서 처리하라고 선택권을 주는 셈이다
    try {
      m3();
    }catch (Exception e) {
      System.out.println(e.toString());
    }
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
