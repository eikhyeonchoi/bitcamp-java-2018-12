package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.BoardAgent;
import com.eomcs.lms.domain.Board;

public class BoardListCommand implements Command {

  BoardAgent boardAgent;
  Scanner keyboard;

  public BoardListCommand(Scanner keyboard, BoardAgent boardAgent) {
    this.keyboard = keyboard;
    this.boardAgent = boardAgent;
  }


  @Override
  public void execute() {
    try {
      List<Board> boards = boardAgent.list();
      for (Board board : boards) {
        System.out.printf("%3d, %-20s, %s, %d\n", 
            board.getNo(), board.getContents(), 
            board.getCreatedDate(), board.getViewCount());
      } // for
    } catch (Exception e) {
      System.out.printf("목록 출력 오류 : %s\n", e.getMessage());
    }

  } // execute()

}
