package ch12.c.other;

import ch12.c.My;
public class Test02 {
  public static void main(String[] args) {
    My obj1 = new My();
    
    // private 접근불가
    // obj1.v1 = 100; compile error
    
    // default
    // obj1.v2 = 100; // 패키지 다름
    // protected
    // obj1.v3 = 100; // 패키지 다름 
    // public
    obj1.v4 = 100; // 완전공개
    
    
    
    
  }
}
