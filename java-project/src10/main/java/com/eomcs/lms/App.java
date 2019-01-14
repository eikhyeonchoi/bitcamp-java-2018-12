package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {
  public static void main(String[] args) {
    
    Scanner key = new Scanner(System.in);
    LessonHandler.key = key;
    MemberHandler.key = key;
    BoardHandler.key= key;
    
    
 
    while(true) {
      
      String ans = prompt(key);
      
      if (ans.equals("quit"))  {
        System.out.println("안녕\n...\n...");
        break;
      }
      
      if(ans.equals("/lesson/add")) {
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
        System.out.println("지정된 명령이 아닙니다");
        continue;
      }
    }
    
  }

  static String prompt(Scanner key) {
    System.out.print("명령> ");
    String ans = key.nextLine();
    return ans;
  }
  
}
