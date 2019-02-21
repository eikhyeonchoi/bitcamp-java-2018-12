package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {

  MemberDao memberDao;
  Scanner keyboard;

  public MemberAddCommand(Scanner keymember, MemberDao memberDao) {
    this.keyboard = keymember;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    Member member = new Member();

    System.out.print("이름? ");
    member.setName(keyboard.nextLine());
    
    System.out.print("메일? ");
    member.setEmail(keyboard.nextLine());
    
    System.out.print("암호? ");
    member.setPassword(keyboard.nextLine());
    
    System.out.print("사진? ");
    member.setPhoto(keyboard.nextLine());
    
    System.out.print("전화? ");
    member.setTel(keyboard.nextLine());
    
    
    try {
      memberDao.insert(member);
      System.out.println("데이터 저장 성공");
    } catch (Exception e) {
      System.out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()
  
  
}
