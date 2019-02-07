package ch22.g;
import java.io.Serializable;

public class Score3 implements Serializable {
  private static final long serialVersionUID = 1L;
  
  // sum과 aver는 setter 제거 getter만 남김
  private String name;
  private int kor;
  private int eng;
  private int math;
  
  // serialize 대상에서 제외할 필드는 transient로 선언
  transient private int sum;
  transient private float aver;
  
  public Score3() {
    System.out.println("Score3()");
  }
  
  public String getName() {
    return name;
  }

  public void setName(String name) {
    System.out.println("setName()");
    this.name = name;
  }

  public int getKor() {
    return kor;
  }

  public void setKor(int kor) {
    System.out.println("setKor()");
    this.kor = kor;
    compute();
  }

  public int getEng() {
    return eng;
  }

  public void setEng(int eng) {
    System.out.println("setEng()");
    this.eng = eng;
    compute();
  }

  public int getMath() {
    return math;
  }

  public void setMath(int math) {
    System.out.println("setMath()");
    this.math = math;
    compute();
  }

  // sum, aver 필드처럼 내부 필드 값을 가지고 계산한 결과를
  // 저장하는 경우 외부에서 직접 필드의 값을 설정하지 못하게 해야한다
  // 즉 setter를 만들지 말라
  public int getSum() {
    return sum;
  }

  public float getAver() {
    return aver;
  }

  @Override
  public String toString() {
    return "Score3 [name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math + ", sum="
        + sum + ", aver=" + aver + "]";
  }
  
  public void compute() {
    this.sum = this.kor + this.eng +this.math;
    this.aver = this.sum /3f;
  }

}
