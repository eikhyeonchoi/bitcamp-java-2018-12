// 인터페이스 구현 - 새로 추가한 규칙에 따라 클래스를 구현하ㄴ다
package ch18.g;

public class My3 implements B{
  // 원래 B의 추상메서드 구현
  @Override
  public void m1() {
    System.out.println("My2.m1()");
  }
  
  // 나중에 default로 추가한 메서드
  @Override
  public void m2() {
    System.out.println("My2.m2()");
  }
}
