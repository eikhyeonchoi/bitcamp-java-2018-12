package design_pattern.builder;

import java.util.ArrayList;

public class Car {
  Body body;
  Engine engine;
  ArrayList<Door> doors = new ArrayList<>();
  
  public Car(Body b, Engine e) {
    this.body = b;
    this.engine = e;
  }
  
  public void addDoor(Door door) {
    doors.add(door);
  }

  @Override
  public String toString() {
    return "\nCar [body=" + body + ", \nengine=" + engine + ", \ndoors=" + doors + "]";
  }
  
  
}
