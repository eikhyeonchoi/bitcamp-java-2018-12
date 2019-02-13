package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Board;

public class BoardUpdateCommand implements Command {

  Scanner keyboard;
  List<Board> list;

  public BoardUpdateCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      out.writeUTF("/board/update"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");
      
      Board tempBoard = new Board();
      System.out.print("번호 : ");
      tempBoard.setNo(Integer.parseInt(keyboard.nextLine()));
      System.out.print("내용 : ");
      tempBoard.setContents(keyboard.nextLine());

      out.writeObject(tempBoard); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
      
      System.out.println("게시글 갱신 완료");
    } catch (Exception e) {
      System.out.printf("게시글 갱신 오류 : %s\n", e.getMessage());
    }
  }



}
