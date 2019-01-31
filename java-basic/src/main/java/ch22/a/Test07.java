// java.io.File class : 폴더 생성 후 파일 생성
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test07 {
  public static void main(String[] args) throws IOException {
    
    // 폴더와 파일을 한 번에 생성하는 방법
    File file = new File("temp2/a/b/c/test.txt");
    
    // 파알의 디렉토리 경로를 가지고 file 객체생성
    System.out.println(file.getParent());
    File dir = file.getParentFile();
    
    // 먼저 디렉토리를 생성한다
    if (dir.mkdirs() ) 
      System.out.println("mkdir ok");
    else 
      System.out.println("mkdir not ok");
    
    if (file.createNewFile()) 
      System.out.println("createNewFile ok");
    else 
      System.out.println("createNewFile not ok");
    
    
    
    
    
  }
}
