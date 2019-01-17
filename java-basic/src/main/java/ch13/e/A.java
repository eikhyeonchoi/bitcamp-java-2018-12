package ch13.e;

public class A {
  static int s1 = 100;
  private int v1 = 100;
  
  static {
    System.out.println("A.static int "+s1);
    System.out.println("A 스태틱블럭");
  }
  {
   v1 = 110;
   System.out.println("A.{}");
  }
  
  public A() {
    v1 = 120;
    System.out.println("A.A()");
  }
  
  public void m1() {
    System.out.printf("A.v1 = %d\n",this.v1);
  }
}
/*



*/