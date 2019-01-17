package ch13.f;

public class X {
  private int x1 = 100;
  
  public X(int v) {
    this.x1 = v;
    System.out.println("X.X()");
  }
  
  public void m1() {
    System.out.printf("X.x1 = %d\n", this.x1);
  }
}
