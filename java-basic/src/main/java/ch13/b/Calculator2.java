package ch13.b;

import ch13.Calculator;

// 기존 클래스의 기능을 상속 받겠다고 선언한다
// ==> 기존 클래스의 기능을 내 것처럼 사용하겠다고 선언하는 것이다
// ==> 주의!
//     상속이라는 말이 기존 클래스의 코드를 나 몰래 자동으로 복사해오는게 아닌가 하는 오해를 한다
//     아니다 기존 클래스의 코드를 복제해 오지 않고 단지 내 것처럼 사용할 수 있는 권한을 획득하는것
// ==> 문법
//     class 클래스명 extends 기존클래스명 {...}
// 상속을 해주는 클래스를 '수퍼(super) 클래스', '부모(parent) 클래스' 라고 부른다
// 상속을 받는 클래스를 '서브(sub) 클래스', '자식(child) 클래스' 라고 부른다
public class Calculator2 extends Calculator {
  
  // super 클래스 result 필드를 protected로 선언 해야함 == 현업
  public void multiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }
}