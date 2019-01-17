package ch13.f;

public class Y extends X {
  private int y2 = 200;
  
  public Y() {
    // X 클래스는 기본 생성자가 없기 때문에 super(); compile error
    super(500); // 이런 경우 수퍼 클래스의 생성자를 명시해야함
    System.out.println("Y.Y()");
  }
  
  public void m2() {
    System.out.printf("Y.y2 = %d\n",this.y2);
  }
}
