// 버퍼 사용후
package ch22.c;

import java.io.FileInputStream;

public class Test01_2 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("jls11.pdf");) {
      System.out.println("data reading ...");
      byte[] buf = new byte[50];
      long start = System.currentTimeMillis();
      int len = 0;
      
      while((len = in.read(buf)) != -1) {
      }
      
      long end = System.currentTimeMillis();
      System.out.println(end - start);
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
