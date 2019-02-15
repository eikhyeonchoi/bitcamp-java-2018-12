package design_pattern.proxy.after.server;

// 실제 일을 하는 객체는 interface규칙에 따라 동작하도록 구현되어야 한다
public class CalculatorImpl implements Calculator {
  
  @Override
  public int plus(int a, int b) {
    return a + b;
  } // plus()
  
  @Override
  public int minus(int a, int b) {
    return a - b;
  } // minus()
  
} // end of class
