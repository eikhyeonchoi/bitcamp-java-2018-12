package design_pattern.decorator.after;

public class Truck extends Car {
  int weight;
  
  
  @Override
  public void run() {
    System.out.println("Truck.run()");
  }
  
}
