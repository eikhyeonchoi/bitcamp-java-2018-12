// java.io.File class : 파일 삭제
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test06 {
  public static void main(String[] args) throws IOException {
    
    // 파일을 삭제함
    // 존재하지 않는 파일은 삭제할 수 없음
    File dir = new File("temp2/test.txt");
    if (dir.delete()) 
      System.out.println("file delete ok");
    else 
      System.out.println("file delete not ok");
    
    
    
    
    
  }
}
