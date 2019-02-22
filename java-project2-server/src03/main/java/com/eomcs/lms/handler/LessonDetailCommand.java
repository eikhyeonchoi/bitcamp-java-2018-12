package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonDetailCommand implements Command {
  LessonDao lessonDao;

  public LessonDetailCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

      Lesson lesson = lessonDao.findByNo(no);
      if (lesson == null) {
        out.println("해당 수업이 존재하지 않습니다");
        return;
      }
      out.printf("제목: %s\n", lesson.getTitle());
      out.printf("내용: %s\n", lesson.getContents());
      out.printf("시작일: %s\n", lesson.getStartDate());
      out.printf("종료일: %s\n", lesson.getEndDate());
      out.printf("총 수업 시간: %d\n", lesson.getTotalHours());
      out.printf("일 수업 시간: %d\n", lesson.getDayHours());

    }catch (Exception e) {
      out.printf("출력 오류 : %s\n", e.getMessage());
    }
  } // execute()
}
