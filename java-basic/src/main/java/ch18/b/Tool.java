// 인터페이스 구현 - 접근 범위를 좁힐 수 없다
package ch18.b;

public class Tool implements SpecA{

  // 오버라이드한 메서드는 무조건 public 범위를 좁힐 수 없음
  // ==> protected, default, private 불가능!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
  // private void m1() {}; 오류
  // protected void m1() {}; 오류
  // void m1() {}; 오류
  
  @Override
  public void m1() {
  }
  // 모든 추상 메서드를 구현해야한다 한 개라도 빠지면 concrete 클래스로 만들 수 없다
  // ==> 추상 클래스로 만들어야 한다 왜?? 추상 메서드 있으니까

  @Override
  public void m2() {
    // TODO Auto-generated method stub
    
  }
  
  

}
