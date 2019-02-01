// 버퍼 사용전
package ch22.c;
import java.io.FileOutputStream;

public class Test02_1 {
  public static void main(String[] args) {
    FileOutputStream out = null;
    
    try  {
      out = new FileOutputStream("data.bin");
      System.out.println("data writing ...");
      long start = System.currentTimeMillis();
      for (int i = 0; i< 1000000; i++) {
        out.write(0x55);
      }
      long end = System.currentTimeMillis();
      System.out.println("걸린시간(ms) = " + (end - start));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {out.close();} catch(Exception e) {}
      
    }
    
    System.out.println("complete ...");
    
    
    
    
  }
}
