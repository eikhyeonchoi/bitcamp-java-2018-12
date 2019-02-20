package com.eomcs.lms.service;
import com.eomcs.lms.domain.Member;

//클라이언트의 요청을 처리하는 클래스라는 의미
//~~~Service
public class MemberService extends AbstractService<Member>{


  public void execute(String request) throws Exception {
    switch(request) {
      case "/member/add" : add(); break;
      case "/member/list" : list(); break;
      case "/member/detail" : detail(); break;
      case "/member/update" : update(); break;
      case "/member/delete" : delete(); break;
      default :
        out.writeUTF("FAIL"); 
    }
    out.flush();
  } // service()

  private void add() throws Exception {
    out.writeUTF("OK"); out.flush();
    this.list.add((Member)in.readObject());
    out.writeUTF("OK"); 
  } // add()

  private void list() throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");
    out.writeObject(this.list);
    // Collection 객체도 보낼 수 있음 
  } // list()

  private void detail() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    for(Member m : this.list) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    } // for

    out.writeUTF("FAIL");
  } // detail()

  private void update() throws Exception {
    out.writeUTF("OK"); out.flush();
    Member member = (Member)in.readObject();

    int index = 0;
    for(Member m : this.list) {
      if(m.getNo() == member.getNo()) {
        this.list.set(index, member);
        out.writeUTF("OK");
        return;
      }
      index ++;
    } // for

    out.writeUTF("FAIL");
  } // update()


  private void delete() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    int index = 0;
    for(Member m : this.list) {
      if(m.getNo() == no) {
        this.list.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    } // for

    out.writeUTF("FAIL");
  } // delete()


}