package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  Scanner keymember;
  List<Member> list;

  public MemberUpdateCommand(Scanner keymember) {
    this.keymember = keymember;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      out.writeUTF("/member/update"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");
      
      Member tempMember = new Member();
      System.out.print("번호 : ");
      tempMember.setNo(Integer.parseInt(keymember.nextLine()));
      System.out.print("내용 : ");
      tempMember.setName(keymember.nextLine());

      out.writeObject(tempMember); out.flush();

      String status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");
      
      System.out.println("회원정보 갱신 완료");
    } catch (Exception e) {
      System.out.printf("회원정보 갱신 오류 : %s\n", e.getMessage());
    }
  }



}
