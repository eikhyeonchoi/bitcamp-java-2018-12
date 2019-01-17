// 오버로딩 규칙
package ch14.d;

public class A {
  // 메서드를 찾을 때 이름과 파라미터 타입, 갯수로 구분 하기 때문에
  // return type 이 다른 것은 구분할 수 없다
  public void m1() {}
  // public int m1() {return 0;} ==> compile error
 
  // ==> return 타입이 같아야 오버로딩임
  public void m1(int a) {}
  // 파라미터 이름으로는 메서드 구분 x
  // public void m1(int a) {}
  
  // ==> 파라미터 타입이 달라야한다
  public void m1(float a) {}
  public void m1(float a, float b) {}
  public void m1(byte a) {}
  public void m1(byte a, byte b) {}
  public void m1(short a) {}
  public void m1(short a, short b) {}
  public void m1(long a) {}
  public void m1(long a, long b) {}
  // ==> 파라미터 개수가 달라야한다
  public void m1(int a, int b) {}
  private void m1(int a, int b, int c) {}
  protected void m1(int a, int b, float c) {}
  public void m1(byte a, int b, float c) {}
  // ==> 접근 범위는 상관 없다
  
  
  
  
  
  
  
  
  
}
