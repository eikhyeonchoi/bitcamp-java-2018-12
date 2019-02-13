package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand implements Command {
  Scanner keyboard;

  public MemberDetailCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      out.writeUTF("/member/detail"); out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeInt(no); out.flush();

      String status = in.readUTF();
      
      if (!status.equals("OK"))
        throw new Exception("서버에서 게시글 가져오기 실패!");

      Member member = (Member) in.readObject();
      System.out.printf("이름 : %s\n", member.getName());

    }catch (Exception e) {
      System.out.printf("회원 상세 정보 출력 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
