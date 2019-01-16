package ch12.c;

public class My {
  //내부멤버
  private int v1;
  // (defalt) : 내부멤버 + 같은 패키지
  int v2;
  // 내부멤버 + 같은 패키지 + (상속 받은 필드인 경우) 자손클래스
  protected int v3;
  // 완전공개
  public int v4;
  
  // 내부 멤버만이 접근가능
  public void m1() {
    this.v1 = 100;
  }


}
