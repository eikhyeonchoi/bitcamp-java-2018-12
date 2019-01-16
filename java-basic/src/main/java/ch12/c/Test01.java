package ch12.c;

public class Test01 {
  public static void main(String[] args) {
    My obj1 = new My();
    
    // private 접근불가
    // obj1.v1 = 100; compile error
    
    // default
    obj1.v2 = 100; // My클래스와 Test01클래스는 같은 패키지소속
    // protected
    obj1.v3 = 100; // My클래스와 Test01클래스는 같은 패키지소속
    // public
    obj1.v4 = 100; // 완전공개
    
    
    
    
  }
}
