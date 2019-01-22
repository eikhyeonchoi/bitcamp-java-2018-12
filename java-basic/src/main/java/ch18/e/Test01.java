// Canvas와 Pen을 사용하는 예
package ch18.e;

public class Test01 {
  public static void main(String[] args) {
    
    // Pen사용 규칙에 따라 만든 도구준비
    BallPen153 t1 = new BallPen153();
    MultiPen t2 = new MultiPen();
    
    // Pen이라는 도구를 사용하면 Canvas를 만든다
    Canvas c1 = new Canvas(t1);
    
    // 캔버스를 실행
    t1.press(true);
    c1.render("펜으로 그린것");
    
    c1.setPen(t2);
    t2.rotate(Zebra.ON);
    c1.render("펜으로 그린것");
    

  }
}
