package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.lms.util.ArrayList;
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
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    Board detail = arrayList.get(res);
    System.out.printf("내용 : %s\n", detail.getContents());
    System.out.printf("작성일 : %s\n", detail.getCreatedDate());
    
  }

  
  public void updateBoard() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    Board originalBoard = arrayList.get(res);
    Board newBoard = new Board();
    System.out.print("내용 : ");
    String string = keyboard.nextLine();
    newBoard.setNo(no);
    newBoard.setContents(string.length() > 0 ?
        string : originalBoard.getContents());
    newBoard.setCreatedDate(new Date(System.currentTimeMillis()));
    arrayList.set(res, newBoard);
    System.out.println("수정이 완료되었습니다 ...");
  }
  
  public void deleteBoard() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    arrayList.remove(res);
    System.out.println("삭제가 완료되었습니다 ...");
  }

  boolean valid(int res) {
    if (res == -1) {
      System.out.println("해당 번호를 찾을 수 없습니다 ...");
      return false;
    }
    return true;
  }
  
  int prompt() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    return no;
  }
  
  int indexOf(int no) {
    Board[] temp = arrayList.toArray(new Board[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (temp[k].getNo() == no) {
        return k;
      }
    }
    return -1;
  }
  
}
