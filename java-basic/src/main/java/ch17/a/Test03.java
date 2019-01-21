// 추상 클래스
package ch17.a;

// 추상 메서드가 없더라도 추상 클래스를 선언할 수 있다
abstract class B {
  public void m1() {
    System.out.println("Hello");
  }
}

public class Test03 {
  public static void main(String[] args) {
    // 추상 클래스는 절대 인스턴스 생성 불가
    // B obj = new B();
    // 추상 클래스의 목적
    // ==> 추상 메서드의 유무를 떠나 추상 클래스로 선언할 수 있디
    // ==> 진짜 목적은 서브 클래스에게 공통 필드나 메서드를 상속해주는 것이 목적이다
    // ==> 여러 클래스를 같은 타입을 묶기 위함이다
    // ==> 상속에서 generalization을 통해 수퍼 클래스를 정의하는 경우에 주로 추상 클래스로 만듦
    
    
    
  }
}
