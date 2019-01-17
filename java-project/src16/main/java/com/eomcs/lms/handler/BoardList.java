package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardList {
  Board[] boards;
  int boardIdx = 0;
  
  public BoardList() {
    boards = new Board[10];
  }
  
  public BoardList(int length) {
    if (length < 10) {
      boards = new Board[10];
    } else {
      boards = new Board[length];
    }
  }
  
  public Board[] toArray() {
    /* LENGTH가 초기화 되어있을 경우임
    Arrays.copyOf() 와 동일
    Board[] a = new Board[LENGTH];  
    for (int i = 0; i < boardIdx; i++) {
      a[i] = this.boards[i];
    }
    return a;
    */
    return Arrays.copyOf(boards,boardIdx);
  }
  
  public void add(Board b) {
    if (boardIdx >= boards.length) {
      boards = Arrays.copyOf(boards, boards.length + (boards.length >> 1));
      System.out.println("배열을 증가했습니다 배열 length : " + boards.length);
    }
    boards[boardIdx] = b;
    boardIdx++;
  }
  
}
