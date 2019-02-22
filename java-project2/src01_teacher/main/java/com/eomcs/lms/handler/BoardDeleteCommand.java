package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;

public class BoardDeleteCommand implements Command {

  BoardDao boardDao;
  Scanner keyboard;

  public BoardDeleteCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }


  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      if (boardDao.delete(no) == 0) {
        System.out.println("해당 번호 게시물이 존재하지 않습니다");
      } else {
        System.out.println("데이터를 삭제했습니다");
      }
      
    } catch (Exception e) {
      System.out.printf("삭제 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
