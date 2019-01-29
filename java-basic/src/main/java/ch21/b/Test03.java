// 예외 처리하기 - 여러 개의 예외를 한 catch 블록에서 처리할 수 있다
package ch21.b;
import java.util.HashMap;
import java.util.Scanner;

public class Test03 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    HashMap<String, Command> map = new HashMap<>();

    map.put("plus", new PlusCommand(keyboard));
    map.put("divide", new DivideCommand(keyboard));

    while(true) {
      System.out.print("명령 >> ");
      String input = keyboard.nextLine();

      if(input.equals("quit")) break;
      // 예외 처리 문법을 적용하면, 예외가 발생하더라도 JVM을 멈추지 않음
      try {
        Command commandHandler = map.get(input);
        commandHandler.execute();

        // 여러 개의 예외를 한 catch 블록에서 받고 싶다면
        // 공통 수퍼 클래스의 파라미터를 선언하면 된다
        // NullPointerException, NumberFormatException, ArithmeticException
        // 이들 예외 클래스의 공통 수퍼클래스는 RuntimeException이다
        //
        // 테스트하는 방법
        // 1) 없는 명령어 입력 - minus => NullPointerException
        // 2) 숫자대신 문자열 - 값1? ok => NumberFormatException
        // 3) 0으로 나누기 값2? 0 =? ArithmeticException
        } catch(RuntimeException e) {
        //} catch(Throwable e) { // Exception 보다 높음 이게 제일이네
        // catch의 파라미터는 오직 Throwable계열만 허락한다         Object XXX
        //} catch(Exception e) { // Exception으로 받는게 더 좋음 RuntimeException보다 상위임
        System.out.println("occured exception ...");
        System.out.println(e.toString());

      } 
    }



    System.out.println("실행 완료");
    keyboard.close();


  }
}
