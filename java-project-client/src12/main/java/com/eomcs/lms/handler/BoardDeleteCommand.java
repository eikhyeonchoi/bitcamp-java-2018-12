package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardDeleteCommand implements Command {

  Scanner keyboard;

  public BoardDeleteCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      BoardAgent.delete(no, in, out);
      System.out.println("데이터를 삭제했습니다");
      
    } catch (Exception e) {
      System.out.printf("삭제 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
