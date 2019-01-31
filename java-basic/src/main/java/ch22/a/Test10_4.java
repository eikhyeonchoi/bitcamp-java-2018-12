// java.io.File class : 필터 사용하기
package ch22.a;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Test10_4 {
  public static void main(String[] args) throws IOException {
    File file = new File("./");

    // lambda class
    // ==> 메서드가 한 개밖에 없는 경우 lambda 표현식을 사용할 수 있다
    // ==> 문법
    //            (파라미터,파라미터,...) -> 문장한개
    //            (파라미터,파라미터,...) -> {문장1,문장2,..}
    //            () -> 문장한개
    //            () -> {문장1,문장2,..}
    String[] names = file.list((File dir, String name) -> {
      if (name.endsWith(".txt")) return true;
      return false;
    });

    for(String name : names) {
      System.out.println(name);
    }
  }
}
