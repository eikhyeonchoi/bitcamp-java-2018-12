// 상속의 실제적의미
package ch13.d;

public class Test01 {
  public static void main(String[] args) {
    B obj = new B();
    // B 클래스의 인스턴스 생성 과정
    // 1) B의 수퍼 클래스(A class)를 로딩한다(로딩되어 있지 않다면)
    //     스태틱 필드 생성 => 스태틱 블럭 실행
    // 2) B 클래스 로딩(로딩되어 있지 않다면)
    //     스태틱 필드 생성 => 스태틱 블럭 실행
    // 3) 인스턴스 필드 생성
    //    수퍼 클래스의 인스턴스 필드부터 생성
    //   A의 v1필드 생성 => B의 v2필드 생성
    //          v1       |        v2        ==> 각 필드를 기본 값으로 설정
    //             0         |         0        ==> 각 필드를 기본 값으로 설정
    //         100       |        0      ==> A 클래스의 초기화 문장 실행
    //         100       |       200      ==> B 클래스의 초기화 문장 실행
    
    // ==> B클래스의 인스턴스는 수퍼 클래스의 인스턴스 필드도 포함한다
    
    
    // A클래스의 m1()을 호출하면서 B인스턴스의 주소를 넘겨준다
    // 메서드 호출 과정
    // B클래스에서 m1() 찾고 없으면 => A클래스에서 m1() 찾음
    // 메서드를 호출할 때마다 수퍼 클래스를 따라 올라 가면서 찾기 때문에
    // 그래서 객체지향프로그래밍이 c와 같은 언어 보다 속도가 느리다는 것
    obj.m1(); 
    obj.m2();

  }
}
