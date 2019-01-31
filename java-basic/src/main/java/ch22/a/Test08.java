// java.io.File class : 폴더 안에 있는 파일이나 하위 폴더를 알아내기
package ch22.a;
import java.io.File;
import java.io.IOException;

public class Test08 {
  public static void main(String[] args) throws IOException {

    // 파일은 디렉토리와 파일을 통칭하는 용아
    File file = new File("./");
    

    String[] names = file.list();
    for(String name : names) {
      System.out.print(name);
    }
    
    
    
    
    
  }
}
