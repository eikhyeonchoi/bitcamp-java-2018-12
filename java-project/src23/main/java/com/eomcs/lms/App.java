package com.eomcs.lms;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.handler.BoardHandler;
import com.eomcs.lms.handler.LessonHandler;
import com.eomcs.lms.handler.MemberHandler;
import com.eomcs.util.ArrayList;
import com.eomcs.util.LinkedList;
import com.eomcs.util.Queue;
import com.eomcs.util.Stack;

public class App {
  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> stack = new Stack<>();
  static Queue<String> queue = new Queue<>();

  public static void main(String[] args) {

    // 핸들러가 필요로 하는 의존 객체를 이 클래스에서 만들어 주입해준다
    // ==> 의존 객체 주입 (dependancy injection = DI)
    LessonHandler lHandler = new LessonHandler(keyboard, new ArrayList<Lesson>());
    MemberHandler mHandler = new MemberHandler(keyboard, new ArrayList<Member>());
    BoardHandler bHandler = new BoardHandler(keyboard, new LinkedList<Board>());

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
      int count = 0;
      while (temp.empty() == false) {
        System.out.println(temp.pop());
        if (++count % 5 == 0) {
          System.out.print("continue? :");
          String input  = keyboard.nextLine();
          if(input.equalsIgnoreCase("q"))
            break;
        }
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void printCommandHistory2() {
    try {
      Queue<String> temp = queue.clone();
      int count = 0;
      while (!temp.empty()) {
        System.out.println(temp.poll());
        if (++count % 5 == 0) {
          System.out.print("continue? :");
          String input  = keyboard.nextLine();
          if(input.equalsIgnoreCase("q"))
            break;
        }
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
