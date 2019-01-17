// 상속 관계에서 생성자 호출 과정
package ch13.f;

public class Test02 {
  public static void main(String[] args) {
    Y obj = new Y();
    // 생성자 호출 과정
    // 1) Y() 생성자 호출 => X(int) => Object()
    obj.m1();
    obj.m2();

  }
}
