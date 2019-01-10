// 인스턴스 배열?
package ch07;

public class Test08 {
  
  static class Score {
    String name;
    int kor;
    int eng;
    int math;
    int sum;
    float aver;
  }
  
  public static void main(String[] args) {

    // 낱개 변수 선언
    int v1, v2, v3;
    
    // int 배열
    int[] values = new int[3];
    // values : 배열의 주소를 저장하는 레퍼런스
    // new int[3] : int 변수 3개 생성, 각 항목에 저장하는 값은 int 값
    
    // 낱개의 레퍼런스 선언
    Score s1, s2, s3;
    
    // Score 변수 3개를 만드는 배열 선언
    // ==> Score 변수란 Score 인스턴스 주소를 담는 레퍼런스 말한다
    // ==> Score 레퍼런스를 3개 만든다.
    Score[] scores = new Score[3];
    // scores : 배열의 주소를 저장하는 레퍼런스
    // new Score[3] : Score 레퍼런스 3개를 생성한다 
    // !!!!!!!!!!!!!!!!!!!!!!!!!!!!인스턴스를 생성하는 것이 아니다.
    // 인스턴스 배열을 만들 수는 없다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    
    // 레퍼런스 배열을 생성하면 모든 항목이 null로 초기화됨
    // 아직 레퍼런스 배열의 각 항목에 인스턴스 주소가 없는 상태
    // 이런 상태에서 배열에 있는 항목을 사용할 수없다
    // System.out.println(scores[0].name);
    // ==> java.lang.NullPointerException
    // ==> name이 null이 아니라 scores[0]이 null 이라 runtime exception (실행 오류)
    
    // 배열 레퍼런스에 인스턴스 주소를 넣은 다음에 사용해야함
    scores[0] = new Score();
    scores[1] = new Score();
    scores[2] = new Score();
    
    System.out.println(scores[0].name);
    
    // 잊지말자
    // - 레퍼런스 배열만 가능
    // - !!!!!!!!!!!!!!!!!!!!!!!!!인스턴스 배열 절대 xxxxxxxxxxxxxxxxxxxxxxxxxxxx
    // - 단 자바 primitive data type만 배열로 만들 수 있다 ==> 인스턴스 배열 가능하단소리
    // - 그 외 모든 타입은 오직 레퍼런스 배열만 생성
    
    String[] ss = new String[3];
    System.out.println(ss[0]);
    
    
  }
  
}
/*
 
 */





