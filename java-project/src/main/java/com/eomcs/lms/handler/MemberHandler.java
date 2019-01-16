package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  public Scanner keyboard;
  MemberList memberList = new MemberList();
  Member[] members;
  Member m;
  
  public MemberHandler(Scanner key) {
    this.keyboard = key;
  }
  
  public void listMember() {
    members = memberList.toArray();
    for (Member m : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n"
          , m.getNo(), m.getName(), m.getEmail(), 
          m.getTel(), m.getRegisteredDate());
    }
  }

  public void addMember() {
    memberList.keyboard = keyboard;
    memberList.add(m);
  }

}
