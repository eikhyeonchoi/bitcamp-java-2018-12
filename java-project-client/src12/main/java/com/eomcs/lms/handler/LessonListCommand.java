package com.eomcs.lms.handler;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  Scanner keyboard;

  public LessonListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      List<Lesson> lessons = LessonAgent.list(in, out);
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
