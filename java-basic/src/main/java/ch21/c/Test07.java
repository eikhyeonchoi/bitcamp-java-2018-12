// 어플리케이션 예외의 종류 : RuntimeException 계열 1
package ch21.c;

import java.util.ArrayList;

public class Test07 {
  public static void main(String[] args) throws RuntimeException {
    // RuntimeException 예외는 굳이 메서드 선언부에 지정할 필요 없음
    // 지정하지 않아도 예외가 발생하면 호출자에게 던진다
    // 다만 그럼에도 메서드 선언부에 지정하는 이유는
    // 이 메서드를 호출하는 개발자에게 이 미세드에서 어떤 예외가 발생하는지 알려주기 위험이다
    // 물론 이번 예제에서 main()에 붙이는 것은 아무 의미가 없음
    
    ArrayList<String> list = new ArrayList<>();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    // get() 메서드
    // ==> 목록에서 인덱스 지정한 위치의 값을 꺼내준다
    // ==> 만약 인덱스가 무효하다면 IndexOutOfBoundsException 예외가 발생
    // ==> IndexOutOfBoundsException은 RuntimeException 계열의 예외 클래스이다
    
    // RuntimeException 계열의 예외 처리
    // 1) try ~ catch를 사용하지 않으면 자동으로 호출자에게 보고된다
    // 2) try ~ catch를 사용할 수 있다
    // 3) throws 문장을 선언할 수 있다

    // 3) 적용
    // ==> 메서드 선언부에 throws절을 추가
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(-1)); // 메서드에선언된 대로 상위 호출자에게 호출한다
    
    // 밑 코드는 실행되지 않는다 왜? 예외가 발생하면 main()의 호출자에게 보고하라고 throws절에
    // 선언되어 있기 때문에 JVM은 예외를 보고 받으면 즉시 프로그램을 종료한다
    System.out.println("실행 중 오류 발생");
    System.out.println("끝");



  }
}
