package design_pattern.decorator.before;

public class Truck extends Car {
  
  @Override
  public void run() {
    System.out.println("Truck.run()");
  }
  
  public void dump() {
    this.stop();
    System.out.println("HybridTruck.dump()");
    this.run();
  }
  
 
}
