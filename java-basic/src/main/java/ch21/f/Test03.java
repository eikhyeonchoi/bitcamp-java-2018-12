// try-with-resources 사용 후
package ch21.f;

public class Test03 {
  
  static class MyResource1 {
    public int divide(int a, int b) {
      return a/b;
    }
    public void close() {
      System.out.println("MyResource1.close()");
    }
  }
  
  static class MyResource2 implements AutoCloseable {
    public int divide(int a, int b) {
      return a/b;
    }
    @Override
    public void close() {
      System.out.println("MyResource1.close()");
    }
  }
  
  public static void main(String[] args) {

    try (
        // AutoCloseable을 구현하지 않은 객체는 선언할 수 없다
        // MyResource1 res = new MyResource1();
        
        // AutoCloseable을 구현한 클래스는 객체를 선언할 수 있다
        MyResource2 res = new MyResource2();
        ){
      System.out.println(res.divide(10, 2));
      System.out.println(res.divide(10, 0));
      
      // try 블록을 벗어나기 전에 close()가 자동 호출 된다
    } catch (Exception e) {
      System.out.println("exception ..");
      
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

  }
}
