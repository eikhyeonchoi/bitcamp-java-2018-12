package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    try {
      out.writeUTF("/lesson/update"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");
      
      Lesson tempLesson = new Lesson();
      System.out.print("번호 : ");
      tempLesson.setNo(Integer.parseInt(keyboard.nextLine()));
      System.out.print("제목 : ");
      tempLesson.setTitle(keyboard.nextLine());

      out.writeObject(tempLesson); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
      
      System.out.println("수업 갱신 완료");
    } catch (Exception e) {
      System.out.printf("수업 갱신 오류 : %s\n", e.getMessage());
    }
  }

}
