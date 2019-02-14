package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {


  LessonAgent lessonAgent;
  Scanner keyboard;

  public LessonUpdateCommand(Scanner keyboard, LessonAgent lessonAgent) {
    this.keyboard = keyboard;
    this.lessonAgent = lessonAgent;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Lesson lesson = lessonAgent.get(no);
      ///////////////////////////////////////////////////////////////
      Lesson temp = lesson.clone();

      System.out.printf("제목(%s) : ", temp.getTitle());
      String input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTitle(input);

      System.out.printf("내용(%s) : ", temp.getContents());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setContents(input);

      System.out.printf("시작일(%s) : ", temp.getStartDate());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setStartDate(Date.valueOf(input));

      System.out.printf("종료일(%s) : ", temp.getEndDate());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setEndDate(Date.valueOf(input));

      System.out.printf("총 수업 시간(%d) : ", temp.getTotalHours() );
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      System.out.printf("일 수업 시간(%d) : ", temp.getDayHours());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setDayHours(Integer.parseInt(input));

      lessonAgent.update(temp);
      
      System.out.println("갱신 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
