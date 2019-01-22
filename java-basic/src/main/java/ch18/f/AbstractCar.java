package ch18.f;

public abstract class AbstractCar {
  
  String model;
  int cc;
  
  // 추상 클래스의 목적은 서브 클래스에게 공통 필드와 공통 메서드를 상속해주는 것이다
  public void on() {
    System.out.println("on");
  }
  public void off() {
    System.out.println("off");
  }
  
  // 상속해주는 메서드 중에서 일부는 서브 클래스가 구현하도록 강제한다
  // ==> 이럴 때 사용하는 문법이 추상 메서드이다
  public abstract void run();
}
