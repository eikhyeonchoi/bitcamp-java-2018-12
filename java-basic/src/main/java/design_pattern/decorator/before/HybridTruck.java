package design_pattern.decorator.before;

public class HybridTruck extends Hybrid {
  
  public void dump() {
    this.stop();
    System.out.println("HybridTruck.dump()");
    this.run();
  }
}
