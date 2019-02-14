package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {

  Scanner keyboard;
  List<Member> list;

  public MemberUpdateCommand(Scanner keyboard) {
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
        throw new Exception("서버에서 저장 실패!");
      Member member = (Member) in.readObject();
      ///////////////////////////////////////////////////////////////
      Member temp = member.clone();

      System.out.printf("이름 :");
      String input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setName(input);

      System.out.print("메일? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setEmail(input);

      System.out.print("암호? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setPassword(input);

      System.out.print("사진? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setPhoto(input);

      System.out.print("전화? ");
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTel(input);
      temp.setRegisteredDate(new Date(System.currentTimeMillis()));

      out.writeUTF("/member/update"); out.flush();
      if (!in.readUTF().equals("OK")) 
        throw new Exception("서버에서 해당 명령어를 처리하지 못합니다");

      out.writeObject(temp); out.flush();

      status = in.readUTF();
      if (!status.equals("OK"))
        throw new Exception("서버에서 저장 실패!");

      System.out.println("갱신 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
