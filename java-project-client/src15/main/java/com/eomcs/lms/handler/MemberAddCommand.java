package com.eomcs.lms.handler;
import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberAddCommand implements Command {

  MemberDao memberDao;
  Scanner keymember;

  public MemberAddCommand(Scanner keymember, MemberDao memberDao) {
    this.keymember = keymember;
    this.memberDao = memberDao;
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
      memberDao.insert(member);
      System.out.println("데이터 저장 성공");
    } catch (Exception e) {
      System.out.printf("저장 오류 : %s\n", e.getMessage());
    }
  } // execute()
  
  
}
