package ch13;

public class Calculator {

  // sub class가 접근할 수 있도록...
  protected int result;

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