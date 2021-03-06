package ch14.f;

public abstract class Car {
  String model;
  int cc;
  
  // 서브 클래스마다 달리는 방식이 다를 경우
  // 굳이 수퍼 클래스에서 정의할 필욘 없다
  // 왜? 서브 클래스에서 오버라이딩할 것이기 때문이다
  // 이럴 경우 메서드를 구현하지 말고 몸체(method body)를 정의
  // 이런 메서드를 "추상 메서드(abstraction method)"라고 부른다
  // 문법
  // ==> 메서드 선언 앞에 abstract 키워드 붙이고 바디없고 세미콜론;
  // 추상 메서드는 몸체가 없기 때문에 호출할 수 없다
  // 따라서 추상메서드를 갖고 있는 클래스는 인스턴스를 생성하지 못하게 해야한다
  // 그래야 인스턴스를 통해 메서드를 호출하지 못한다
  // 그래서 추상 메서드를 갖고 있는 클래스는 인스턴스를 만들지 못하는 추상 클래스가 되어야한다
  // 문법 
  // ==> 클래스 선언 앞에 abstract를 붙이기
  public abstract void run();
  public void stop() {
    System.out.println("멈춘다");
  }

}
