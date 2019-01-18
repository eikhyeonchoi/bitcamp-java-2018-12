package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
public class BoardHandler {
  public Scanner keyboard;
  ArrayList<Board> arrayList;
  
  public BoardHandler(Scanner key) {
    this.keyboard = key;
    this.arrayList = new ArrayList<>();
  }

  public void listBoard() {
    Board[] boards = arrayList.toArray(new Board[0]);
    for (Board temp : boards) {
      // Object(수퍼클래스) ==> Board(서브클래스) 형변환이 필요하다
      System.out.printf("%3d, %-10s, %s, %d\n"
          ,temp.getNo(), temp.getContents()
          , temp.getCreatedDate(), temp.getViewCount());
    }
    
  }

  public void addBoard() {
    Board b = new Board();
    System.out.print("번호 : ");
    b.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("내용 : ");
    b.setContents(this.keyboard.nextLine());
    b.setCreatedDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    arrayList.add(b);
    // Board(서브클래스) ==> Object(수퍼클래스) 형변환이 필요없다
  }
  
  public void detailBoard() {
    System.out.print("번호를 입력하세요 : ");
    int a = Integer.parseInt(this.keyboard.nextLine());
    if (arrayList.size < a || a <= 0) {
      System.out.println("해당 게시글을 찾을 수 없습니다");
      return;
    }
    Board dBoard = arrayList.get(a);
    System.out.printf("내용 : %s\n",dBoard.getContents());
    System.out.printf("작성일 : %s\n",dBoard.getCreatedDate());
  }
  
  public void updateBoard() {
    System.out.print("번호 : ");
    int excep = Integer.parseInt(this.keyboard.nextLine());
    if (arrayList.size < excep || excep <= 0) {
      System.out.println("해당 게시글을 찾을 수 없습니다");
      return;
    } else {
      Board b = new Board();
      System.out.print("내용 : ");
      b.setContents(keyboard.nextLine());
      b.setCreatedDate(new Date(System.currentTimeMillis()));
      if (b.getContents().equals("")) {
        return;
      }
      System.out.println("변경이 완료되었습니다");
      arrayList.set(excep, b);
    }
  }
  
  public void deleteBoard() {
    System.out.print("번호 : ");
    int excep = Integer.parseInt(this.keyboard.nextLine());
    if (arrayList.size < excep || excep <= 0) {
      System.out.println("해당 게시글을 찾을 수 없습니다");
      return;
    }
    arrayList.remove(excep-1);
  }
  
  
  
  
}














