// 상속 : generalization 수행 후
package ch13.i;

// Car클래스는 Convertible과 DumpTruck에 공통으로 있는 일반 기능을
// 뽑아서 만들 클래스이다 
// ==> 이렇게 서브클래스의 공통 기능을 추출해 수퍼클래스를 정의하는것을
// ==> generalization이라고 한다
// ==> 수퍼 클래스를 정의한 후 기존클래스와 수퍼-서브 관계를 맺는다
public class Car {
  String model;
  int cc;
  public void run() {
    System.out.println("Car.run() 달린다");
  }
  public void stop() {
    System.out.println("Car.stop() 멈춘다");
  }

}
