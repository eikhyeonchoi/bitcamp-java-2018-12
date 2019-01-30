package design_pattern.decorator.after;

public abstract class Car {
  protected int speed;
  protected int capacity;
  
  public abstract void run();
  
  public void start() {
    System.out.println("Car.start()");
  }
  
  public void stop() {
    System.out.println("Car.stop()");
  }
}
