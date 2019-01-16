package ch13.a;

// 계산 결과에 영향을 미치는 필드에도 getter/setter를 적용한다
public class Score2 {
  // name필드는 private 제한자로 선언 안해도 되는데 다른 필드와의 일관성을
  // 유지하기 위해서 + 유지보수를 위해서 getter/setter를 만든다
  // 나중에 name에 대해 값의 유효성을 검사하는 코드를 삽입할 수 있어 좋다
  // 실무에서는 그냥 모든 필드를 private or protected 제한자를 선언하고
  // 만들어버리고 getter/setter 프로퍼티를 만든다
  // 그냥 모든 필드에 getter/setter 갈겨
  private String name;
  // 점수를 변경할 때 계산을 다시 해야하고, 유효하지 않은 값을 넣지 못하도록 막아야한다
  // 따라서 직접 접근하는 것을 막는다
  private int kor;
  private int eng;
  private int music;
  private int art;
  private int math;
  private int sum;
  private float aver;

  public void setName(String name) {
    this.name = name;
  }
  public void setKor(int kor) {
    if (kor >= 0 && kor <= 100) {
      this.kor = kor;
      this.compute();
    }
  }
  public void setEng(int eng) {
    if (eng >= 0 && eng <= 100) {
      this.eng = eng;
      this.compute();
    }
  }
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
  public void setMath(int math) {
    if (math >= 0 && math <= 100) {
      this.math = math;
      this.compute();
    }
  }
  public void setSum(int sum) {
    this.sum = sum;
  }
  public void setAver(float aver) {
    this.aver = aver;
  }

  
  public String getName() {
    return name;
  }
  public int getKor() {
    return kor;
  }
  public int getEng() {
    return eng;
  }
  public int getMath() {
    return math;
  }
  public int getSum() {
    return sum;
  }
  public int getMusic() {
    return music;
  }
  public int getArt() {
    return art;
  }
  public float getAver() {
    return aver;
  }
  // 점수를 변경할 때 마다 호출되기 때문에 임의로 호출할 필요 없다
  // 따라서 비공개로 만든다
  // ==> 초보 개발자의 많은 착각!
  // ==> 필드는 무조건 private, 메서드는 무조건 public으로 해야 한다고 생각한다
  // ==> 착각이다. 필드든 메서드든 공개할것은 공개하고 비공개할거는 비공개로
  // ==> 즉 기본이 비공개고, 공개할 것만 공개하라
  //     이렇게 하는 것이 클래스가 잘못 사용되는 상황을 방지할 수 있다
  private void compute() {
    this.sum = this.kor + this.eng + this.math + this.art + this.music;
    this.aver = this.sum / 5f;
  }
}
