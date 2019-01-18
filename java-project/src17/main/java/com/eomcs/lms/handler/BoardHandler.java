package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
public class BoardHandler {
  public Scanner keyboard;
  ArrayList arrayList = new ArrayList();
  Object[] objects;
  Board b;
  
  public BoardHandler(Scanner key) {
    this.keyboard = key;
  }

  public void listBoard() {
    objects = arrayList.toArray();
    for (Object tempObject : objects) {
      // Object(수퍼클래스) ==> Board(서브클래스) 형변환이 필요하다
      Board tempBoard = (Board)tempObject;
      System.out.printf("%3d, %-10s, %s, %d\n"
          ,tempBoard.getNo(), tempBoard.getContents()
          , tempBoard.getCreatedDate(), tempBoard.getViewCount());
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
    arrayList.add(b);
    // Board(서브클래스) ==> Object(수퍼클래스) 형변환이 필요없다
  }
}
