// 다형성 - 오버라이딩을 하는 이유 : 상속받은 메서드를 재정의
package ch14.a;

public class Test01 {

  public static void main(String[] args) {
    
    Score2 score = new Score2();
    score.kor = 100;
    score.eng = 100;
    score.math = 100;
    score.music = 100;
    score.art = 100;
    score.compute();
    
    System.out.printf("%d(%.2f)\n", score.getSum(), score.getAver());
  }
}
