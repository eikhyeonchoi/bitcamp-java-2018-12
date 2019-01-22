package ch18.f;

// 자동차가 가져야할 기본 필드와 메서드를 상속 받는다
public class Sedan extends AbstractCar {
  
  // 그리고 서브 클래스에게 구현하도록 맡겨진 메서드를 정의한다
  @Override
  public void run() {
    // TODO Auto-generated method stub
    System.out.println("Sedan.run()");
  }

  
}
