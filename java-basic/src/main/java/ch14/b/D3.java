// this, super 키워드를 사용해 메서드를 호출할 때
package ch14.b;

public class D3 extends D2 {

  @Override
  void m1() {
    System.out.println("D3.m1()");
  }
  @Override
  void m3() {
    System.out.println("D3.m3()");
  }
  
  void test() {
    this.m4();
    super.m4();
    
    this.m3();
    super.m3();
    
    this.m1();
    super.m1();
    
    this.m2();
    super.m2();
  }
  // this ==> 현재 클래스 부터 해당메서드 찾기
  // super ==> 수퍼 클래스 부터 해당메서드 찾기
  
  public static void main(String[] args) {
    D3 obj = new D3();
    obj.test();
  }
}
