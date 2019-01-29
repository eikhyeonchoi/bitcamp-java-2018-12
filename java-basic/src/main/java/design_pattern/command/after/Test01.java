package design_pattern.command.after;

import java.util.HashMap;
import java.util.Scanner;

public class Test01 {

  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    // Command 패턴
    // 명령어를 처리하는 각 메서드를 클래스로 정의한 후 사용한다
    // 일관된 사용을 위해 인터페이스로 호출 규칙을 정의한다
    // 나중에 명령어가 추가되면 그 명령어를 처리할 클래스를 추가하면 된다
    HashMap<String, Command> map = new HashMap<String, Command>();
    map.put("/board/add", new BoardAddCommand());
    map.put("/board/delete", new BoardDeleteCommand());
    map.put("/board/detail", new BoardDetailCommand());
    map.put("/board/list", new BoardListCommand());
    map.put("/board/update", new BoardUpdateCommand());
    map.put("/member/add", new MemberAddCommand());
    map.put("/member/delete", new MemberDeleteCommand());
    map.put("/member/detail", new MemberDetailCommand());
    map.put("/member/list", new MemberListCommand());
    map.put("/member/update", new MemberUpdateCommand());
    map.put("/hello", new HelloCommand());

    while(true) {
      System.out.print("명령 >> ");
      String input = keyboard.nextLine();
      if ("quit".equals(input)) {
        break;
      } else {
        Command command = map.get(input);
        if(command == null)
          System.out.println("처리할 수 없는 명령 입니다");
        else 
          // 명령어 사용 규칙에 따라 메서드를 호출한다
          command.execute();
      }
      System.out.println();
    }
    keyboard.close();






  }
}
