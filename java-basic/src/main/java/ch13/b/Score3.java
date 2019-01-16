package ch13.b;

import ch13.Score;

// 기존의 Score 클래스를 상속받는다
// ==> 상속 받은 메서드 중에서 변경할 게 있으면 재정의 한다
// ==> 이것을 "오버라이딩(overriding)" 이라고 부른다
// ==> ex) compute()
public class Score3 extends Score {
  private int music;
  private int art;
  
  public void setMusic(int music) {
    if (music >= 0 && music <= 100) {
      this.music = music;
      this.compute();
    }
  }

  public void setArt(int art) {
    if (art >= 0 && art <= 100) {
      this.art = art;
      this.compute();
    }
  }

  public int getMusic() {
    return music;
  }

  public int getArt() {
    return art;
  }

  // 수퍼 클래스의 메서드 중에서 서브 클래스의 역할과 맞지 않는 경우
  // 서브 클래스의 역할에 맞춰서 재정의 해도 된다
  @Override
  protected void compute() {
    // 기존메서드를 호출해서 기존 3과목 합계 평균 계산 후 다시 2과목 추가해 계산
    // ==> 재정의 하기 전의 메서드를 호출할 때는 super를 이용한다
    super.compute();
    super.sum += this.music+this.art;
    super.aver = super.sum / 5f;
  }

}
