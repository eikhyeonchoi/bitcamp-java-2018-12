// java.io.File class : 필터와 람다 표현식을 사용해 필터를 사용해 디렉토리 이름만 추출하라
package ch22.a;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test12 {
  public static void main(String[] args) throws IOException {

    // 파일은 디렉토리와 파일을 통칭하는 용아
    File file = new File("./");

    // 하위 파일이나 디렉토리의 상세 정보 알아내기
    File[] files = file.listFiles(
        (File pathname)-> pathname.isDirectory() ? true : false);

    for(File temp : files) {
      System.out.printf("%s %12d    %s\n"
          , temp.isDirectory() ? "d" : "-"
            , temp.length(), temp.getName());
    }





  }
}
