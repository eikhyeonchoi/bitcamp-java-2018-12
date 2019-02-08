package design_pattern.observer.after;
import java.util.HashSet;

public class Car {

  // 옵저버 목록을 저장할 집합객체 준비
  // ==> 같은 옵저버가 중복 등록되지 않도록 한다
  // ==> 등록 순서에 따라 통지할 필요 x
  HashSet<CarObserver> observers = new HashSet<CarObserver>();

  // 옵저버를 관리하는 메서드 추가
  public void addObserver(CarObserver observer) {
    observers.add(observer);
  }

  public void removeObserver(CarObserver observer) {
    observers.remove(observer);
  }

  public void notifyObserverOnStarted() {
    for (CarObserver observer : observers) {
      observer.carStarted();
    }
  }
  
  public void notifyObserverOnStopped() {
    for (CarObserver observer : observers) {
      observer.carStopped();
    }
  }
  
  public void start() {
    System.out.println("시동을건다");
//    addObserver(new SafeBeltCarObserver());
//    addObserver(new EngineOilCarObserver());
//    addObserver(new BreakOilCarObserver());
    notifyObserverOnStarted();
    // 자동차가 시동을 걸 때 안전벨트 착용 여부를 검사하는 기능을 추가
    // + 엔진오일 검사 기능 추가
    // + 브레이크오일 검사 기능 추가
  }
  
  public void run() {
    System.out.println("달린다");
  }
  
  public void stop() {
    System.out.println("시동을끈다");
//    addObserver(new LightOffCarObserver());
//    addObserver(new SunRoofCloseCarObserver());
    notifyObserverOnStopped();
    // + 전조등 자동 off기능 추가
    // + 썬루프 자동 close기능 추가
  }
  
  
  
}
