// java.io.File class : 필터 사용하기
package ch22.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test10_3 {
  public static void main(String[] args) throws IOException {
    File file = new File("./");

    // anonymous class
    String[] names = file.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt")) return true;
        return false;
      }
    });

    for(String name : names) {
      System.out.println(name);
    }
  }
}
