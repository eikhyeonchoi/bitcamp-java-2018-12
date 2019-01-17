// 자바는 다중상속을 허락하지 않는다
package ch13.f;

public class Test03 extends A, X{
  public static void main(String[] args) {
    
    Test03 obj = new Test03();
    
    obj.m1(); // 어떤 m1()????
    // A, X클래스 모두 m1()이 있음
    // 그래서 메서드 호출 시 수퍼 클래스들 사이에 같은 이름의 메서드가 여러개 (m1())있을 경우
    // 그 중 어떤 메서드를 호출할 지 결정할 수 없어 다중 상속을 허락하지 않음
    // C++은 다중상속이 가능한데, 창시자가 다중상속이 잘못되었다고 시인함ㅎㅎ

  }
}
