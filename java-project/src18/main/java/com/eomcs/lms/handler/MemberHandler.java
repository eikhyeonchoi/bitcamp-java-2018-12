package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  public Scanner keyboard;
  ArrayList<Member> arrayList;
  
  public MemberHandler(Scanner key) {
    this.keyboard = key;
    this.arrayList =  new ArrayList<>();
  }
  
  public void listMember() {
    Member[] members = arrayList.toArray(new Member[0]);
    for (Member member : members) {
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n"
          , member.getNo(), member.getName(), member.getEmail(), 
          member.getTel(), member.getRegisteredDate());
    }
  }

  public void addMember() {
    Member m = new Member();
    System.out.print("번호? ");
    m.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("이름? ");
    m.setName(this.keyboard.nextLine());
    System.out.print("이메일? ");
    m.setEmail(this.keyboard.nextLine());
    System.out.print("암호? ");
    m.setPassword(this.keyboard.nextLine());
    System.out.print("사진? ");
    m.setPhoto(this.keyboard.nextLine());
    System.out.print("전화? ");
    m.setTel(this.keyboard.nextLine());
    m.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    arrayList.add(m);
  }

}
