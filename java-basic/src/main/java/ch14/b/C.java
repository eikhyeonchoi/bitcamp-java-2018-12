// super 키워드
package ch14.b;

public class C extends A{
  @Override public void m1(int a) {
  // 오버라디이 전의 메서드를 호출하고 싶다면 super레퍼런스를 사용
    super.m1(a);
  }
  
  public void m4() {
    this.m1(100);
    this.m2("okok", 100);
    super.m2("haha", 100);
  }
  
  public static void main(String[] args) {
    C c = new C();
    c.m4();
  }
  
}
