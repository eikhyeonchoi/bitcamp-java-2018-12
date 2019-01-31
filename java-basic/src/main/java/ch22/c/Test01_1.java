// 버퍼 사용전
package ch22.c;

import java.io.FileInputStream;

public class Test01_1 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("jls11.pdf");) {
      System.out.println("data reading ...");
      long start = System.currentTimeMillis();
      int b;
      while((b = in.read()) != -1) {
        
      }
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
