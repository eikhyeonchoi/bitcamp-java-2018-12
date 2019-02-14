package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;
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
      Member member = MemberAgent.get(no, in, out);
      ///////////////////////////////////////////////////////////////
      Member temp = member.clone();

      System.out.printf("이름(%s) :", temp.getName());
      String input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setName(input);

      System.out.printf("메일(%s) : ", temp.getEmail());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setEmail(input);

      System.out.printf("암호(%s) : ", temp.getPassword());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setPassword(input);

      System.out.printf("사진(%s) : ", temp.getPhoto());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setPhoto(input);

      System.out.printf("전화(%s) : ", temp.getTel());
      input = keyboard.nextLine();
      if(input.length() > 0)
        temp.setTel(input);
      
      temp.setRegisteredDate(temp.getRegisteredDate());

      MemberAgent.update(temp, in, out);

      System.out.println("갱신 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
