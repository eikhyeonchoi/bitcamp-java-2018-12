// java.io.File class : 파일생성
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test05 {
  public static void main(String[] args) throws IOException {
    
    // 존재하지 않는 파일을 생성
    // ==> 파일이 이미 존재하면 생성 못함
    File dir = new File("temp2/test.txt");
    if (dir.createNewFile()) 
      System.out.println("createNewFile ok");
    else 
      System.out.println("createNewFile not ok");
    
    // 디렉토리가 존재하지 않아도 파일을 생성하지 못함
    // 디렉토리가 자동으로 생성되지 않는다 ==> 예외 발생
    dir = new File("temptemptemp/test.txt");
    if (dir.createNewFile()) 
      System.out.println("createNewFile ok");
    else 
      System.out.println("createNewFile not ok");
    
    
    
    
  }
}
