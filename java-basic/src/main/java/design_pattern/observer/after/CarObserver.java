package design_pattern.observer.after;

// 자동차의 상태가 바뀌었을 때 호출할 메서드 규칙을 정의한다
public interface CarObserver {

  // 시동이 걸렸을 때 호출할 메서드 
  // ==> 보통 메서드이름은 동사시작,
  //     옵저버에게 통지할 때 호출하는 메서드는
  //     명사구의 상태 이름으로 정의할 수 있다
  void carStarted();
  
  // 시동 종료시 호출할 메서드
  void carStopped();
  
}
