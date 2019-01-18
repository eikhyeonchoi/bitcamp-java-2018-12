package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;

public class App {

  static Scanner keyboard = new Scanner(System.in);

  public static void main(String[] args) {
    
    // LessonHandler temp = new LessonHandler(); copile error
    LessonHandler lHandler = new LessonHandler(keyboard);
    MemberHandler mHandler = new MemberHandler(keyboard);
    BoardHandler bHandler = new BoardHandler(keyboard);

    while (true) {
      String command = prompt();

      if (command.equals("/lesson/add")) {
        lHandler.addLesson();
        
      } else if (command.equals("/lesson/list")) {
        lHandler.listLesson();
      } else if (command.equals("/member/add")) {
        mHandler.addMember();
        
      } else if (command.equals("/member/list")) {
        mHandler.listMember();
        
      } else if (command.equals("/board/add")) {
        bHandler.addBoard();
        
      } else if (command.equals("/board/list")) {
        bHandler.listBoard();
        
      } else if (command.equals("/board/detail")) {
        bHandler.detailBoard();
        
      } else if (command.equals("quit")) {
        System.out.println("안녕!");
        break;
        
      } else {
        System.out.println("실행할 수 없는 명령입니다.");
      }
      
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }
}
