// 
package ch14.f;

public class Test01 {
  public static void main(String[] args) {
    // 레퍼런스 변수 선언
    // ==> 어떤 타입의 레퍼런스가 있다면, 그 타입의 인스턴스 주소를 담을 수 있다는것
    // ==> 또한 그 타입의 서브클래스의 인스턴스의 주소도 담을 수 있다
    A obj;
    
    obj = new A();
    obj.m1(); // A.m1()
    
    // 서브 클래스(타입)의 인스턴스 주소 저장
    obj = new B();
    // obj.m2(); // compile error
                // 컴파일러는 레퍼런스의 타입으로만 사용할 수 있는 멤버인지 확인한다
                // 실제 그 레퍼런스에 저장된 인스턴스가 어떤 타입인지는 따지지 않는다
    obj.m1(); // B.m1()
                // JVM은 메서드를 호출할 때 레퍼런스에 저장된 인스턴스의 타입에서
                  // 먼저 메서드를 찾는다
                  // 따라서 오버라이딩 메서드가 있다면 그 메서드가 호출됨
    

  }
}
