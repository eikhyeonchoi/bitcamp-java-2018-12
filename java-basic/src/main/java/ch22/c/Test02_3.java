// 버퍼 사용 - 버퍼 기능을 대신 수행해주는 BufferedOutputStream 사용하기
package ch22.c;
import java.io.FileOutputStream;

public class Test02_3 {
  public static void main(String[] args) {
    
    try (FileOutputStream out = new FileOutputStream("data.bin");
        BufferedOutputStream out2 = new BufferedOutputStream(out);) {
      
      System.out.println("data writing ...");
      
      long start = System.currentTimeMillis();
      for (int i = 0; i< 1000000; i++) {
        out2.write(0x55);
      }
      out2.flush();
      long end = System.currentTimeMillis();
      System.out.println("걸린시간(ms) = " + (end - start));
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    System.out.println("complete ...");
    
    
    
    
  }
}
