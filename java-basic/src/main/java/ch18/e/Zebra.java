package ch18.e;

public class Zebra {
  public static final int ON = 1;
  public static final int OFF = 2;
  boolean use;
  public void rotate(int direction) {
    if (direction == 1) {
      this.use = true;
    } else if (direction == 2) {
      this.use = false;
    }
  }

}
