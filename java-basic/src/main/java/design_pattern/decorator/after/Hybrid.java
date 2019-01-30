package design_pattern.decorator.after;

public class Hybrid extends Decorator {
  public Hybrid(Car car) {
    super(car);
  }

  @Override
  public void run() {
    // 생성자에서 받은 자동차에 덧붙인 전기모터 기능을 실행
    System.out.println("전기모터를켜고 ");
     this.car.run();
  }

}
