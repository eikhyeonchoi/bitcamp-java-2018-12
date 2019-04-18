class SuperClass {

  public void draw() {
    prnt();
  }

  public void prnt() {
    System.out.println("SuperClass.prnt()");
  }
}

class SubClass extends SuperClass {
  public void prnt() {
    System.out.println("SubClass.prnt()");
  }
  public void draw() {
    super.draw();
    prnt();
  }
}

public class TestTest {
  public static void main(String[] args) {
    SuperClass obj = new SubClass();
    obj.draw();
  }
}
