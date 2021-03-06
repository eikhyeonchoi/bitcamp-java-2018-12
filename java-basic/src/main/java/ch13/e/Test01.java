// 상속 관계에서 인스턴스 초기화 과정
package ch13.e;

public class Test01 {
  public static void main(String[] args) {
    B obj = new B();
    obj.m1(); 
    
    // :        A.v1        |       B.v2        <= 수퍼 클래스 부터 해당클래스까지 인스턴스필드
    // l:         0         |        0       <= 각 필드를 기본값으로 생성
    // l:       100         |        0       <= A 초기화 문장실행
    // l:       110         |        0       <= A의 인스턴스 블록 실행
    // l:       120         |        0       <= A의 생성자 실행
    // l:       120         |       200      <= B 초기화
    // l:       120         |       210      <= B 인스턴스 블럭
    // l:       120         |       220      <== B생성자
    
    // 수퍼클래스부터 초기화 실행

  }
}
/*
new B()로 B클래스를 호출하면
B클래스의 생성자에 있는 super()가 실행되어 수퍼클래스인 A클래스를 또 호출하게됨
다음 A클래스의 생성자에 있는 super()가 실행되어 Object클래스를 호출하게됨
그 후 Object 클래스의 초기화 => 인스턴스블럭 => 생성자 순으로 실행된 후 
그 서브 클래스인 A클래스의 초기화 => 인스턴스블럭 => 생성자 순으로 실행된 후
마지막 서브 클래스인 B클래스의 초기화 => 인스턴스블럭 => 생성자으로 실행된다
*/