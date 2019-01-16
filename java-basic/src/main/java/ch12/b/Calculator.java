package ch12.b;

public class Calculator {

  // 외부에서 접근을 막아야 하는 멤버에 대해서는 private modifier을 붙인다
  // modifier(변경자, 한정자, 제한자)? 원래의 특성을 변경한다
  // ==> 원래특성 : private을 붙이지 않으면 같은 패키지의 클래스는 접근하는 것을 허용
  // ==> 특성변경 : private를 붙이면 오직 같은 클래스의 멤버만이 접근할 수 있다
  private int result;

  // result 필드의 접근을 제한했기 때문에
  // result 필드의 값을 리턴해주는 메서드가 필요하다
  // ==> 보통 필드의 값을 리턴하는 메서드의 이름을 getXxxx라고 짓는다
  // ==> 그래서 이런 메서드를 "getter"라고 부른다
  public int getResult() {
    return this.result;
  }

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }
  
}