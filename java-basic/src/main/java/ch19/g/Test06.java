// 파일 필터 클래스를 익명
package ch19.g;
import java.io.File;
import java.io.FilenameFilter;

public class Test06 {
  public static void main(String[] args) {
    
    // list()를 호출할 때 필터 객체를 딱 한번만 만들어 사용할 것이기 때문에
    // 굳이 로컬 클래스로 단정하게 정의할 필요가 없다
    // list() 메서드 가까이 익명 클래스를 사용하자
    
    
    File dir = new File("./"); 
    String[] names = dir.list(new FilenameFilter() {
      @Override
      public boolean accept(File dir, String name) {
        if (name.endsWith(".txt")) return true;
        return false;
      }
    });
    // 필터가 무슨 일을 하는지 바로 알 수 있다
    // ==> 필터의 소스 코드를 확인하기 위해 돌아 다닐 필요x
    // ==> 코드 길이가 짧을 경우 좋음 길면 보기가 어려움
    
    for(String name : names) {
      System.out.println(name);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
