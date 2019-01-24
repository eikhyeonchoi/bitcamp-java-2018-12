// 파일 필터 클래스는 중첩클래스로 만든다
package ch19.g;
import java.io.File;
import java.io.FilenameFilter;

public class Test03 {
  // 이 클래스 내부에서만 사용할 클래스라면 이렇게 중첩 클래스로 만드는 것이 유지보수에 좋다
  public static class MyFilenameFilter implements FilenameFilter {
    @Override
    public boolean accept(File dir, String name) {
      if (name.endsWith(".txt")) return true;
      return false;
    }
  }
  public static void main(String[] args) {
    File dir = new File("./"); 
    
    Object obj = new MyFilenameFilter();
    
    
    // 필터 클래스가 같은 클래스에 있어 무슨 일을 하는지 소스를 살펴보기 편함
    String[] names = dir.list(new MyFilenameFilter());
    
    for(String name : names) {
      System.out.println(name);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
