// 상속 : specialization
package ch13.g;

public class Car {
  String model;
  int cc;
  
  public void run() {
    System.out.println("Car.run() 달린다");
  }
  public void stop() {
    System.out.println("Car.stop() 멈춘다");
  }
}
