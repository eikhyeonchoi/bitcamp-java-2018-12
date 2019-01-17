package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  BoardList boardList = new BoardList();
  public Scanner keyboard;
  Board[] boards;
  Board b;
  
  public BoardHandler(Scanner key) {
    this.keyboard = key;
  }

  public void listBoard() {
    boards = boardList.toArray();
    for (Board b : boards) {
      System.out.printf("%3d, %-10s, %s, %d\n"
          ,b.getNo(), b.getContents(), b.getCreatedDate(), b.getViewCount());
    }
  }

  public void addBoard() {
    b = new Board();
    System.out.print("번호 : ");
    b.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("내용 : ");
    b.setContents(this.keyboard.nextLine());
    b.setCreatedDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    boardList.add(b);
  }
}
