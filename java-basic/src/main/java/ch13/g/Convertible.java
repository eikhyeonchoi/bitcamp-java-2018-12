// 상속 : spcialization
package ch13.g;

// 기존 클래스에 기능을 덧붙여 특별한 클래스를 만드는 것
// ==> 수퍼 클래스를 상속받아 서브 클래스는 만드는 것을 spcialization이라 한다
public class Convertible extends Car{
  boolean open;
  
  public void openRoof() {
    System.out.println("Convertible.openRoof() 뚜껑열린다");
    open = true;
  }
  public void closeRoof() {
    System.out.println("Convertible.closeRoof() 뚜껑닫힌다");
    open = false;
  }
}
