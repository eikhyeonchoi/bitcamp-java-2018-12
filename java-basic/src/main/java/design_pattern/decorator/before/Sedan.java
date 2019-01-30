package design_pattern.decorator.before;

public class Sedan extends Car {
  
  @Override
  public void run() {
    System.out.println("Sedan.run()");
  }
  
  public void openSunRoof() {
    System.out.println("Sedan.openSunRoof()");
  }
  public void closeSunRoof() {
    System.out.println("Sedan.closeSunRoof()");
  }
}
