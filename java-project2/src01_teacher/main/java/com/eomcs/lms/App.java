package com.eomcs.lms;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.dao.mariadb.BoardDaoImpl;
import com.eomcs.lms.dao.mariadb.LessonDaoImpl;
import com.eomcs.lms.dao.mariadb.MemberDaoImpl;
import com.eomcs.lms.handler.BoardAddCommand;
import com.eomcs.lms.handler.BoardDeleteCommand;
import com.eomcs.lms.handler.BoardDetailCommand;
import com.eomcs.lms.handler.BoardListCommand;
import com.eomcs.lms.handler.BoardUpdateCommand;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.handler.LessonAddCommand;
import com.eomcs.lms.handler.LessonDeleteCommand;
import com.eomcs.lms.handler.LessonDetailCommand;
import com.eomcs.lms.handler.LessonListCommand;
import com.eomcs.lms.handler.LessonUpdateCommand;
import com.eomcs.lms.handler.MemberAddCommand;
import com.eomcs.lms.handler.MemberDeleteCommand;
import com.eomcs.lms.handler.MemberDetailCommand;
import com.eomcs.lms.handler.MemberListCommand;
import com.eomcs.lms.handler.MemberUpdateCommand;

public class App {

  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();

  @SuppressWarnings("unchecked")
  public void service() {

    Map<String,Command> commandMap = new HashMap<>();

    LessonDaoImpl lessonDao = new LessonDaoImpl();
    commandMap.put("/lesson/add", new LessonAddCommand(keyboard,lessonDao));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard,lessonDao));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard,lessonDao));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard,lessonDao));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard,lessonDao));

    MemberDaoImpl memberDao = new MemberDaoImpl();
    commandMap.put("/member/add", new MemberAddCommand(keyboard,memberDao));
    commandMap.put("/member/list", new MemberListCommand(keyboard,memberDao));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard,memberDao));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard,memberDao));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard,memberDao));

    BoardDaoImpl boardDao = new BoardDaoImpl();
    commandMap.put("/board/add", new BoardAddCommand(keyboard,boardDao));
    commandMap.put("/board/list", new BoardListCommand(keyboard,boardDao));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard,boardDao));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard,boardDao));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard,boardDao));

    while (true) {
      String command = prompt();

      commandHistory.push(command);
      commandHistory2.offer(command);
      if (command.equals("quit")) {
        System.out.println("종료합니다");
        break;

      } else if (command.equals("history")) {
        printCommandHistory();
        continue;

      } else if (command.equals("history2")) {
        printCommandHistory2();
        continue;
      } 

      Command commandHandler = commandMap.get(command);
      if (commandHandler == null) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue; 
      }

      // stateful을 stateless로 전환할 때 주의점
      // ==> 가능한 서버에 요청하는 시점에 서버와 연결하라
      // ==> 이 클래스에서 서버와 연결하지 않고
      // Agent에 맡김
      try{
        commandHandler.execute();
        System.out.println(); 

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }
      
    } // while
    
    keyboard.close();
    
  } // service()

  
  @SuppressWarnings("unchecked")
  private void printCommandHistory() {
    Stack<String> temp = (Stack<String>) commandHistory.clone();

    while (temp.size() > 0) {
      System.out.println(temp.pop());
    }
  }

  
  @SuppressWarnings("unchecked")
  private void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((LinkedList<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  
  private String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }


  public static void main(String[] args) {
    App app = new App();

    app.service();
    
  } // main()
  
} // end of class
