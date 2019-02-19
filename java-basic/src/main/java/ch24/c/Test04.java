// join() - 해당 스레드가 종료될 때 까지 현재 스레드를 기다리기함
package ch24.c;
public class Test04 {

  public static void main(String[] args) throws Exception {

    Thread t = new Thread() {
      @Override
      public void run() {
        for(int i = 0; i < 1000; i++) {
          System.out.printf("스레드 ==> %d\n", i);
        } // for
        try {
          sleep(5000); 
        } catch(Exception e) {}
      } // run()
    };
    t.start();

    // t Thread가 die할 때까지 (dead상태가 될 때까지) 기다린다
    t.join();

    for(int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~> %d\n", i);
    } // for



    // main() 메서드의 코드를 모두 실행했다고 해서 JVM이 종료되는것이 아님
    // 다른 스레드의 실행이 모두 끝나야만 JVM이 종료된다

  } // main 
} // end of class
