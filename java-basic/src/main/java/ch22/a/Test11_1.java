// java.io.File class : 파일필터사용하기 
package ch22.a;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Test11_1 {
  static class TextFileFilter implements FileFilter {
    @Override
    public boolean accept(File pathname) {
      if (pathname.isFile() && pathname.getName().endsWith(".txt")) return true;
      return false;
    }
  }
  
  public static void main(String[] args) throws IOException {

    // 파일은 디렉토리와 파일을 통칭하는 용아
    File file = new File("./");
    
    // 하위 파일이나 디렉토리의 상세 정보 알아내기
    File[] files = file.listFiles(new TextFileFilter());
    for(File temp : files) {
      System.out.printf("%s %12d    %s\n"
          , temp.isDirectory() ? "d" : "-"
            , temp.length(), temp.getName());
    }
    
    
    
    
    
  }
}
