package ch13.a;
// 기존의 클래스 기능 추가 Calculator
// 방법 1) 복붙
public class Calculator2 {
  // Calculator에 곱하기 나누기 기능을 추가하려면
  // 기존 코드의 기능을 고대로 복사
  private int result;

  public int getResult() {
    return this.result;
  }

  public void plus(int value) {
    this.result += value;
  }

  public void minus(int value) {
    this.result -= value;
  }
  // 기능을 추가한다
  
  public void multiple(int value) {
    this.result *= value;
  }
  
  public void divide(int value) {
    this.result /= value;
  }
}
