// java.io.File class : 과제 빈 폴더를 삭제하라
package ch22.a;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test13 {
  static int count = 0;
  public static void main(String[] args) throws IOException {

    // 파일은 디렉토리와 파일을 통칭하는 용아
    File file = new File("bin");
    delete(file);
    System.out.println("complete ... " + "count = " + count);
  }

  static void delete(File f) {
    count ++;
    File[] files = f.listFiles();
    /*
    for (int i = 0; i < files.length; i++) {
      if(files[i].isFile()) {
        files[i].delete();
      } else if (files[i].isDirectory()) {
        delete(files[i]);
      }
    }
    */
    for (File temp : files) {
      if(temp.isDirectory()) delete(temp);
      else {
        System.out.println(temp.getName());
        temp.delete();
      }
    }
    f.delete();
  }


  
  
  
  
}
