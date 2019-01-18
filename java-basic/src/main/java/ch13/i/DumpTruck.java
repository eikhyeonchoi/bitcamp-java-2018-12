// 상속 : generalization 수행 후
package ch13.i;

//여러 클래스 에 공통으로 들어 가는 기능이나 필드가 있다면
//유지보수가 쉽도록 별도의 클래스로 추출한다
//그리고 상속 관계를 맺는다
//Convertible과 DumpTruck사이에 공통 메서드와 필드가 있다
//==> 공통기능을 추출하여 별도의 클래스를 정의하는것을 generalization이라한다
public class DumpTruck extends Car {
  int weight;
  
  public void dump() {
    System.out.println("Dump.dump() 짐을내린다");
  }
}
