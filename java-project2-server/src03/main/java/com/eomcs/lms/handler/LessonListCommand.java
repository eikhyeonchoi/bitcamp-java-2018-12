package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonListCommand implements Command {

  LessonDao lessonDao;

  public LessonListCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      List<Lesson> lessons = lessonDao.findAll();
      for (Lesson lesson : lessons) {
        out.printf("%3d, %-20s, %s ,%s ,%s, %s, %s\n", 
            lesson.getNo(), lesson.getTitle(), lesson.getContents()
            , lesson.getStartDate(), lesson.getEndDate(), lesson.getTotalHours()
            , lesson.getDayHours());
      } // for
    } catch (Exception e) {
      out.printf("출력 오류 : %s\n", e.getMessage());
    }

  } // execute()

}
