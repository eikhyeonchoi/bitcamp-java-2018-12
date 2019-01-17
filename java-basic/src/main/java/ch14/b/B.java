// 오버라이딩 규칙
package ch14.b;

public class B extends A{
  
  // 오버라이딩 규칙
  // ==> 메서드 시그너처를 똑같게 해야한다
  // @Override void m1(int xx) {} // ok 파라미터의 이름은 상관없음
  
  // @Override int m1() {int a}
  // compile error ==> return 타입이 다르면 error
  
  // @Override void m1(long a) {} 
  // compile error ==> 파라미터의 타입이 달라도 안됨
  
  // @Override void m1(int a, int b) {} 
  // compile error ==> 파라미터의 갯수가 달라도 안됨
  
  // @Override private void m1(int b) {}
  // compile error => 접근 범위를 축소하는 것은 안됨, 확장하는 것은 가능!!!!!!!!!!!!!!!!!!!
  // private -> default -> protected -> public
  
  // @Override void m2(String a, int b) {}
  // compile error => 접근 범위를 축소하는 것은 안됨
  
  @Override public void m1(int b) {}
  @Override public void m2(String a, int b) {}
  // ok ==> 접근 범위 확대하는 것은 가능
  
  
  
  
  

}
