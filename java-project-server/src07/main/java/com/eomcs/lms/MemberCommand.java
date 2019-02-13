package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import com.eomcs.lms.domain.Member;

public class MemberCommand {

  static ArrayList<Member> members;
  static ObjectInputStream in;
  static ObjectOutputStream out;

  public static void service(String request) throws Exception {
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

  static void add() throws Exception {
    out.writeUTF("OK"); out.flush();
    members.add((Member)in.readObject());
    out.writeUTF("OK"); 
  } // add()

  static void list() throws Exception {
    out.writeUTF("OK"); out.flush();
    out.writeUTF("OK");
    out.writeObject(members);
    // Collection 객체도 보낼 수 있음 
  } // list()

  static void detail() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    for(Member m : members) {
      if(m.getNo() == no) {
        out.writeUTF("OK");
        out.writeObject(m);
        return;
      }
    } // for

    out.writeUTF("FAIL");
  } // detail()

  static void update() throws Exception {
    out.writeUTF("OK"); out.flush();
    Member member = (Member)in.readObject();

    int index = 0;
    for(Member m : members) {
      if(m.getNo() == member.getNo()) {
        members.set(index, member);
        out.writeUTF("OK");
        return;
      }
      index ++;
    } // for

    out.writeUTF("FAIL");
  } // update()


  static void delete() throws Exception {
    out.writeUTF("OK"); out.flush();
    int no = in.readInt();

    int index = 0;
    for(Member m : members) {
      if(m.getNo() == no) {
        members.remove(index);
        out.writeUTF("OK");
        return;
      }
      index++;
    } // for

    out.writeUTF("FAIL");
  } // delete()


}
