package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {
  LessonDao lessonDao;
  Scanner keyboard;

  public LessonDetailCommand(Scanner keyboard, LessonDao lessonDao) {
    this.keyboard = keyboard;
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Lesson lesson = lessonDao.findByNo(no);
      
      System.out.printf("제목: %s\n", lesson.getTitle());
      System.out.printf("내용: %s\n", lesson.getContents());
      System.out.printf("시작일: %s\n", lesson.getStartDate());
      System.out.printf("종료일: %s\n", lesson.getEndDate());
      System.out.printf("총 수업 시간: %d\n", lesson.getTotalHours());
      System.out.printf("일 수업 시간: %d\n", lesson.getDayHours());

    }catch (Exception e) {
      System.out.printf("출력 오류 : %s\n", e.getMessage());
    }
  } // execute()
}
