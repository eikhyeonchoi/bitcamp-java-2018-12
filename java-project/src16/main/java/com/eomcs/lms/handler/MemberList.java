package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Arrays;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;

public class MemberList {
  Member[] members;
  int memberIdx = 0;
  
  
  public MemberList() {
    members = new Member[10];
  }
  public MemberList(int length) {
    if (length < 10) {
      members = new Member[10];
    } else {
      members = new Member[length];
    }
  }

  public Member[] toArray() {
    return Arrays.copyOf(members, memberIdx);
  }

  public void add(Member m) {
    if (memberIdx >= members.length) {
      members = Arrays.copyOf(members, members.length +(members.length >>1));
    }
    members[memberIdx] = m;
    memberIdx++;
  }

}
