// String 읽기 - BufferedReader붙이기
package ch22.d;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.CharBuffer;

public class Test03_2 {
  public static void main(String[] args) {
    
    // FileReader
    // ==> 문자단위로 데이터를 읽는 일을 한다
    try (FileReader in = new FileReader("data.txt");
        // 데코레이터를 붙인다 ; 버퍼기능 + 한줄 일기 기능
         BufferedReader in2 = new BufferedReader(in)) {
      
      System.out.println(in2.readLine());
      
    } catch(Exception e) {
      e.printStackTrace();
    }
    
    
    
    
    System.out.println("...");
  }
}
