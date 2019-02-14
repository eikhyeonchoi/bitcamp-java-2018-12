package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Lesson;

public class LessonUpdateCommand implements Command {

  Scanner keyboard;
  List<Lesson> list;

  public LessonUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/lesson/detail"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeInt(no); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
      Lesson lesson = (Lesson) in.readObject();
      ///////////////////////////////////////////////////////////////
      Lesson temp = lesson.clone();

      System.out.printf("제목 :");
      String input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTitle(input);

      System.out.print("내용? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setContents(input);

      System.out.print("시작일? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setStartDate(Date.valueOf(input));

      System.out.print("종료일? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setEndDate(Date.valueOf(input));

      System.out.print("총 수업 시간? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTotalHours(Integer.parseInt(input));

      System.out.print("일 수업 시간? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setDayHours(Integer.parseInt(input));



      out.writeUTF("/lesson/update"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(temp); out.flush();

      status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");

      System.out.println("갱신 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
