package ch13.f;

public class B extends A {
  private int v2 = 200;
  
   public B() {
     super(); // B의 수퍼클래스 A클래스 ==> A클래스의 기본생성자 호출
     System.out.println("B.B()");
   }
  
  public void m2() {
    System.out.printf("B.v2 = %d\n",this.v2);
  }
}
