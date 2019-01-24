// 파일 필터 클래스를 로컬 클래스로 만든다
package ch19.g;
import java.io.File;
import java.io.FilenameFilter;

public class Test04 {
  public static void main(String[] args) {
    
    // 이 메서드 내부에서만 사용할 클래스라면 이렇게 로컬 클래스로 만드는 것이 유지보수에 좋다
    class MyFilenameFilter implements FilenameFilter {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt")) return true;
        return false;
      }
    }
    
    // 이전의 경우 보다 훨 씬 더 중첩 클래스가 가까이 있어 소스 보기가 편함
    // 문제는 list() 호출하는 코드와 필터 클래스는 정의하는 코드 사이에
    // 많은 코드가 있으면 보기 불편
    File dir = new File("./"); 
    String[] names = dir.list(new MyFilenameFilter());
    
    for(String name : names) {
      System.out.println(name);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
