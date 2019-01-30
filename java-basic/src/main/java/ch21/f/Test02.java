// try-with-resources 사용 후
package ch21.f;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    // 자바에서는 자원 해제를 자동화시키는 try ~ catch 문법을 제공한다
    // 개발자가 finally에서 자원을 해제시키는 코드를 작성할 필요 없다
    // 단, java.lang.AutoCloseable 구현체인 경우에만 해당한다
    // 사용법
    //  try (java.lang.AutoCloseable 구현체의 변수를 선언) {
    //    ,,,
    //   } catch(Exception e) {
    //    ...
    //    }
    try (Scanner keyboard = new Scanner(System.in);) {
      System.out.print("값 ? :");
      int a = Integer.parseInt(keyboard.nextLine());

      int result = sum(a);
      System.out.println(result);

    } catch(Exception e) {
      try(
          StringWriter out = new StringWriter();
          PrintWriter out2 =  new PrintWriter(out);
          ){
        e.printStackTrace(out2);
        String str = out.toString();
        System.out.println(str);
      } catch(Exception e2) {
      }
    } finally {
      // try-with-resources 문법을 사용하면
      // JVM이 try()에 선언한 레퍼런스에 대해 try블록을 벗어나기 전에 close()를 자동호출하기 때문에
      // 다음과 같이 개발자가 직접 close()를 호출하는 코드를 작성할 필요가 없다
      // keyboard.close();
    }



  }

  static int sum(int value) {
    if (value == 1)
      return 1;
    return value + sum(value - 1);
  }




}
