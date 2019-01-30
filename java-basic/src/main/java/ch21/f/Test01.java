// try-with-resources 사용전
package ch21.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test01 {
  public static void main(String[] args) {
    // 자바에서 제공하는 자원들 중에는 쓰고 난 후 해제시켜야 하는 자원이 있다
    // 보통 파일이나 네트워크 입출력, DB연결과 같은 자원이다
    // 무한대의 자원이 아닌 한정된 자원인 경우 특히 해제시키는 방식이 필수이다 다른프로그램이 사용해야하니깐
    // 이 예제에서는 Scanner객체나 FileWriter, PrintWriter객체가 이에 해당한다

    // 이런 한정된 자원을 사용하는 경우 대부분의 메서드가 예외를 던지게 정의되어 있다
    // 그래서 자원을 해제시킬 때 주로 try ~ catch ~ finally에서 처리한다
    Scanner keyboard = null;

    try {
      keyboard = new Scanner(System.in);
      System.out.print("값 ? :");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);
      System.out.println(result);

    } catch(Exception e) {
      StringWriter out = new StringWriter();
      PrintWriter out2 = new PrintWriter(out);

      // 상세 오류 정보를 String으로 받기
      e.printStackTrace(out2);
      out2.close();
      
      try {
        out.close();
      } catch(Exception exe) {
        // 자원을 해제시키다가 예외가 발생할 경우 개발자가 처리할 게 없다
        // 그래서 예외를 받기만 하고 특별히 뭔가를 수행하지는 않는다
      }

      // StringWriter객체에 저장된 문자열 꺼내기
      String str = out.toString();
      System.out.println(str);

    } finally {
      keyboard.close();
    }



  }

  static int sum(int value) {
    if (value == 1)
      return 1;
    return value + sum(value - 1);
  }




}
