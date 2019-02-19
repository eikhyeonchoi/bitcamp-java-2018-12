// 스레드의 생명주기
package ch24.c;
public class Test03 {

  public static void main(String[] args) throws Exception {

    Thread t = new Thread() {
      @Override
      public void run() {
        for(int i = 0; i < 1000; i++) {
          System.out.printf("스레드 ==> %d\n", i);
        } // for
      } // run()
    };
    t.start();

    new Thread(new Runnable() {
      @Override
      public void run() {
        for(int i = 0; i < 1000; i++)
          System.out.printf("스레드2 >>>>>>>> %d\n", i);
      }
    }).start();
    
    // 메인스레드 5초동안 not runnable
    // 즉 메인 스레드를 실행x
    Thread.currentThread().sleep(5000);

    // 주의 
    // dead 상태에서 다시 실행x 
    // t.start();
    // java.lang.IllegalThreadStateException 예외발생
    
    
    

    for(int i = 0; i < 1000; i++) {
      System.out.printf("main() ~~> %d\n", i);
    } // for
    // main() 메서드의 코드를 모두 실행했다고 해서 JVM이 종료되는것이 아님
    // 다른 스레드의 실행이 모두 끝나야만 JVM이 종료된다

  } // main 
} // end of class
