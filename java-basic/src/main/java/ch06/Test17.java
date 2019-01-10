// JVM 아규먼트 응용 1
package ch06;

public class Test17 {
  public static void main(String[] args) {
    
    // 학생의 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./main ch06.Test14 홍길동 100 100 90
    // 총점 : 290
    // 평균 : 96~~
    // => System.getProperty("이름");
    String name = System.getProperty("name");
    int v1 = Integer.parseInt(System.getProperty("kor"));
    int v2 = Integer.parseInt(System.getProperty("eng"));
    int v3 = Integer.parseInt(System.getProperty("math"));
    
    int sum = v1+v2+v3;

    System.out.printf("이름 : %s\n",name);
    System.out.printf("총점 : %d\n", sum);
    System.out.printf("평균 : %.1f\n", sum/3.0f);

  }

}


/*

*/
