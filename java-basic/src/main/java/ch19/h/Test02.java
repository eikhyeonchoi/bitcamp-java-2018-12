// lambda 문법 - 람다 문법 - 바디
package ch19.h;

public class Test02 {
  
  // 다음과 같이 추상메서드가 한 개 있는 인터페이스를 functional interface라고 부른다
  // 이런 경우 lambda문법을 사용할 수 있다
  static interface Player {
    void play();
  }
  public static void main(String[] args) {
    // 메서드가 한 문장인 경우 중괄호 생략 가능 
    Player p1 = () -> {System.out.println("테스트2");};
    Player p2 = () -> System.out.println("테스트2");
    
    
    
    
    
    
    
    
    
    
    
  }
}
