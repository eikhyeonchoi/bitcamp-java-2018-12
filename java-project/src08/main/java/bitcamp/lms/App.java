package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;
import bitcamp.lms.Lesson;

public class App {
  static int lessonCount = 0;
  static int memberCount = 0;
  static int boardCount = 0;

  public static void main(String[] args) {
    final int L = 10;
    Scanner key = new Scanner(System.in);
    Lesson[] les = new Lesson[L];
    Member[] mems = new Member[L];
    Board[] bods = new Board[L];        boardCount++;


    finalEnding: while (true) {
      System.out.print("명령>");
      String ans = key.nextLine();
      if (ans.equals("quit")) {
        System.out.println("안녕!!\n....\n....");
        break finalEnding;
      }

      if (ans.equals("/lesson/add")) {
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
        les[lessonCount] = tempLesson;
        lessonCount++;
      } else if (ans.equals("/lesson/list")) {
        if (lessonCount == 0) {
          System.out.println("저장된 정보가 없습니다");
          continue;
        }
        for (int i = 0; i < lessonCount; i++) {
          System.out.printf("%1d, %-10s , %9s ~ %9s, %4d\n", les[i].no, les[i].title,
              les[i].startDate, les[i].endDate, les[i].totalHours);
        }
      } else if (ans.equals("/member/add")) {
        Date signUp = new Date(System.currentTimeMillis());
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
        mems[memberCount] = tempMember;
        memberCount++;
      } else if (ans.equals("/member/list")) {
        if (memberCount == 0) {
          System.out.println("저장된 정보가 없습니다");
          continue;
        }
        for (int i = 0; i < memberCount; i++) {
          System.out.printf("%1d, %-5s , %-15s %-10s, %-9s\n", mems[i].no, mems[i].name,
              mems[i].email, mems[i].tel, mems[i].registeredDate);
        }

      } else if (ans.equals("/board/add")) {
        Board tempBoard = new Board();
        System.out.print("번호 : ");
        tempBoard.no = Integer.parseInt(key.nextLine());
        System.out.print("내용 : ");
        tempBoard.contents = key.nextLine();
        System.out.println("저장하였습니다");
        bods[boardCount] = tempBoard;
        boardCount++;
      } else if (ans.equals("/board/list")) {
        if (boardCount == 0) {
          System.out.println("저장된 정보가 없습니다");
          continue;
        }
        for (int i = 0; i < boardCount; i++) {
          System.out.printf("%1d, %-15s\n", bods[i].no, bods[i].contents);
        }

      } else {
        System.out.println("실행할 수 없는 명령입니다.");
        continue;
      }
      System.out.println();
    }


  }
}
