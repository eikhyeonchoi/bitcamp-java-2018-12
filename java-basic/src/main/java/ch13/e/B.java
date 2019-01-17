package ch13.e;

public class B extends A {
  static int s2 = 200;
  private int v2 = 200;
  
  
  static{
    System.out.println("B.static int "+s2);
    System.out.println("B 스태틱블럭");
  }
  {
    v2 = 210;
    System.out.println("B.{}");
   }
   public B() {
     v2 = 220;
     System.out.println("B.B()");
   }
  
  public void m2() {
    System.out.printf("B.v2 = %d\n",this.v2);
  }
}
