// 인터페이스 구현
package ch18.g;

public class My2 implements B{
  // B의 추상메서드 구현
  @Override
  public void m1() {
    System.out.println("My2.m1()");
  }
}
