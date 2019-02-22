package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.BoardDao;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  BoardDao boardDao;

  public BoardUpdateCommand(BoardDao boardDao) {
    this.boardDao = boardDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {

    try {
      Board board = new Board();
      
      out.println("번호? ");
      out.println("!{}!");
      out.flush();
      board.setNo(Integer.parseInt(in.readLine()));

      out.println("내용 ?");
      out.println("!{}!");
      out.flush();
      board.setContents(in.readLine());

      if (boardDao.update(board) == 0) {
        out.println("해당 게시물은 없습니다");
        return;
      }

      out.println("갱신 완료");
      
    } catch (Exception e) {
      out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
