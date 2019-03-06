// 빌더 패턴 : 여러 개의 객체를 조립해 한 객체를 생성할 때 사용하는 방법
// ==> 복합 객체 처럼 복잡한 객체 생성 과정을 캡슐화(한 클래스에 감춰) 하여
//     유지보수를 쉽다
package design_pattern.builder;

public class Test {
  public static void main(String[] args) {
    try {
      Car c2 = new CarBuilder().build("비트자동차 모델1");
      System.out.println(c2);
      Car c3 = new CarBuilder().build("비트자동차 모델2");
      System.out.println(c3);
      Car c1 = new CarBuilder().build("asasd");
      System.out.println(c1);
    } catch(Exception e) {
      System.out.println(e);
    }

  }
}
