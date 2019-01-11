package src08Tosrc10.handler;

import java.sql.Date;
import java.util.Scanner;
import src08Tosrc10.domain.Lesson;

public class LessonHandler {
  public static final int LEN = 10;
  public static int lidx = 0;
  public static Lesson[] lessons = new Lesson[LEN];
  public static Scanner key;
  
  public static void listLesson() {
    if (lidx == 0) {
      System.out.println("정보가 없습니다");
      return;
    }
    System.out.printf("%3s, %5s, %9s ~ %9s, %s\n", "번호", "수업명", "시작일", "종료일", "총수업시간");
    for (int k = 0; k < lidx; k++) {
      System.out.printf("%3d, %5s, %9s ~ %9s, %d\n", lessons[k].num, lessons[k].title,
          lessons[k].stDate, lessons[k].edDate, lessons[k].tot);
    }
  }
  
  public static void addLesson() {
    Lesson tempLesson = new Lesson();
    System.out.print("번호 : ");
    tempLesson.num = Integer.parseInt(key.nextLine());
    System.out.print("수업명 : ");
    tempLesson.title = key.nextLine();
    System.out.print("내용 : ");
    tempLesson.contents = key.nextLine();
    System.out.print("시작일 : ");
    tempLesson.stDate = Date.valueOf(key.nextLine());
    System.out.print("종료일 : ");
    tempLesson.edDate = Date.valueOf(key.nextLine());
    System.out.print("총 수업시간 : ");
    tempLesson.tot = Integer.parseInt(key.nextLine());
    System.out.print("일 수업시간 : ");
    tempLesson.day = Integer.parseInt(key.nextLine());
    lessons[lidx] = tempLesson;
    lidx++;
    System.out.println("저장되었습니다");
  }
}
