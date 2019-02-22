package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.LessonDao;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {
  LessonDao lessonDao;

  public LessonUpdateCommand(LessonDao lessonDao) {
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
      if(lesson == null) {
        out.println("해당 수업은 존재하지 않습니다");
        return;
        
      }
      
      Lesson temp = lesson.clone();
      
      out.printf("제목(%s) : \n", temp.getTitle());
      out.println("!{}!");
      out.flush();
      String input = in.readLine();
      if(input.length() > 0)
        temp.setTitle(input);

      out.printf("내용(%s) : \n", temp.getContents());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setContents(input);

      out.printf("시작일(%s) : \n", temp.getStartDate());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setStartDate(Date.valueOf(input));

      out.printf("종료일(%s) : \n", temp.getEndDate());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setEndDate(Date.valueOf(input));

      out.printf("총 수업 시간(%d) : \n", temp.getTotalHours() );
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      out.printf("일 수업 시간(%d) : \n", temp.getDayHours());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      lessonDao.update(temp);
      
      out.println("갱신 완료");
    } catch (Exception e) {
      out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
