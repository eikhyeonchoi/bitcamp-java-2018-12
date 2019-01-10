// main() 메서드의 parameter 응용 2
package ch06;

public class Test15 {
  public static void main(String[] args) {

    // 학생의 국영수 점수를 입력 받아 총점과 평균을 출력하라
    // $ java -cp ./main ch06.Test14 홍길동 100 100 90
    // 총점 : 290
    // 평균 : 96~~
    int sum = 0;

    for (int i = 1; i < args.length; i++) {
      sum += Integer.parseInt(args[i]);
    }
    System.out.printf("이름 : %s\n", args[0]);
    System.out.printf("총점 : %d\n", sum);
    System.out.printf("평균 : %f\n", sum/3f);




  }

}
/*

*/
