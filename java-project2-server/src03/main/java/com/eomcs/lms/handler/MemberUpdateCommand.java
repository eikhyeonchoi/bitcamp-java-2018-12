package com.eomcs.lms.handler;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand implements Command {
  
  MemberDao memberDao;
  public MemberUpdateCommand(MemberDao memberDao) {
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
      
      Member temp = member.clone();

      out.printf("이름(%s) :\n", temp.getName());
      out.println("!{}!");
      out.flush();
      String input = in.readLine();
      if(input.length() > 0)
        temp.setName(input);

      out.printf("메일(%s) : \n", temp.getEmail());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setEmail(input);

      out.printf("암호(********) : \n");
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setPassword(input);

      out.printf("사진(%s) : \n", temp.getPhoto());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setPhoto(input);

      out.printf("전화(%s) : \n", temp.getTel());
      out.println("!{}!");
      out.flush();
      input = in.readLine();
      if(input.length() > 0)
        temp.setTel(input);
      
      temp.setRegisteredDate(temp.getRegisteredDate());

      memberDao.update(temp);

      out.println("갱신 완료");
    } catch (Exception e) {
      out.printf("갱신 오류 : %s\n", e.getMessage());
    }
  } // execute()



}
