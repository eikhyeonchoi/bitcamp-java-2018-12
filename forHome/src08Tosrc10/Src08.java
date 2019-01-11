package src08Tosrc10;

import java.sql.Date;
import java.util.Scanner;
import src08Tosrc10.handler.BoardHandler;
import src08Tosrc10.handler.LessonHandler;
import src08Tosrc10.handler.MemberHandler;

public class Src08 {

  static final int LEN = 10;

  static Scanner key = new Scanner(System.in);
  public static void main(String[] args) {
    
    LessonHandler.key = key;
    MemberHandler.key = key;
    BoardHandler.key = key;


    while (true) {
      String ans = prompt();
      if (ans.equals("quit")) {
        System.out.println("프로그램을 종료합니다");
        break;
      }

      if (ans.equals("/lesson/add")) {
        LessonHandler.addLesson();
      } else if (ans.equals("/lesson/list")) {
        LessonHandler.listLesson();
      } else if (ans.equals("/member/add")) {
        MemberHandler.addMember();
      } else if (ans.equals("/member/list")) {
        MemberHandler.listMember();
      } else if (ans.equals("/board/add")) {
        BoardHandler.addBoard();
      } else if (ans.equals("/board/list")) {
        BoardHandler.listBoard();
      } else {
        System.out.println("실행할 수 없는 명령입니다");
        continue;
      }

    }


  }
  static String prompt() {
    System.out.print("명령> ");
    String ans = key.nextLine();
    return ans;
  }
 

}
