// 버퍼 사용전
package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("jls11.pdf");) {
      System.out.println("data reading ...");
      long start = System.currentTimeMillis();
      int b;
      int count = 0;
      while((b = in.read()) != -1) {
        count++;
      }
      long end = System.currentTimeMillis();
      System.out.println("걸린시간(ms) = " + (end - start));
      System.out.println("메서드 수행 횟수 = " + count);
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
