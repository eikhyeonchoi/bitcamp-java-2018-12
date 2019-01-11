package src08Tosrc10.handler;

import java.sql.Date;
import java.util.Scanner;
import src08Tosrc10.domain.Board;

public class BoardHandler {
  public static final int LEN = 10;
  public static int bidx = 0;
  public static Scanner key;
  public static Board[] boards = new Board[LEN];
  
  
  public static void listBoard() {
    Date date = new Date(System.currentTimeMillis());
    if (bidx == 0) {
      System.out.println("정보가 없습니다");
      return;
    }
    System.out.printf("%2s, %15s, %s\n", "번호", "내용", "작성시간");
    for (int k = 0; k < bidx; k++) {
      System.out.printf("%2d, %15s, %s\n", boards[k].num, boards[k].contents, date);
    }
  }
  public static void addBoard() {
    Board tempBoard = new Board();
    System.out.print("번호 : ");
    tempBoard.num = Integer.parseInt(key.nextLine());
    System.out.print("이름 : ");
    tempBoard.contents = key.nextLine();
    boards[bidx] = tempBoard;
    bidx++;
    System.out.println("저장되었습니다");
  }
  

}
