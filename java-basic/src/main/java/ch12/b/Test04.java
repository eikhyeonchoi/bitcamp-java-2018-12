// getter/setter 적용하면 좋은 이유
package ch12.b;

public class Test04 {

  public static void main(String[] args) {
    Score2 s2 = new Score2();
    
    // 다른 필드의 값은 모두 setter를 통해서 설정하는데 name필드만 직접 설정한다면
    // 프로그래밍의 일관성이 없어 유지보수가 불편
    // 그래서 굳이 setter나 getter가 필요 없는 필드라도
    // 다른 필드와의 일관성을 위해 만든다
    s2.setName("홍길동");
    // 국, 영, 수 점수를 직접 변경할 수 없다
    // s1.kor = 100;
    // s1.eng = 90;
    // s1.math = 80;

    s2.setKor(100);
    s2.setEng(90);
    s2.setMath(80);
    // 점수 설정할때 내부에서 compute()를 호출하기 때문에 따로호출할 필요 xx
    // 또한 compute()는 private로 비공개
    // s1.compute();
    System.out.printf("이름 : %s, 총점 : %d, 평균 : %.2f\n"
        ,s2.getName(), s2.getSum(), s2.getAver());
    
    s2.setKor(70);
    System.out.printf("이름 : %s, 총점 : %d, 평균 : %.2f\n"
        ,s2.getName(), s2.getSum(), s2.getAver());
    
    s2.setEng(-200);
    System.out.printf("이름 : %s, 총점 : %d, 평균 : %.2f\n"
        ,s2.getName(), s2.getSum(), s2.getAver());
    
    
  }
}
















