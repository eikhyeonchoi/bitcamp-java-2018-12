package com.eomcs.lms;

import java.util.Scanner;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> stack = new Stack<>();
  static Queue<String> queue = new Queue<>();

  public static void main(String[] args) {

    // LessonHandler temp = new LessonHandler(); copile error
    LessonHandler lHandler = new LessonHandler(keyboard);
    MemberHandler mHandler = new MemberHandler(keyboard);
    BoardHandler bHandler = new BoardHandler(keyboard);

    while (true) {
      String command = prompt();
      stack.push(command);
      queue.offer(command);

      if (command.equals("/lesson/add")) {
        lHandler.addLesson();

      } else if (command.equals("/lesson/list")) {
        lHandler.listLesson();

      } else if (command.equals("/lesson/detail")) {
        lHandler.detailLesson();

      } else if (command.equals("/lesson/update")) {
        lHandler.updateLesson();

      } else if (command.equals("/lesson/delete")) {
        lHandler.deleteLesson();

      } else if (command.equals("/member/add")) {
        mHandler.addMember();

      } else if (command.equals("/member/list")) {
        mHandler.listMember();

      } else if (command.equals("/member/detail")) {
        mHandler.detailMember();

      } else if (command.equals("/member/update")) {
        mHandler.updateMember();

      } else if (command.equals("/member/delete")) {
        mHandler.deleteMember();

      } else if (command.equals("/board/add")) {
        bHandler.addBoard();

      } else if (command.equals("/board/list")) {
        bHandler.listBoard();

      } else if (command.equals("/board/detail")) {
        bHandler.detailBoard();

      } else if (command.equals("/board/update")) {
        bHandler.updateBoard();

      } else if (command.equals("/board/delete")) {
        bHandler.deleteBoard();

      } else if (command.equals("/history")) {
        printCommandHistory();

      } else if (command.equals("/history2")) {
        printCommandHistory2();

      } else if (command.equals("quit")) {
        System.out.println("bye!");
        break;

      } else {
        System.out.println("invalid command ...");
      }

      System.out.println(); // 결과 출력 후 빈 줄 출력
    }

    keyboard.close();
  }

  public static void printCommandHistory() {
    try {
      Stack<String> temp = stack.clone();
      while (!temp.empty()) {
        System.out.println(temp.pop());
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void printCommandHistory2() {
    try {
      Queue<String> temp = queue.clone();
      while (!temp.empty()) {
        System.out.println(temp.poll());
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  

  private static String prompt() {
    System.out.print("command >> ");
    return keyboard.nextLine().toLowerCase();
  }
}
