package com.eomcs.lms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.handler.Command;
import com.eomcs.lms.listener.ApplicationContextListener;
import com.eomcs.lms.listener.ApplicationInitializer;

public class App {
  Scanner keyboard = new Scanner(System.in);
  Stack<String> commandHistory = new Stack<>();
  Queue<String> commandHistory2 = new LinkedList<>();
  
  ArrayList<ApplicationContextListener> contextList = new ArrayList<>();
  HashMap<String,Object> commandMap = new HashMap<>();
  
  public void addApplicationContext(ApplicationContextListener obj) {
    contextList.add(obj);
  }

  
  public void service() throws Exception {
    commandMap.put("keyboard", keyboard);
    
    for(ApplicationContextListener obj : contextList) {
      obj.init(commandMap);
    }
    

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

      Command commandHandler = (Command) commandMap.get(command);
      if (commandHandler == null) {
        System.out.println("실행할 수 없는 명령입니다.");
        continue; 
      }

      try{
        commandHandler.execute();
        System.out.println(); 

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }
    } // while
    
    keyboard.close();
    for(ApplicationContextListener obj : contextList) {
      obj.destroy(commandMap);
    }
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

  public static void main(String[] args) throws Exception {
    App app = new App();

    app.addApplicationContext(new ApplicationInitializer());
    
    app.service();
  } // main()
  
} // end of class
