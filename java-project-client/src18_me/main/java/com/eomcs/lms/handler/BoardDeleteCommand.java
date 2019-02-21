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
        System.out.println("해당 게시물을 찾을 수 없습니다");
        return;
      }
      
      System.out.println("delete 완료");
      
    } catch (Exception e) {
      System.out.printf("삭제 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
