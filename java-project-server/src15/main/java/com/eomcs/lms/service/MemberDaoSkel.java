package com.eomcs.lms.service;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import com.eomcs.lms.dao.MemberDao;
import com.eomcs.lms.domain.Member;

public class MemberDaoSkel implements Service{

  // MemberService가 작업을 수행할 때 사용할 객체 (의존 객체; dependancy)
  MemberDao memberDao;

  public MemberDaoSkel(MemberDao memberDao) {
    this.memberDao = memberDao;
  }

  @Override
  public void execute(String request,ObjectInputStream in, ObjectOutputStream out) throws Exception {
    switch(request) {
      case "/member/add" : add(in, out); break;
      case "/member/list" : list(in, out); break;
      case "/member/detail" : detail(in, out); break;
      case "/member/update" : update(in, out); break;
      case "/member/delete" : delete(in, out); break;
      default :
        out.writeUTF("FAIL"); 
    }
    out.flush();
  } // service()

  private void add(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    memberDao.insert((Member)in.readObject());
    out.writeUTF("OK");

  } // add()

  private void list(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");

    out.writeUnshared(memberDao.findAll());
  } // list()

  private void detail(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    Member b = memberDao.findByNo(no);
    if (b == null) {
      out.writeUTF("FAIL");
      return;
    }

    out.writeUTF("OK");
    out.writeObject(b);

  } // detail()

  private void update(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    Member member = (Member)in.readObject();

    if (memberDao.update(member) == 0) {
      out.writeUTF("FAIL");
      return;
    }

    out.writeUTF("OK");
  } // update()


  private void delete(ObjectInputStream in, ObjectOutputStream out) throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    if (memberDao.delete(no) == 0) {
      out.writeUTF("FAIL");
      return;
    }
    
    out.writeUTF("OK");
  } // delete()


}
