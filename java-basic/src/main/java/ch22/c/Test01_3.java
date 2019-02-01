package ch22.c;
import java.io.FileInputStream;

public class Test01_3 {
  public static void main(String[] args) {
    
    try (FileInputStream in = new FileInputStream("jls11.pdf");) {
      System.out.println("data reading ...");
      BufferedInputStream in2 = new BufferedInputStream(in);
      int count = 0;
      long start = System.currentTimeMillis();
      int b;
      while((b = in2.read()) != -1) {
        count++;
      }
      long end = System.currentTimeMillis();
      System.out.println("걸린시간(ms) = " + (end - start));
      System.out.println("메서드 수행 횟수 = "  + count + "번");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    // 3 3 3 6 2 9 4
    System.out.println("complete ...");

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
