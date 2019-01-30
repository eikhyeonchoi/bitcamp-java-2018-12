package com.eomcs.lms;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;
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
  static Scanner keyboard = new Scanner(System.in);
  static Stack<String> commandHistory = new Stack<>();
  static ArrayDeque<String> commandHistory2 = new ArrayDeque<>();
  static ArrayList<Lesson> lessonList = new ArrayList<>();
  static ArrayList<Board> boardList = new ArrayList<>();
  static ArrayList<Member> memberList = new ArrayList<>();

  public static void main(String[] args) {
    loadLessonData();
    loadBoardData();
    loadMemberData();

    HashMap<String, Command> commandMap = new HashMap<>();

    commandMap.put("/board/add", new BoardAddCommand(keyboard, boardList));
    commandMap.put("/board/list", new BoardListCommand(keyboard, boardList));
    commandMap.put("/board/detail", new BoardDetailCommand(keyboard, boardList));
    commandMap.put("/board/update", new BoardUpdateCommand(keyboard, boardList));
    commandMap.put("/board/delete", new BoardDeleteCommand(keyboard, boardList));

    commandMap.put("/member/add", new MemberAddCommand(keyboard, memberList));
    commandMap.put("/member/list", new MemberListCommand(keyboard, memberList));
    commandMap.put("/member/detail", new MemberDetailCommand(keyboard, memberList));
    commandMap.put("/member/update", new MemberUpdateCommand(keyboard, memberList));
    commandMap.put("/member/delete", new MemberDeleteCommand(keyboard, memberList));

    commandMap.put("/lesson/add", new LessonAddCommand(keyboard, lessonList));
    commandMap.put("/lesson/list", new LessonListCommand(keyboard, lessonList));
    commandMap.put("/lesson/detail", new LessonDetailCommand(keyboard, lessonList));
    commandMap.put("/lesson/update", new LessonUpdateCommand(keyboard, lessonList));
    commandMap.put("/lesson/delete", new LessonDeleteCommand(keyboard, lessonList));


    while (true) {
      String command = prompt();

      // 사용자가 입력한 명령어를 푸시
      commandHistory.push(command);
      commandHistory2.offer(command);

      if (command.equals("quit")) {
        quit();
        break;

      } else if (command.equals("history")) {
        printCommandHistory(new Iterator<>() {
          int index = commandHistory.size() - 1;
          @Override
          public boolean hasNext() {
            return index >= 0;
          }
          @Override
          public String next() {
            return commandHistory.get(index--);
          }
        });

      } else if (command.equals("history2")) {
        printCommandHistory2();
      } else {
        Command commandHandler = commandMap.get(command);
        if (commandHandler == null)
          System.out.println("실행할 수 없는 명령입니다.");
        else {
          try {
            commandHandler.execute();
          } catch(Exception e) {
            System.out.println("작업중 오류 발생 : " + e.toString());
          }
        }

      }
      System.out.println(); // 결과 출력 후 빈 줄 출력
    }
    keyboard.close();
  }

  private static void printCommandHistory(Iterator<String> iter) {
    while(iter.hasNext()) {
      System.out.print(iter.next());
      System.out.println();
    }
  }

  private static void printCommandHistory2() {
    Queue<String> temp = (Queue<String>) ((ArrayDeque<String>) commandHistory2).clone();

    while (temp.size() > 0) {
      System.out.println(temp.poll());
    }
  }

  private static String prompt() {
    System.out.print("명령> ");
    return keyboard.nextLine().toLowerCase();
  }

  private static void quit() {
    saveLessonData();
    saveBoardData();
    saveMemberData();
    System.out.println("안녕!");
  }

  private static void loadLessonData() {
    try (FileReader in = new FileReader("lesson.csv");
        Scanner in2 = new Scanner(in);) {
      while(true) {
        lessonList.add(Lesson.valueOf(in2.nextLine()));
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      
    } catch (IOException e) {
      e.printStackTrace();
      
    } catch(NoSuchElementException e) {
      System.out.println("lesson data loading complete ...");
    }
  }

  private static void saveLessonData() {
    try (FileWriter out = new FileWriter("lesson.csv");) {
      for (Lesson lesson : lessonList) {
        out.write(String.format("%s,%s,%s,%s,%s,%d,%d\n"
            , lesson.getNo()
            , lesson.getTitle()
            , lesson.getContents()
            , lesson.getStartDate()
            , lesson.getEndDate()
            , lesson.getTotalHours()
            , lesson.getDayHours()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private static void loadBoardData() {
    try (FileReader in = new FileReader("board.csv");
        Scanner in2 = new Scanner(in);) {
      while(true) {
        boardList.add(Board.valueOf(in2.nextLine()));
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      
    } catch (IOException e) {
      e.printStackTrace();
      
    } catch(NoSuchElementException e) {
      System.out.println("board data loading complete ...");
    }
  }
  
  private static void saveBoardData() {
    try (FileWriter out = new FileWriter("board.csv");) {
      for (Board board : boardList) {
        out.write(String.format("%d,%s,%s,%d\n"
            , board.getNo()
            , board.getContents()
            , board.getCreatedDate()
            , board.getViewCount()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  private static void loadMemberData() {
    try (FileReader in = new FileReader("member.csv");
        Scanner in2 = new Scanner(in);) {
      while(true) {
        memberList.add(Member.valueOf(in2.nextLine()));
      }
      
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      
    } catch (IOException e) {
      e.printStackTrace();
      
    } catch(NoSuchElementException e) {
      System.out.println("member data loading complete ...");
    }
  }
  
  private static void saveMemberData() {
    try (FileWriter out = new FileWriter("member.csv");) {
      for (Member member : memberList) {
        out.write(String.format("%d,%s,%s,%s,%s,%s,%s\n"
            , member.getNo()
            , member.getName()
            , member.getEmail()
            , member.getPassword()
            , member.getPhoto()
            , member.getTel()
            , member.getRegisteredDate()));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }










}
