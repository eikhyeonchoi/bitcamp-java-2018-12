package com.eomcs.lms.handler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.agent.MemberAgent;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {

  MemberAgent memberAgent;
  Scanner keymember;

  public MemberAddCommand(Scanner keymember, MemberAgent memberAgent) {
    this.keymember = keymember;
    this.memberAgent = memberAgent;
  }

  @Override
  public void execute() {
    Member member = new Member();

    System.out.print("번호? ");
    member.setNo(Integer.parseInt(keymember.nextLine()));

    System.out.print("이름? ");
    member.setName(keymember.nextLine());
    
    System.out.print("메일? ");
    member.setEmail(keymember.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keymember.nextLine());
    
    System.out.print("사진? ");
    member.setPhoto(keymember.nextLine());
    
    System.out.print("전화? ");
    member.setTel(keymember.nextLine());
    member.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    try {
      memberAgent.add(member);
      System.out.println("데이터 저장 성공");
    } catch (Exception e) {
      System.out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()
  
  
}
