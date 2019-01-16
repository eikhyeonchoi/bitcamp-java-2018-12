package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardList {
  
  public Scanner key;
  int LENGTH;
  Board[] boards;
  int boardIdx = 0;
  
  public BoardList() {
    boards = new Board[10];
  }
  
  public BoardList(int length) {
    this.LENGTH = length;
    boards = new Board[LENGTH];
  }
  
  public Board[] toArray() {
    return Arrays.copyOf(boards,boardIdx);
  }
  
  public void add(Board b) {
    b = new Board();
    System.out.print("번호 : ");
    b.setNo(Integer.parseInt(this.key.nextLine()));
    System.out.print("내용 : ");
    b.setContents(this.key.nextLine());
    b.setCreatedDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    boards[boardIdx] = b;
    boardIdx++;
    System.out.println("저장하였습니다");
  }
  
  
}
