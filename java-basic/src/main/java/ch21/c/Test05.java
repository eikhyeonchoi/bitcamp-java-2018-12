// 어플리케이션 예외의 종류 : RuntimeException 계열 1
package ch21.c;

import java.util.ArrayList;

public class Test05 {
  public static void main(String[] args) {
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
    
    // 1) 적용
    // ==> 그냥두기
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(-1));
    // 예외가 발생하면 즉시 실행을 중지하고 호출자에게 보고한다
    // main()메서드의 호출자는 JVM이기 때문에 JVM은 예외를 보고 받으면 즉시 실행을 종료
    // 따라서 다음 코드는 실행되지 않는다
    
    System.out.println("끝");
    
    
    
    
  }
}
