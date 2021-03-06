// 중첩 클래스 종류 - nested class
package ch19.a;

// 익명 클래스 에제
class Car {
  String model;
  
  public Car() {
    this.model = "미정";
  }
  
  public Car(String model) {
    this.model = model;
  }
  
  public void run() {
    System.out.println("Car.run()");
  }
}

// 익명 클래스 에제
interface Pen {
  void write();
}

public class Test02 {
  
  // 중첩 클래스
  // ==> 특정 클래스 안에서만 사용되는 클래스가 있다면 중첩 클래스로 선언하라
  // ==> 즉 노출 범위를 좁히는 것이 유지보수에 좋다
  // 1) static nested class;
  // ==> 바깥 클래스의 특정 인스턴스에 종속되지 않는 클래스
  static class A{}
  
  // 2) non-static nested class = inner class
  // ==> 바깥 클래스의 특정 인스턴스에 종속되는 클래스
  class B{}
  
  public static void main(String[] args) {
    // 3) local class
    // ==> 특정 메서드 안에서만 사용되는 클래스
    class C{}
    
    // 4) anonymous class
    // ==> 클래스의 이름이 없다
    // ==> 클래스를 정의하는 동시에 인스턴스를 생성해야 하다
    // ==> 단 한 개의 인스턴스만 생성해서 사용할 경우 익명 클래스를 적용
    // ==> 클래스 이름이 없기 때문에 생성자를 정의할 수 없다
    // ==> 만약 인스턴스의 값을 초기화시키기 위해 복잡한 코드를 작성해야 한다면
    // ==> 인스턴스 블록에 작성하라
    // ==> 문법 
    //     new 수퍼클래스() {클래스정의};
    //     new 인터페이스() {클래스정의};
    
    // ex 1)
    // Car클래스를 상속 받아 익명클래스를 정의한다
    // 인스턴스를 생성할 때 수퍼 클래스인 Car의 기본 생성자를 호출한다
    Car obj = new Car() {
      @Override
      public void run() {
        System.out.println(this.model + "anonymous1 class.run()");
      }
    }; // new 명령은 인스턴스를 생성하는 명령이기 때문에 세미콜론을 붙여야한다
    obj.run();
    
    // ex 2)
    // 클래스 이름 다음에 오는 것이 수퍼 클래스의 생성자를 지정하는 문법이다
    // 수퍼 클래스의 기본 생성자 말고 다른 생성자 호출
    Car obj2 = new Car("티코") {
      @Override
      public void run() {
        System.out.println(this.model + "anonymous2 class.run()");
      }
    };
    obj2.run();

    // ex 3)
    // ==> 인터페이스를 구현해 익명 클래스 만들기
    // ==> 인터페이스를 지정하면 수퍼 클래스는 자동으로 Object가 된다
    // ==> 그러면 호출할 생성자도 Object 클래스의 생성자이어야한다
    Pen obj3 = new Pen() {
      // 인터페이스에는 생성자가 없기 때문에 수퍼 클래스는 Object class
      @Override
      public void write() {
        System.out.println("anonymous class.write()");
        
      }
    };
    obj3.write();
    
  }
  public static void m1() {
    // 스태틱 멤버는 스태틱 멤버만 사용가능
    // 스태틱 멤버는 인스턴스 주소를 담는 this라는 built-in 변수가 없기 때문에
    // 인스턴스 멤버(필드, 메서드, inner클래스)를 사용할 수 없다
    A obj = new A();
    B obj2; // 레퍼런스는 선언가능
    //obj2 = new B(); 
    
    // 다른 로컬 멤버(변수, 중첩 클래스) 사용할 수 없음
    // C class는 메인에서만 사용가능 메인안에 있기 때문
    // C obj3;
    // obj3 = new C();
    
  }
}
