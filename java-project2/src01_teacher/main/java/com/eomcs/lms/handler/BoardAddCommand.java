package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {

  Scanner keyboard;
  BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시이다
  
  public BoardAddCommand(Scanner keyboard, BoardDao boardDao) {
    this.keyboard = keyboard;
    this.boardDao = boardDao;
  }

  @Override
  public void execute() {
    Board board = new Board();
    
    System.out.print("내용? ");
    board.setContents(keyboard.nextLine());

    try {
      boardDao.insert(board);
      System.out.println("데이터 저장성공");
    } catch (Exception e) {
      System.out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()
  
  
}
