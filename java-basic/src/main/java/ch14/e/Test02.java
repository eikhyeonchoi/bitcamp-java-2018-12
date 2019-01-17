// 다형적 변수의 사
package ch14.e;
public class Test02 {

  public static void main(String[] args) {
    PickupTruck c1 = new PickupTruck();
    SUV c2 = new SUV();
    Convertible c3 = new Convertible();
    DumpTruck c4 = new DumpTruck();
    Car ccc = new DumpTruck();
  }
  // Car 레퍼런스는 Car의 모든 종류(서브클래스)의 인스턴스 주소를 담을 수 있다
  // 이렇게 한 변수가 다양한 타입의 값을 담을 수 있는 것을 다형적 변수라고 한다
  // 다형적 변수를 사용하면 더 유연하게 객체를 다룰 수 있다
  static void test(Car car) {
    System.out.println("----------------");
    car.run(); // car변수가 실제 가리키는 인스턴스의 오버라이딩 메서드
    car.stop(); // Car의 stop()
    car.run();
    car.stop(); // Car의 stop()
    System.out.println("----------------");
  }
}
