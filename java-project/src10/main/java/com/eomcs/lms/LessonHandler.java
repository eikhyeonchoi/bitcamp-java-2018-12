package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class LessonHandler {
  
  final static int L = 10;
  static Lesson[] lessons = new Lesson[L];
  static int lessonIdx = 0;
  static Scanner key = new Scanner(System.in);
  
  static void addLesson() {
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
      lessons[lessonIdx] = tempLesson;
      lessonIdx++;
    return;
  }
  

  static void listLesson() {
    if (lessonIdx == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < lessonIdx; i++) {
      System.out.printf("%1d, %-8s , %9s ~ %9s, %4d\n"
          , lessons[i].no, lessons[i].title, lessons[i].startDate,
          lessons[i].endDate, lessons[i].totalHours);
    }
    return;
  }

}
