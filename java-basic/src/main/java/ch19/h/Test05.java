// lambda 문법 - 람다 문법 - 리턴
package ch19.h;

public class Test05 {

  static interface Calculator {
    int comput(int a, int b);
  }
  public static void main(String[] args) {
    // 1) 리턴 값은 return 명령을 사용해 처리
    Calculator c1 = (a,b) -> { return a + b; };
    System.out.println(c1.comput(10, 20));

    // 2) 한 문장으로된 표현식 (return ~~; 값을리턴하는 한 문장의코드)일 경우 괄호 생략가능
    Calculator c2 = (a,b) -> a - b;
    System.out.println(c2.comput(10, 20));

    // Math.max()는 int를 return, 그래서 이 메서드를 호출하는 문장은 표현식
    Calculator c3 = (a,b) -> Math.max(a, b);
    System.out.println(c3.comput(10, 20));

    // 값을 리턴해야하는데 람다 문장에서 값을 리턴하지 않으면 컴파일 에러
    // Calculator c4 = (a,b) -> System.out.println(a + ", " + b );
    // System.out.println(c4.comput(10, 20));















  }
}
