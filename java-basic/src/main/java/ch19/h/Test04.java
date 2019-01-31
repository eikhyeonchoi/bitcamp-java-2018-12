// lambda 문법 - 람다 문법 - 파라미터2
package ch19.h;

public class Test04 {

  static interface Player {
    void play(String name, int age);
  }
  public static void main(String[] args) {
    // 파라미터는 괄호()안에 선언한다 
    Player p1 = (String name, int age) -> System.out.printf("%s(%d)\n",name,age);
    p1.play("hong", 21);

    // 파라미터 타입을 생략할 수 있다
    Player p2 = (name, age) -> System.out.printf("%s(%d)\n",name,age);
    p2.play("im", 30);

    // 파라미터가 여러 개일때는 괄호 생략 불가능
    // Player p3 = name, age -> System.out.printf("%s(%d)\n",name,age);
    // p3.play("im", 30);










  }
}
