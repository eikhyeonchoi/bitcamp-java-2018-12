// 인터페이스 구현 - 접근 범위를 좁힐 수 없다
package ch18.b;

public abstract class Tool2 implements SpecA{

  @Override
  public void m1() {
  }
  // 모든 추상 메서드를 구현해야한다 한 개라도 빠지면 concrete 클래스로 만들 수 없다
  // ==> 추상 클래스로 만들어야 한다 왜?? 추상 메서드 있으니까
  // ==> 추상메서드 m2()를 구현 안해서 추상 클래스로 선언해줘야함
  
  

}
