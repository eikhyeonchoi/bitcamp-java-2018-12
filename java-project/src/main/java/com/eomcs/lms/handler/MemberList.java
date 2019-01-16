package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberList {

  public Scanner keyboard;
  int LENGTH;
  Member[] members;
  int memberIdx = 0;
  
  
  public MemberList() {
    members = new Member[10];
  }
  public MemberList(int length) {
    this.LENGTH = length;
    members = new Member[LENGTH];
  }

  public Member[] toArray() {
    return Arrays.copyOf(members, memberIdx);
  }

  public void add(Member m) {
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
    this.members[this.memberIdx] = m;
    this.memberIdx++;

    System.out.println("저장하였습니다.");
  }

}
