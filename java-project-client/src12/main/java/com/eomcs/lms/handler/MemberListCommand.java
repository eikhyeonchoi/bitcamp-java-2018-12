package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {

  Scanner keyboard;

  public MemberListCommand(Scanner keyboard) {
    this.keyboard = keyboard;
  }

  @Override
  public void execute(ObjectInputStream in, ObjectOutputStream out) {
    try {
      List<Member> members = MemberAgent.list(in, out);
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
