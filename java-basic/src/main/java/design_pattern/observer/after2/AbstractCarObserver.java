package design_pattern.observer.after2;

// CarObserver를 직접 구현하면
// CarObserver에 선언된 모든 메서드를 구현해야한다
// 관심이 없는 메서드도 구현해야 한다
// 이런 불편함을 줄이기 위해 다음과같이 추상클래스를 정의
// 추상클래스에서 CarObserver인터페이스의 메서들ㄹ 모두 구현한다
// 그러면 CarObserver를 직접구현하는 대신에 다음 추상클래스를 상속받아 
// 필요한 메서드만 오버라이딩 하면 되문에 편하다
public abstract class AbstractCarObserver implements CarObserver {
  @Override
  public void carStarted() {
  }

  @Override
  public void carStopped() {
  }

}
