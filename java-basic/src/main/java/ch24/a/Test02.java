package ch24.a;

public class Test02 {
  
  static class MyThread extends Thread {
    
    // 스레드에 코드는 비동기로 동작한다
    // 다른 스레드와 별개로 실행
    @Override
    public void run() {
      for(int i = 0; i< 1000; i++) {
        System.out.println("MyThread==>"+i);
      } // for
    } // run
  } // MyThread
  
  public static void main(String[] args) {
    
    // 스레드는 비동기로 동적
    // 스레드에 작업을 시킨 후, 그 스레드가 작업이 끝날 때 까지 기다리지 않고 즉시 return;
    // 따라서 스레드 작업과 main()의코드가 병행(concurrent)로 동작됨
    
    MyThread t= new MyThread();
    t.start();
    
    for(int i = 0; i< 1000; i++) {
      System.out.println("main==>"+i);
    } // for
  } // main
} // end of class
