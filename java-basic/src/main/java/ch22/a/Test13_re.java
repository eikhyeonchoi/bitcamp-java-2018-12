package ch22.a;
import java.io.File;
import java.io.FileFilter;

public class Test13_re {
  public static void main(String[] args) {

    File deleteFile = new File("bin");
    remove(deleteFile);



    System.out.println("complete ...");
  }

  public static void remove(File file) {
    File[] files = file.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        if (pathname.isDirectory() 
            || pathname.getName().endsWith(".class") 
            && pathname.isFile()) return true;
        else return false;
      }
    });
    for (File temp : files) {
      if (temp.isDirectory()) {
        System.out.println(temp.getName());
        remove(temp);
      }
      else if(temp.isFile()) temp.delete();
    }
      


  }

}
