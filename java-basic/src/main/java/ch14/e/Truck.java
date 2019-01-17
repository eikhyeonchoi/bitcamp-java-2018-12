package ch14.e;

public class Truck extends Car{
  
  int weight; // 짐 싣는무게임
  @Override
  public void run() {
    System.out.println("Truck덜컹덜컹~ 달린다");
  }

}
