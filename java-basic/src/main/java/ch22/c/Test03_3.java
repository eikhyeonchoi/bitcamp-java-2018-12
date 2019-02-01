// 데코레이터를 여러개 연결
package ch22.c;
import java.io.FileOutputStream;

public class Test03_3 {
  public static void main(String[] args) {

    // 데코레이터의 장점
    // ==> 기능을 붙이고 떼기가 쉽다
    try (FileOutputStream out  = new FileOutputStream("data.bin");
        // 버퍼단위로 읽는 데코레이터를 붙인다 ==> 쓰기 속도 빨라진다
        BufferedOutputStream out1 = new BufferedOutputStream(out);
        DataOutputStream out2 = new DataOutputStream(out1)) {
      
      int no = 200;
      String name = "ABC가각rksrkerkf";
      int age = 30;
      
      out2.writeInt(no);
      out2.writeUTF(name);
      out2.writeInt(age);
      
      out2.flush();
      
      
      
    } catch (Exception e) {
      e.printStackTrace();
      
    }
    
    
    
    
    
    System.out.println("complete ...");
  }
}
