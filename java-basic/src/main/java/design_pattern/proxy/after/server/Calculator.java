package design_pattern.proxy.after.server;

public interface Calculator{
// 실제 일을 하는 객체와 proxy객체가 공통으로 따라야하는 규칙을 정의한다
  public int plus(int a, int b);
  public int minus(int a, int b);
} // end of class
