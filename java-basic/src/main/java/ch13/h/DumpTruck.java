// 상속 : generalization 수행 전
package ch13.h;

// 다음과 같이 필요한 클래스를 정의한다
public class DumpTruck {

  String model;
  int cc;
  int weight;
  
  public void run() {
    System.out.println("Dump.run() 달린다");
  }
  public void stop() {
    System.out.println("Dump.stop() 멈춘다");
  }
  public void dump() {
    System.out.println("Dump.dump() 짐을내린다");
  }
}
