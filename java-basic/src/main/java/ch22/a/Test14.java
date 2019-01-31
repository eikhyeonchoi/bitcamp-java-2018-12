// java.io.File class : 과제2 bin/main 폴더를 뒤져서 모든 클래스 파일의 이름을 출력하라
package ch22.a;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test14 {
  static int count = 0;
  public static void main(String[] args) throws IOException {
    // 클래스으 이름을 출력할 때 패키지 이름을 포함해야 한다
    // ex) ch01.Test01    
    File file = new File("bin/main");
    print(file, "");
    System.out.println(count);
  }

  static void print(File f, String a) {
    ++count;
    File[] files = f.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if(pathname.isDirectory()|| pathname.isFile() &&
            pathname.getName().endsWith(".class")) return true;
        else return false;
      }
    });
    
    for (File file : files) {
      if (file.isDirectory()) {
        print(file, a+file.getName()+".");
      } else if(file.isFile()) {
        System.out.printf("%s%s\n", a
            , file.getName().replace(".class", ""));
      }
    }
  }






}
