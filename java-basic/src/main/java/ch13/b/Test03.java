// 기능 확장 - Score 클래스를 상속받아 기능 추가
package ch13.b;

import ch13.Score;

public class Test03 {

  public static void main(String[] args) {
    
    // Score3를 이용해 수퍼 클래스의 기능을 호출할 수 있다
    // ==> Score2나 다를바 없지만 Score3는 compute()를 override
    Score2 s = new Score2();
    s.setName("홍길동"); // Score
    s.setKor(100); // Score
    s.setEng(100); // Score
    s.setMath(100); // Score
    s.setMusic(100); // Score2
    s.setArt(100); // Score2
    System.out.printf("%s: %d(%f)\n"
        , s.getName(), s.getSum(), s.getAver()); // Score

  }

}
