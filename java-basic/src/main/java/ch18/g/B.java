// 디폴트 메서드 - 기존 코드에 영향을 미치지 않고 새 규칙을 추가하는 방법
package ch18.g;

public interface B {
  // 다음 메서드는 이 인터페이스를 구현하는 모든 클래스가 반드시 정의 해야함
  void m1();
  
  // 새 메서드가 필요하면 ?
  // ==> 기존 규칙에 새 메서드를 넣으면 그 규칙에 따라 작성했던 My1, My2 클래스에도 
  //     새 메서드를 추가해야한다
  //     기존 My1, My2를 사용하는 사람은 새 메서드가 필요 없다면 ??
  // ==> 이런 상황일 때 예전에는 B인터페이스를 상속 받아 새 메서드를 추가한 서브 인터페이스를 만듦
  //     문제는 새 인터페이스를 만들게되면 기존 코드도 변경해야 하는 번거로움이 있다
  //     이 문제를 해결하기 위해 등장한 문법이 "디폴트 메서드"이다
  //     즉 인터페이스도 구현 메서드를 가질 수 있다
  
  // 다음과 같이 새 추상메서드를 추가하면 기존 My1, My2클래스에서 오류 발생
  // void m2(); 그래서 디폴트 메서드를 만들라
  // ==> 구현된 메서드이기 때문에 B를 구현한 이전 My1과 My2는 영향을 받지 않음
  //     이것이 디폴트 메서드의 목적
  // ==> 물론 구현 메서드에 간단한 코드를 작성할 수 있지만
  //     클래스처럼 뭔가 진짜 일을 하는 코드를 작성해서는 안된다
  default void m2() {}
  
}
