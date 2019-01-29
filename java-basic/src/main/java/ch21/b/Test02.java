// 예외 처리하기 - 여러개의 예외가 발생할 때 : 멀티 catch블록
package ch21.b;
import java.util.HashMap;
import java.util.Scanner;

public class Test02 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    HashMap<String, Command> map = new HashMap<>();

    map.put("plus", new PlusCommand(keyboard));

    while(true) {
      System.out.print("명령 >> ");
      String input = keyboard.nextLine();
      
      if(input.equals("quit")) break;
      // 예외 처리 문법을 적용하면, 예외가 발생하더라도 JVM을 멈추지 않음
      try {
        Command commandHandler = map.get(input);
        commandHandler.execute();
        
        // try 블록에서 발생할 수 있는 예외가 여러개 일때
        // 각 예외 정보를 받을 catch블록을 여러 개 둘 수 있다
      } catch(NullPointerException e) {
        System.out.println("해당 명령이 존재하지 않습니다");

      } catch(NumberFormatException e) {
        System.out.println("숫자를 입력하십시오 ...");
      }
    }



    System.out.println("실행 완료");
    keyboard.close();


  }
}
