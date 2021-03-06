package design_pattern.observer.before;

public class Car {
  
  public void start() {
    System.out.println("시동을건다");
    
    // 자동차가 시동을 걸 때 안전벨트 착용 여부를 검사하는 기능을 추가
    System.out.println("안전벨트 착용 여부 검사");
    
    // + 엔진오일 검사 기능 추가
    System.out.println("엔진오일 유무 검사");
    
    // + 브레이크오일 검사 기능 추가
    System.out.println("브레이크오일 유무 검사");
  }
  
  public void run() {
    System.out.println("달린다");
  }
  
  public void stop() {
    System.out.println("시동을끈다");
    
    // + 전조등 자동 off기능 추가
    System.out.println("전조등을 끈다");
    
    // + 썬루프 자동 close기능 추가
    System.out.println("썬루프를 닫는다");
  }
}
