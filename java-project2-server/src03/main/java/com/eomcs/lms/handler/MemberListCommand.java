package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberListCommand implements Command {
  
  MemberDao memberDao;

  public MemberListCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @Override
  public void execute(BufferedReader in, PrintWriter out) {
    try {
      List<Member> members = memberDao.findAll();
      for (Member member : members) {
        out.printf("%3d, %s, %s, %s, %s, %s, %s\n", 
            member.getNo(), member.getName(), member.getEmail(), member.getPassword()
            ,member.getPhoto(), member.getTel(), member.getRegisteredDate());
      } // for
    } catch (Exception e) {
      out.printf("출력 오류 : %s\n", e.getMessage());
    }

  } // execute()

}
