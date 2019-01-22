// 인터페이스의 필드
package ch18.g;

public interface A {
  // 인터페이스에 선언하는 모든 필드는 public static final이다
  // 무조건 상수이다
  public static final int V1 = 100;
  int V2 = 200;
  // public static final을 생략할 수있다
  // 적지 않아도 무조건 public static final 
  // 메서드는 public abstract 생략...
}
