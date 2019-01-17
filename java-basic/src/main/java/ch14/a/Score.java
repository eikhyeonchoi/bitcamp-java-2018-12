package ch14.a;

public class Score {
  protected String name;
  protected int kor;
  protected int eng;
  protected int math;
  protected int sum;
  protected float aver;

  public String getName() {return name;}
  public void setName(String name) {this.name = name;}
  public int getKor() {return kor;}
  public void setKor(int kor) {this.kor = kor;}
  public int getEng() {return eng;}
  public void setEng(int eng) {this.eng = eng;}
  public int getMath() {return math;}
  public void setMath(int math) {this.math = math;}
  public int getSum() {return sum;}
  public void setSum(int sum) {this.sum = sum;}
  public float getAver() {return aver;}
  public void setAver(float aver) {this.aver = aver;}

  public void compute() {
    this.sum = this.kor + this.eng + this.math;
    this.aver = this.sum / 3f;
  }
}
