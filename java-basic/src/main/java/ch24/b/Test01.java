// "main" 스레드
package ch24.b;

public class Test01 {
  public static void main(String[] args) {
    // JVM은 main()메서드를 호출할 때 직접 실행하지 않고
    // 스레드를 생성하여 main()을 호출한다
    // 이렇게 main()을 호출하는 스레드를 main스레드라고 부른다

    // 현재 코드를 실행하는 스레드를 알아내기
    Thread currentThread = Thread.currentThread();
    System.out.println(currentThread.getName());
  } // main 
} // end of class

// JVM의 스레드 계층도 : 
// main(T)