package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberHandler {
  public Scanner keyboard;
  ArrayList arrayList = new ArrayList();
  Object[] objects;
  Member m;
  
  public MemberHandler(Scanner key) {
    this.keyboard = key;
  }
  
  public void listMember() {
    objects = arrayList.toArray();
    for (Object tempObject : objects) {
      Member tempMember = (Member)tempObject;
      System.out.printf("%3d, %-4s, %-20s, %-15s, %s\n"
          , tempMember.getNo(), tempMember.getName(), tempMember.getEmail(), 
          tempMember.getTel(), tempMember.getRegisteredDate());
    }
  }

  public void addMember() {
    m = new Member();
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
