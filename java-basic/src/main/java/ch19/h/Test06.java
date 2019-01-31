// lambda 문법 - 람다 문법 - functional interface의 자격
package ch19.h;

public class Test06 {

  // 추상 메서드가 한 개 여야한다
  static interface Player {
    void play();
  }

  static interface Player2 {
    // 인터페이스도 static메서드를 가질 수 있다
    // ==> 특정 인스턴스에 종속되지 않고 작업하는 경우에 static메서드로 정의
    static String info() {
      // 인스턴스 없이 수행하는 작업을 여기에 작성한다
      return "Player2 ...";
    }

    // 인터페이스는 디폴트 메서드를 가질 수 있다
    // ==> 기존 프로젝트에 영향을 끼치지 않으면서 기존 규칙에 새 메서드를 추가할 때 사용한다
    default void stop() {
      // 어차피 새 메서드는 새 프로젝트의 구현체가 오버라이딩할 것이니 여기선 자세하게 구현하지 않음
      // 다만 이 인터페이스를 구현한 예전 프로젝트가 영향 받지 않도록 새로 추가한 메서드를 정의할 뿐이다
    }

    // 인터페이스에 static 메서드나 default 메서드가 여러 개 있더라도
    // 그 메서드들은 이미 구현된 메서드이기 때문에 추상 메서드와 상관없다
    // 따라서 이 인터페이스는 추상 메서드가 한 개이다 즉, 람다 문법을 적용할 수 있다
    void play();
  }

  // 추상 메서드가 2개 이상이면 람다 문법을 적용할 수 없다
  static interface Player3 {
    void play();
    void stop();
  }

  static abstract class Player4 {
    public abstract void play();
  }

  public static void main(String[] args) {

    Player p1 = ()-> System.out.println("Player ...");
    p1.play();

    // static메서드나 default메서드가 몇개이든 중요하지 않음
    // 단 추상메서드가 한 개여야만 한다 그래야 람다문법을 적용할 수 있다
    Player2 p2 = ()-> System.out.println("Player2 ...");
    p2.play();

    // 추상 메서드가 두 개 이상인 경우 람다 문법을 사용할 수 없다
    // Player3 p3 = ()-> System.out.println("Player3 ...");
    
    // 인터페이스가 아닌 추상 클래스는 람다문법을 적용할 수 없다
    // Player4 p4 = ()-> System.out.println("Player4 ...");











  }
}
