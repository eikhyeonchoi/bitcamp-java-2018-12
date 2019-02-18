package ch24.a;

public class Test01 {
  public static void main(String[] args) {
    
    
    // 스레드를 적용하지 않은 일반적인 코드는 비동기로 실행된다
    // 순차적으로 실행된다
    for(int i = 0; i< 1000; i++) {
      System.out.println("==>"+i);
    }
    for(int i = 0; i< 1000; i++) {
      System.out.println("==>"+i);
    }
  }
}
