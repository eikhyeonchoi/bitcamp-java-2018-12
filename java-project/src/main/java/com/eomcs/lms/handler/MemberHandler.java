package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.lms.util.ArrayList;

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
      System.out.printf("%d, %s, %s, %s, %s\n"
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
  
  public void detailMember() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    Member detail = arrayList.get(res);
    System.out.printf("이름 : %s\n", detail.getName());
    System.out.printf("메일 : %s\n", detail.getEmail());
    System.out.printf("암호 : %s\n", detail.getPassword());
    System.out.printf("사진 : %s\n", detail.getPhoto());
    System.out.printf("전화 : %s\n", detail.getTel());
    System.out.printf("가입 : %s\n", detail.getRegisteredDate());
  }

  
  public void updateMember() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;

    Member originalMember = arrayList.get(res);
    Member newMember = new Member();
    newMember.setNo(no);
    System.out.print("이름 : ");
    String str = keyboard.nextLine();
    newMember.setName(str.length() > 0 ?
        str : originalMember.getName());
    System.out.print("메일 : ");
    str = keyboard.nextLine();
    newMember.setEmail(str.length() > 0 ?
        str : originalMember.getEmail());
    System.out.print("암호 : ");
    str = keyboard.nextLine();
    newMember.setPassword(str.length() > 0 ?
        str : originalMember.getPassword());
    System.out.print("사진 : ");
    str = keyboard.nextLine();
    newMember.setPhoto(str.length() > 0 ?
        str : originalMember.getPhoto());
    System.out.print("전화 : ");
    str = keyboard.nextLine();
    newMember.setTel(str.length() > 0 ?
        str : originalMember.getTel());
    newMember.setRegisteredDate(new Date(System.currentTimeMillis()));
    arrayList.set(res, newMember);
    System.out.println("수정이 완료되었습니다 ...");
  }
  
  public void deleteMember() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false) return;
    
    arrayList.remove(res);
    System.out.println("삭제가 완료되었습니다 ...");
    
  }

  int indexOf(int no) {
    Member[] members = arrayList.toArray(new Member[0]);
    for(int k = 0; k < arrayList.getSize(); k++) {
      if (members[k].getNo() == no) {
        return k;
      }
    }
    return -1;
  }
  
  int prompt() {
    System.out.print("번호 : ");
    int no = Integer.parseInt(keyboard.nextLine());
    return no;
  }
  
  boolean valid(int no) {
    if (no == -1) {
      System.out.println("해당 번호를 찾을 수 없습니다 ...");
      return false;
    }
    return true;
  }
  
  
}
