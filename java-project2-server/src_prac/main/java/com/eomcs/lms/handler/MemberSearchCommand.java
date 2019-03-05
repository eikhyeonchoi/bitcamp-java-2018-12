package com.eomcs.lms.handler;
import java.util.List;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberSearchCommand extends AbstractCommand {

  MemberDao memberDao;

  public MemberSearchCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }
  @Override
  public void execute(Response response) throws Exception {
    
    String keyword = response.requestString("검색어 ? : ");
        
    List<Member> members = memberDao.findByKeyword(keyword);
    
    for (Member member : members) {
      response.println(String.format("%3d, %s, %s, %s, %s, %s, %s", 
          member.getNo(), member.getName(), member.getEmail(), member.getPassword()
          ,member.getPhoto(), member.getTel(), member.getRegisteredDate()));
    } // for

  } // execute()

}
