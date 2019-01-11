package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.handler.*;

public class App {
  static Scanner key = new Scanner(System.in);
  public static void main(String[] args) {
    
    LessonHandler.key = key;
    MemberHandler.key = key;
    BoardHandler.key = key;
    
    while(true) {
      String ans = prompt(key);
      
      if (ans.equals("quit")) break;
      
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