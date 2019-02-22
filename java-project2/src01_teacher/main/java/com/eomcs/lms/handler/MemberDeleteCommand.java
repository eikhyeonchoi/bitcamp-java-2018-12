package com.eomcs.lms.handler;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;

public class MemberDeleteCommand implements Command {


  MemberDao memberDao;
  Scanner keyboard;

  public MemberDeleteCommand(Scanner keyboard, MemberDao memberDao) {
    this.keyboard = keyboard;
    this.memberDao = memberDao;
  }

  @Override
  public void execute() {
    System.out.print("번호? ");
    int no = Integer.parseInt(keyboard.nextLine());

    try {
      if (memberDao.delete(no) == 0) {
        System.out.println("해당 멤버가 존재하지 않습니다");
        return;
      }
      System.out.println("데이터 삭제했습니다.");
    } catch(Exception e) {
      System.out.printf("삭제 오류 : %s\n", e.getMessage());
    }
  } // execute()
}
