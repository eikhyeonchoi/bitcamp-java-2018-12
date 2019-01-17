package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {
  public Scanner keyboard;
  LessonList lessonList = new LessonList();
  Lesson[] lessons;
  Lesson lesson;
  
  
  public LessonHandler(Scanner key) {
    this.keyboard = key;
  }
  
  public void listLesson() {
    lessons = lessonList.toArray();
    for (Lesson l : lessons) {
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          l.getNo(), l.getTitle(), l.getStartDate(), 
          l.getEndDate(), l.getTotalHours());
    }
  }

  public void addLesson() {
    lesson = new Lesson();
    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("수업명? ");
    lesson.setTitle(this.keyboard.nextLine()); 
    System.out.print("설명? ");
    lesson.setContents(this.keyboard.nextLine()); 
    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(this.keyboard.nextLine())); 
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(this.keyboard.nextLine()));
    System.out.print("총수업시간? ");
    lesson.setTotalHours(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("일수업시간? ");
    lesson.setDayHours(Integer.parseInt(this.keyboard.nextLine()));
    lessonList.add(lesson);
  }
  
  
}
