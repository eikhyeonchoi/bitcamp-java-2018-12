// 클래스 문법의 또 다른 용도 - 클래스 사용 전

package ch08;

import java.util.Scanner;

public class Test06 {

  public static void main(String[] args) {

    Scanner key = new Scanner(System.in);
    System.out.print("계산식 ? ( 12 * 2)");
    int a = key.nextInt();
    String op = key.next();
    int b = key.nextInt();

    key.close();

    int res = 0;
    switch (op) {
      case "+": res = plus(a, b); break;
      case "-": res = minus(a, b); break;
      case "*": res = multiple(a, b); break;
      case "/": res = divide(a, b); break;
      default : System.out.println("지원하지 않는 연산자"); return;
      // return : 메인 메서드를 그만실행하고 나간다 JVM 종료...
    }

    System.out.printf("%d %s %d = %d\n", a, op, b, res);

  }

  static int plus(int a, int b) {
    return a + b;
  }

  static int minus(int a, int b) {
    return a - b;
  }

  static int multiple(int a, int b) {
    return a * b;
  }

  static int divide(int a, int b) {
    return a / b;
  }

}

/*
 * # 클래스 문법의 용도 1) 새 데이터 타입을 정의할 때 2) 관련 메서드를 분류할 때
 * 
 */


