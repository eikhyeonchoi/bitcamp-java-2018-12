// lambda 문법 - 람다 문법 - 파라미터
package ch19.h;

public class Test03 {
  
  static interface Player {
    void play(String name);
  }
  public static void main(String[] args) {
    // 파라미터는 괄호()안에 선언한다 
    Player p1 = (String name) -> System.out.println(name + " welcome");
    p1.play("hong");
    
    // 파라미터 타입을 생략할 수 있다
    Player p2 = (name) -> System.out.println(name + " welcome");
    p2.play("hong");
    
    // 파라미터가 한 개일때는 괄호도 생략가능
    Player p3 = name -> System.out.println(name + " welcome");
    p3.play("hong");
    
    
    
    
    
    
  }
}
