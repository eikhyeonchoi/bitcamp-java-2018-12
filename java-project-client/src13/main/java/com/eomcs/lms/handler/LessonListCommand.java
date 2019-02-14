package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonAgent lessonAgent;
  Scanner keyboard;

  public LessonListCommand(Scanner keyboard, LessonAgent lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }
  @Override
  public void execute() {
    try {
      List<Lesson> lessons = lessonAgent.list();
      for (Lesson lesson : lessons) {
        System.out.printf("%3d, %-20s, %s ,%s ,%s, %s, %s\n", 
            lesson.getNo(), lesson.getTitle(), lesson.getContents()
            , lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours()
            , lesson.getDayHours());
      } // for
    } catch (Exception e) {
      System.out.printf("출력 오류 : %s\n", e.getMessage());
    }

  } // execute()

}
