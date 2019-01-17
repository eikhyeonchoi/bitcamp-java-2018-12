package ch13.c;

public class Test01 {
  public static void main(String[] args) {
    B obj = new B();
    
    // B 인스턴스를 이용하여 B 사용권을 획득한 A클래스의 메서드를 호출할 수 있다
    obj.m1();
    obj.m2();
    
    // A.class를 지우고 실행...
    // 상속 받는다는 것은 수퍼 클래스의 코드를 그대로 복제해 온다는 것이 아니다
    // 그냥 수퍼 클래스의 코드를 사용할 수 있는 권한을 획득한다는 것이다
    // 그래서 서브 클래스를 사용하려면 반드시 서브 클래스가 상속받는 
    // 모든 조상 클래스가 있어야 한다
    
  }
}
