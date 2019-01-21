package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.ArrayList;
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
    System.out.print("num : ");
    b.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("contents : ");
    b.setContents(this.keyboard.nextLine());
    b.setCreatedDate(new Date(System.currentTimeMillis()));
    b.setViewCount(0);
    arrayList.add(b);
    System.out.println("add complete ...");
    // Board(서브클래스) ==> Object내용(수퍼클래스) 형변환이 필요없다
  }
  
  public void detailBoard() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    Board detail = arrayList.get(res);
    System.out.printf("contents : %s\n", detail.getContents());
    System.out.printf("createDay : %s\n", detail.getCreatedDate());
  }

  
  public void updateBoard() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    Board originalBoard = arrayList.get(res);
    Board newBoard = new Board();
    System.out.print("contents : ");
    String string = keyboard.nextLine();
    newBoard.setNo(no);
    newBoard.setContents(string.length() > 0 ?
        string : originalBoard.getContents());
    newBoard.setCreatedDate(new Date(System.currentTimeMillis()));
    arrayList.set(res, newBoard);
    System.out.println("update complete ...");
    

  }


  public void deleteBoard() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    arrayList.remove(res);
    System.out.println("remove complete ...");
  }
  
  private int prompt() {
    System.out.print("num : ");
    int no = Integer.parseInt(keyboard.nextLine());
    return no;
  }
  
  private int indexOf(int no) {
    Board[] temp = arrayList.toArray(new Board[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (temp[k].getNo() == no) {
        return k;
      }
    }
    return -1;
  }

  boolean valid(int res) {
    if (res == -1) {
      System.out.println("not find num ...");
      return false;
    }
    return true;
  }
}














