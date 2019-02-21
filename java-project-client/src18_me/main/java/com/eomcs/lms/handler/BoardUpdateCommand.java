package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  BoardDao boardDao;
  Scanner keyboard;

  public BoardUpdateCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }


  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Board board = boardDao.findByNo(no);
      if(board == null) {
        System.out.println("해당 게시물을 찾을 수 없습니다");
        return;
      }
      
      Board temp = board.clone();

      System.out.printf("내용(%s) :", temp.getContents());
      String input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setContents(input);

      if (boardDao.update(temp) == 0) {
        System.out.println("update를 실행하지 못했습니다");
        return ;
      }
      
      System.out.println("update 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
