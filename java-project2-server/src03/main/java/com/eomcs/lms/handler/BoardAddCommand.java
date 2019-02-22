package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardAddCommand implements Command {

  BoardDao boardDao; // 서버의 BoardDaoImpl 객체를 대행하는 프록시이다

  public BoardAddCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      Board board = new Board();

      out.println("내용? ");
      out.println("!{}!");
      out.flush();
      board.setContents(in.readLine());

      boardDao.insert(board);
      out.println("데이터 저장성공");
      
    } catch (Exception e) {
      out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()


}
