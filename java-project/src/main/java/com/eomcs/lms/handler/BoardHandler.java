package com.eomcs.lms.handler;

import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardHandler {
  
  public static Scanner key;
  final static int L = 10;
  
  static Board[] boards = new Board[L];
  static int boardIdx = 0;
  
  public static void addBoard() {
      Board tempBoard = new Board();
      System.out.print("번호 : ");
      tempBoard.no = Integer.parseInt(key.nextLine());
      System.out.print("내용 : ");
      tempBoard.contents = key.nextLine();
      System.out.println("저장하였습니다");
      boards[boardIdx] = tempBoard;
      boardIdx++;
    return;
  }
  
  public static void listBoard() {
    if (boardIdx == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < boardIdx; i++) {
      System.out.printf("%1d, %s\n", boards[i].no, boards[i].contents);
    }
    return;
  }
}
