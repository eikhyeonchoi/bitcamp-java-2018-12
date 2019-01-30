package design_pattern.decorator.before;

public abstract class Car {
  protected int speed;
  
  public abstract void run();
  
  public  void start() {
    System.out.println("Car.start()");
  }
  
  public  void stop() {
    System.out.println("Car.stop()");
  }
}
