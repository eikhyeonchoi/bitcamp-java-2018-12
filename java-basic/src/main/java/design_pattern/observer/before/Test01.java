package design_pattern.observer.before;

public class Test01 {
  public static void main(String[] args) {

    Car car = new Car();
    car.start();
    car.run();
    car.stop();
    
    // Car 클래스를 생성한 후
    // 시동킬 때
    // 1) 자동차가 시동을 걸 때 안전벨트 착용 여부를 검사하는 기능을 추가
    // 2) + 엔진오일 검사 기능 
    // 3) + 브레이크 오일 검사 기능
    
    // 시동끌 때
    // 4) 자동차 전조등을 자동으로 끄는 기능
    // 5) 썬루프 자동 닫기

    // 결론 
    // ==> 기존의 프로그래밍 방식은 특정상태에서 수행하는 기능을 추가할 때
    //     기존 클래스에 계속 코드를 추가해야 했음 risk가 크다
    // ==> 기존 코드에 계속 새 코드를 추가하는 방식은 유지보수에 좋지 않음
    // ==> Observer 패턴을 적용하면 기존 클래스를 손대지 않고 
    //       특정 상태에서 수행하는 작업을 쉽게 추가할 수 있다
    

  }
}
