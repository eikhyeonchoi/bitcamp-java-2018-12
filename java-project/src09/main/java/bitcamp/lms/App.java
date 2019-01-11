package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.Lesson;

public class App {
  final static int L = 10;
  static int lessonCount = 0;
  static int memberCount = 0;
  static int boardCount = 0;
  static Lesson[] les = new Lesson[L];
  static Member[] mems = new Member[L];
  static Board[] bods = new Board[L];
  static Scanner key = new Scanner(System.in);

  public static void main(String[] args) {

    finalEnding: while (true) {
      
      
      System.out.print("명령>");
      String ans = key.nextLine();
      
      
      if (ans.equals("quit")) {
        System.out.println("안녕!!\n....\n....");
        break finalEnding;
      }

      if (ans.equals("/lesson/add")) {
        addLesson();
      } else if (ans.equals("/lesson/list")) {
        listLesson();
      } else if (ans.equals("/member/add")) {
        addMember();
      } else if (ans.equals("/member/list")) {
        listMember();
      } else if (ans.equals("/board/add")) {
        addBoard();
      } else if (ans.equals("/board/list")){
        listBoard();
      } else  {
        System.out.println("실행할 수 없는 명령입니다.");
        System.out.println();
        continue;
      }
      System.out.println();
    }

  }

  
  static void addLesson() {
    for (int i = 0; i < L; i++) {
      lessonCount++;
      Lesson tempLesson = new Lesson();
      System.out.print("번호 : ");
      tempLesson.no = Integer.parseInt(key.nextLine());
      System.out.print("수업명 : ");
      tempLesson.title = key.nextLine();
      System.out.print("수업내용 : ");
      tempLesson.contents = key.nextLine();
      System.out.print("시작일 : ");
      tempLesson.startDate = Date.valueOf(key.nextLine());
      System.out.print("종료일 : ");
      tempLesson.endDate = Date.valueOf(key.nextLine());
      System.out.print("총 수업 시간 : ");
      tempLesson.totalHours = Integer.parseInt(key.nextLine());
      System.out.print("일 수업 시간 : ");
      tempLesson.dayHours = Integer.parseInt(key.nextLine());
      System.out.println("저장하였습니다");
      les[i] = tempLesson;
      break;
    }
    return;
  }

  static void addMember() {
    Date signUp = new Date(System.currentTimeMillis());
    for (int i = 0; i < L; i++) {
      memberCount++;
      Member tempMember = new Member();
      System.out.print("번호 : ");
      tempMember.no = Integer.parseInt(key.nextLine());
      System.out.print("이름 : ");
      tempMember.name = key.nextLine();
      System.out.print("이메일 : ");
      tempMember.email = key.nextLine();
      System.out.print("암호 : ");
      tempMember.password = key.nextLine();
      System.out.print("사진 : ");
      tempMember.photo = key.nextLine();
      System.out.print("전화 : ");
      tempMember.tel = key.nextLine();
      tempMember.registeredDate = signUp;
      System.out.println("저장하였습니다");
      mems[i] = tempMember;
      break;
    }
    return;
  }

  static void addBoard() {
    for (int i = 0; i < L; i++) {
      boardCount++;
      Board tempBoard = new Board();
      System.out.print("번호 : ");
      tempBoard.no = Integer.parseInt(key.nextLine());
      System.out.print("내용 : ");
      tempBoard.contents = key.nextLine();
      System.out.println("저장하였습니다");
      bods[i] = tempBoard;
      break;
    }
    return;
  }

  static void listLesson() {
    if (lessonCount == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < lessonCount; i++) {
      System.out.printf("%1d, %-8s , %9s ~ %9s, %4d\n"
          , les[i].no, les[i].title, les[i].startDate,
          les[i].endDate, les[i].totalHours);
    }
    return;
  }

  static void listMember() {
    if (memberCount == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < memberCount; i++) {
      System.out.printf("%1d, %-5s, %-10s, %-5s, %s\n", mems[i].no, mems[i].name, mems[i].email,
          mems[i].tel, mems[i].registeredDate);
    }
    return;
  }

  static void listBoard() {
    if (boardCount == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < boardCount; i++) {
      System.out.printf("%1d, %s\n", bods[i].no, bods[i].contents);
    }
    return;
  }

}
