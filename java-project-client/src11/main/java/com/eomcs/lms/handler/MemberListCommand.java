package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {

  Scanner keyboard;

  public MemberListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      out.writeUTF("/member/list"); out.flush();
      if (!in.readUTF().equals("OK"))
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      String status = in.readUTF();

      if (!status.equals("OK")) 
        throw new Exception("서버에서 가져오기 실패!");

      @SuppressWarnings("unchecked")
      List<Member> members = (List<Member>) in.readObject();
      for (Member member : members) {
        System.out.printf("%3d, %s, %s, %s, %s, %s, %s\n", 
            member.getNo(), member.getName(), member.getEmail(), member.getPassword()
            ,member.getPhoto(), member.getTel(), member.getRegisteredDate());
      } // for
    } catch (Exception e) {
      System.out.printf("출력 오류 : %s\n", e.getMessage());
    }

  } // execute()

}
