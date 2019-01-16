package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  BoardList boardList = new BoardList();
  // 기본생성자는 배열 10개 생성함
  // BoardList boardList = new BoardList();
  // 생성자 파리미터의 int 주면 그만큼 배열생성함
  
  public Scanner keyboard;
  Board[] boards;
  Board b;
  
  public BoardHandler(Scanner key) {
    this.keyboard = key;
  }

  public void listBoard() {
    boards = boardList.toArray();
    /*
    for (int j = 0; j < boards.length; j++) {
      System.out.printf("%3d, %-10s, %s, %d\n", 
          boards[j].getNo(), boards[j].getContents(),
          boards[j].getCreatedDate(), boards[j].getViewCount());
    }
    */
    for (Board b : boards) {
      System.out.printf("%3d, %-10s, %s, %d\n"
          ,b.getNo(), b.getContents(), b.getCreatedDate(), b.getViewCount());
    }
  }

  public void addBoard() {
    boardList.key = keyboard;
    boardList.add(b);
  }

}
