package design_pattern.decorator.before;

public class Convertible extends Sedan {
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
