package ch13.b;

import ch13.Score;

// 기존의 Score 클래스를 상속받는다
// ==> 기존 코드를 복제하는게 아니라 권한을 획득한다는 의미임
public class Score2 extends Score {
  private int music;
  private int art;
  
  public void setMusic(int music) {
    if (music >= 0 && music <= 100) {
      this.music = music;
      this.compute2();
    }
  }

  public void setArt(int art) {
    if (art >= 0 && art <= 100) {
      this.art = art;
      this.compute2();
    }
  }

  public int getMusic() {
    return music;
  }

  public int getArt() {
    return art;
  }

  private void compute2() {
    // 기존메서드를 호출해서 기존 3과목 합계 평균 계산 후 다시 2과목 추가해 계산
    this.compute();
    super.sum += this.music+this.art;
    super.aver = super.sum / 5f;
  }

}
