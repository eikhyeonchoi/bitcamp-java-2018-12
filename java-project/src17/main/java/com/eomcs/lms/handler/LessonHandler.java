package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonHandler {
  public Scanner keyboard;
  ArrayList arrayList = new ArrayList();
  Object[] objects;
  Lesson lesson;
  
  
  public LessonHandler(Scanner key) {
    this.keyboard = key;
  }
  
  public void listLesson() {
    objects = arrayList.toArray();
    for (Object tempObject : objects) {
      Lesson tempLesson = (Lesson)tempObject;
      System.out.printf("%3d, %-15s, %10s ~ %10s, %4d\n", 
          tempLesson.getNo(), tempLesson.getTitle(), tempLesson.getStartDate(), 
          tempLesson.getEndDate(), tempLesson.getTotalHours());
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
    arrayList.add(lesson);
  }
  
  
}
