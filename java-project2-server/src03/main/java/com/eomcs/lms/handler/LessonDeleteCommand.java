package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;

public class LessonDeleteCommand implements Command {

  LessonDao lessonDao;

  public LessonDeleteCommand(LessonDao lessonDao) {
    this.lessonDao = lessonDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

      if(lessonDao.delete(no) == 0) {
        out.println("해당 수업이 존재하지 않습니다");
        return;
      }
      out.println("데이터를 삭제했습니다.");

    } catch(Exception e) {
      out.printf("삭제 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
