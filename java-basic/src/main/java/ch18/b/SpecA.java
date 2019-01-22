// 인터페이스 정의 - public과 abstract는 생략가능
package ch18.b;

public interface SpecA {

  // 규칙이기에 무조건 public
  // private abstract void m1();
  // protect abstract void m2();
  void m1();
  void m2();
  //abstract void m2(); // 접근제한자가 default가 아니라 무조건 public임
  // void m3(); // public abstract가 생략된 것임
  
}
