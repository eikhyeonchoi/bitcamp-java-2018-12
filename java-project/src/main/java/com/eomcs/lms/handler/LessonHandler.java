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
    lessonList.keyboard = keyboard;
    lessonList.add(lesson);
  }
}
