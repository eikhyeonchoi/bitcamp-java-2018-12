package ch12.c.other;

import ch12.c.My;

public class My2 extends My {
  
  
  public void m1() {
    My obj1 = new My();
    // obj1.v1 = 100; compile error // private
    // obj1.v2 = 100; compile error // default
    
     // obj1.v3 = 100; // protected 
     // obj1이 가리키는 v3이다. 자기가 상속받은게 아님 
     
     obj1.v4 = 100; // public ok
     
     // My2가 상속받은 필드
     // this.v1 = 100; 상속받은 필드라도 private 접근 불가
     // this.v2 = 100; 상속받은 필드라도 패키지가 다르면 접근 불가 default
     this.v3 = 100; // 상속받은 필드의 경우 서브클래스에서 접근가능
     this.v4 = 100; // public
  }
 
  
}
