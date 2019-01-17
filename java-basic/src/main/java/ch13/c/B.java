package ch13.c;

public class B extends A{
  // 상속이란 수퍼클래스의 사용권을 획득하는 것 
  // 코드를 복제하는게 아님 A.class를 삭제하면 A클래스의 메서드를 사용할 수 없음
  // 이 것이 코드를 복제하는 것이 아니라는 것을 증명할 수 있음
  // 만약 코드를 복제한다면 A.class를 삭제해도 에러가 뜨지 않을 터
  // 그래서 내 것처럼 사용하는 것이다
  public void m2() {
    System.out.println("B.m2()");
  }
}
