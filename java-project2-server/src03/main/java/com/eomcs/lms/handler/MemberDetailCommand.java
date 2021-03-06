package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDetailCommand implements Command {
  
  MemberDao memberDao;

  public MemberDetailCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
    out.println("번호? ");
    out.println("!{}!");
    out.flush();
    int no = Integer.parseInt(in.readLine());

      Member member = memberDao.findByNo(no);
      if(member == null) {
        out.println("해당 멤버가 존재하지 않습니다");
        return;
      }
      out.printf("이름 : %s\n", member.getName());
      out.printf("메일 : %s\n", member.getEmail());
      out.printf("암호 : %s\n ", member.getPassword());
      out.printf("사진 : %s\n ", member.getPhoto());
      out.printf("전화 : %s\n", member.getTel());
      out.printf("가입일 : %s\n", member.getRegisteredDate());

    }catch (Exception e) {
      out.printf("출력 오류 : %s\n", e.getMessage());
    }
  } // execute()

}
