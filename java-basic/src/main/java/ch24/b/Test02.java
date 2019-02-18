// 스레드 그룹
package ch24.b;

public class Test02 {
  public static void main(String[] args) {

    // 자바의 스레드는 특정 그룹에 소속된다
    // "main" 스레드의 그룹은?
    Thread currentThread = Thread.currentThread();
    ThreadGroup group = currentThread.getThreadGroup();
    System.out.printf("현재 코드를 실행하는 스레드명 : %s\n",currentThread.getName());
    System.out.printf("스레드 그룹명 : %s\n",group.getName() + "(TG)");
  } // main 
} // end of class

// JVM의 스레드 계층도 : 
// main(TG)
//   ==> main(T)