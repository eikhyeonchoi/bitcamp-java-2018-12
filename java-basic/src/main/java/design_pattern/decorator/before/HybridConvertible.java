package design_pattern.decorator.before;

public class HybridConvertible extends Hybrid {

  // Hybrid를 상속받았기 때문에 Hybrid기능은 그대로 사용한다
  // 문제는 Convertible기능을 갖기 위해
  // Convertible 기능을 중복해서 작성해야 한다
  // ==> 코드 중복은 항상 문제가 된다
  boolean openRoof;

  public void open(boolean open) {
    this.openRoof = open;
  }

  public void run2() {
    if(openRoof == true)
      System.out.println("open Roof");
    else System.out.println("close Roof");
    this.run();
  }
}
