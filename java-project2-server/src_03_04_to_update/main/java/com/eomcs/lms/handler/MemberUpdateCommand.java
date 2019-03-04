package com.eomcs.lms.handler;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberUpdateCommand extends AbstractCommand {

  MemberDao memberDao;
  public MemberUpdateCommand(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(Response response) throws Exception {
    int no = response.requestInt("번호 ? : ");

    Member member = memberDao.findByNo(no);

    if(member == null) {
      response.println("해당 멤버가 존재하지 않습니다");
      return;
    }

    Member temp = member.clone();

    String input = response.requestString(
        String.format("이름(%s) :", temp.getName()));
    if(input.length() > 0)
      temp.setName(input);
    
    input = response.requestString(
        String.format("메일(%s) : ", temp.getEmail()));
    if(input.length() > 0)
      temp.setEmail(input);

    input = response.requestString("암호(********) : ");
    if(input.length() > 0)
      temp.setPassword(input);

    input = response.requestString(
        String.format("사진(%s) : ", temp.getPhoto()));
    if(input.length() > 0)
      temp.setPhoto(input);

    input = response.requestString(
        String.format("전화(%s) : ", temp.getTel()));
    if(input.length() > 0)
      temp.setTel(input);

    temp.setRegisteredDate(temp.getRegisteredDate());

    memberDao.update(temp);

    response.println("갱신 완료");
  } // execute()



}
