package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  MemberDao memberDao;
  Scanner keyboard;

  public MemberUpdateCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      Member member = memberDao.findByNo(no);
      
      if(member == null) {
        System.out.println("해당 멤버가 존재하지 않습니다");
        return;
      }
      
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

      memberDao.update(temp);

      System.out.println("갱신 완료");
    } catch (Exception e) {
      System.out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
