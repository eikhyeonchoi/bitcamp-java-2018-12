package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;
import com.eomcs.util.List;
public class BoardHandler {
  public Scanner keyboard;
  List<Board> arrayList;
  
  public BoardHandler(Scanner key, List<Board> list) {
    this.keyboard = key;
    
    // 다음과 같이 이 클래스가 사용할 List객체를 LinkedList로 결정하면
    // List 사용 규칙을 따르는 다른 객체로 쉽게 변경할 수 없음
    // 다른 List객체로 변경하려면 이 클래스의 생성자 코드를
    // 어떤 기능을 변경할 때 마다 소스 코드를 변경하는 방식은 유지보수에 좋지않다
    // 해결책?
    // ==> 이 클래스에서 어떤 List 객체를 사용할 것인지 결정하지말고
    //     이 클래스를 사용하는 쪽에서 결정하도록 유도
    // ==> 즉 생성자에게 List 객체를 준비하고 파라미터로 주입받아라
    //     이렇게 자기가 작업하는데 사용하는 도구를 의존객체(dependancy)라부른다
    //     외부로부터 주입 받는것을 의존 객체 주입이라고 부른다 dependancy injection
    this.arrayList = list;
  }

  public void listBoard() {
    // Board[] boards = new Board[arrayList.size()];
    // arrayList.toArray(boards);
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
    for(int k = 0; k < arrayList.size(); k++) {
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














