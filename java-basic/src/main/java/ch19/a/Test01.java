// 패키지 멤버 클래스의 사용
package ch19.a;

public class Test01 {
  public static void main(String[] args) {
    // A 클래스는 public이라 다른 패키지에서도 접근가능하다
    ch19.a.sub.A obj1 = new ch19.a.sub.A();
    
    // B 클래스는 default이라 다른 패키지에서도 접근불가능하다
    // ch19.a.sub.B obj2 = new ch19.a.sub.B(); compile error 

  }
}
