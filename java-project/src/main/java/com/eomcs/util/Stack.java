package com.eomcs.util;

public class Stack<E> implements Cloneable {
  public static final int DEFAULT_SIZE = 5;
  Object[] list;
  int size = 0;
  
  public Stack() {
    list = new Object[DEFAULT_SIZE];
  }
  
  public void push(E value) {
    // 맨 마지막에 추가
    // 배열의 크기가 작다면 확장해야한다
    if (size >= list.length) {package com.eomcs.lms;

import java.util.Scanner;

public class App {

  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> stack = new Stack<>();

  public static void main(String[] args) {
    
    // LessonHandler temp = new LessonHandler(); copile error
    LessonHandler lHandler = new LessonHandler(keyboard);
    MemberHandler mHandler = new MemberHandler(keyboard);
    BoardHandler bHandler = new BoardHandler(keyboard);

    while (true) {
      String command = prompt();
      stack.push(command);

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
    while (!stack.empty()) {
    System.out.println(stack.pop());
    }
    
  }

  private static String prompt() {
    System.out.print("command >> ");
    return keyboard.nextLine().toLowerCase();
  }
}

      int newSize = list.length + (list.length >> 1);
      Object[] temp = new Object[newSize];
      for (int k = 0; k < size; k++) {
        temp[k] = list[k];
      }
      list = temp;
    }
    list[size] = value;
    size ++;
  }
  public E pop() {
    // 맨 마지막 값을 꺼내 return
    // 꺼낸 값을 배열에서 제거되어야 한다
    if (size == 0) return null;
    E old = (E) list[size - 1];
    size --;
    return old;
    // return list[--size];
  }
  
  public boolean empty() {
    return size == 0;
  }
  
  public int size() {
    return size;
  }
  
  public void print() {
    for(int k =  0; k < size; k++) {
      System.out.printf("%d\n", list[k]);
    }
  }
  @Override
  public static Stack<E> clone() throws CloneNotSupportedException {
    return (Stack<E>) super.clone();
  }
  
  
  
}
