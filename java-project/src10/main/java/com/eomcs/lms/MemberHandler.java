package com.eomcs.lms;

import java.sql.Date;
import java.util.Scanner;

public class MemberHandler {

  final static int L = 10;
  static Member[] members = new Member[L];
  static int memberIdx = 0;
  static Scanner key;

  static void addMember() {
    Date signUp = new Date(System.currentTimeMillis());
    Member tempMember = new Member();
    System.out.print("번호 : ");
    tempMember.no = Integer.parseInt(key.nextLine());
    System.out.print("이름 : ");
    tempMember.name = key.nextLine();
    System.out.print("이메일 : ");
    tempMember.email = key.nextLine();
    System.out.print("암호 : ");
    tempMember.password = key.nextLine();
    System.out.print("사진 : ");
    tempMember.photo = key.nextLine();
    System.out.print("전화 : ");
    tempMember.tel = key.nextLine();
    tempMember.registeredDate = signUp;
    System.out.println("저장하였습니다");
    members[memberIdx] = tempMember;
    memberIdx++;
    return;
  }

  static void listMember() {
    if (memberIdx == 0) {
      System.out.println("저장된 정보가 없습니다");
      return;
    }
    for (int i = 0; i < memberIdx; i++) {
      System.out.printf("%1d, %-5s, %-10s, %-5s, %s\n", members[i].no, members[i].name,
          members[i].email, members[i].tel, members[i].registeredDate);
    }
    return;
  }



}
