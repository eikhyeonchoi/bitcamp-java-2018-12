package design_pattern.decorator.before;

public class Hybrid extends Sedan {
  
  @Override
  public void run() {
    if (this.speed <= 60) System.out.println("Hybrid.run() motor");
    System.out.println("Hybrid.run()");
  }
  
}
