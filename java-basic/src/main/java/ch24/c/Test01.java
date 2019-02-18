// 스레드 정의하기 - Thread 상속받기
package ch24.c;

public class Test01 {
  
  // 1) Thread 클래스를 상속받아 정의하기
  // ==> 구현하기 편함
  // ==> 다중 상속은 불가능 하기 때문에 다른 클래스를 상속받을 수 없다
  // ==> 즉 MyThread가 다른 클래스를 상속받으면서 스레드가 될 수 없음
  static class MyThread extends Thread {
    // 스레드에서 독립적으로 실행할 코드를 run()메서드에 작성
    @Override
    public void run() {
      for (int i = 0; i < 2000; i++) {
        System.out.printf("MyThread ==> %d\n", i);
      } // for
    } // run()
  } // MyThread class
  
  
  // 2) Runnable 인터페이스를 구현하기
  // ==> 실무에서 스레드를 만들 때 많이 사용한다 !!
  // ==> 인터페이스를 구현하는 것 이기 때문에 다른 클래스를 상속 받을 수 있다
  // ==> 직접적으로 스렏가 아니기 때문에 실행할 때는 Thread의 도움을 받아야한다
  static class MyWork implements Runnable {
    // 스레드에서 독립적으로 실행할 코드를 run()메서드에 작성
    @Override
    public void run() {
      for (int i = 0; i < 2000; i++) {
        System.out.printf("MyWork >>>> %d\n", i);
      } // for
    } // run()
  } // MyWork class
  
  
  public static void main(String[] args) {
    
    // 스레드 실행
    // 1) Thread의 서브클래스는 그냥 인스턴스를 만들어 start()를 호출
    MyThread t1 = new MyThread();
    t1.start(); // run() 메서드를 호출한 후 즉시 리턴 ==> 비동기로 동작
    
    // 2) Runnable 구현체는 인스턴스를 만들어 Thread객체의 생성자에 넘겨주고,
    //     스레드의 start()를 호출
    MyWork w = new MyWork();
    Thread t2 = new Thread(w);
    t2.start(); // 생성자의 넘겨준후 run() 메서드를 호출한 후 즉시 리턴 ==> 비동기로 동작
    
    for (int i = 0; i < 2000; i++) {
      System.out.printf("MainThread ~~> %d\n", i);
    } // for
    
    // 스레드에게 CPU 사용을 배분할 때 순서대로 하지 않는다
    // 운영체제의 CPU 스케줄링 정책에 따라 스레드가 실행된다
    // 즉 JVM에서 스레드를 실행하는 것이 아니라 운영체제가 실행
    // 결론 !
    // 똑 같은 자바의 스레드 코드가 OS에 따라 실행 순서가 달라질 수 있다
    
    // 우선 순위로 조정하면 되지 않나요 ?
    // ==> windows 경우 우선순위 값이 실행 순서나 실행 횟수에 큰 영향을 끼치지 않는다
    //      그래서 우선 순위의 값을 조정하여 스레드의 실행 횟수를 조정하려 해선 안됨
    // ==> 왜? 운영체제에 따라 실행 정책이 다르기 때문임
    // ==> 그냥 특정 코드를 동시에 실행할 수 있다고 생각해야됨
    
  } // main 
} // end of class
