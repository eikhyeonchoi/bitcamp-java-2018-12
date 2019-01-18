// 상속 : generalizaiton 수행 전
package ch13.h;

// 다음과 같이 필요한 클래스를 정의한다
public class Convertible {
  String model;
  int cc;
  boolean open;
  
  public void run() {
    System.out.println("Convertible.run() 달린다");
  }
  public void stop() {
    System.out.println("Convertible.stop() 멈춘다");
  }
  public void openRoof() {
    System.out.println("Convertible.openRoof() 뚜껑열린다");
    open = true;
  }
  public void closeRoof() {
    System.out.println("Convertible.closeRoof() 뚜껑닫힌다");
    open = false;
  }
}
