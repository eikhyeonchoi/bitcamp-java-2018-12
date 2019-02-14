package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.LessonAgent;
import com.eomcs.lms.domain.Lesson;

public class LessonAddCommand implements Command {

  Scanner keyboard;

  public LessonAddCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    Lesson lesson = new Lesson();

    System.out.print("번호? ");
    lesson.setNo(Integer.parseInt(keyboard.nextLine()));
    System.out.print("제목? ");
    lesson.setTitle(keyboard.nextLine());
    System.out.print("내용? ");
    lesson.setContents(keyboard.nextLine());
    System.out.print("시작일? ");
    lesson.setStartDate(Date.valueOf(keyboard.nextLine()));
    System.out.print("종료일? ");
    lesson.setEndDate(Date.valueOf(keyboard.nextLine()));
    System.out.print("총 수업 시간? ");
    lesson.setTotalHours(Integer.parseInt(keyboard.nextLine()));
    System.out.print("일 수업 시간? ");
    lesson.setDayHours(Integer.parseInt(keyboard.nextLine()));

    try {
      LessonAgent.add(lesson, in, out);
      System.out.println("데이터 저장 성공");
    } catch (Exception e) {
      System.out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()
}
