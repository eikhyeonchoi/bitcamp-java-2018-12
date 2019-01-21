package com.eomcs.lms.handler;

import java.sql.Date;
import java.util.Scanner;
import com.eomcs.lms.domain.Member;
import com.eomcs.util.ArrayList;

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
    System.out.print("num : ");
    m.setNo(Integer.parseInt(this.keyboard.nextLine()));
    System.out.print("name : ");
    m.setName(this.keyboard.nextLine());
    System.out.print("e-mail : ");
    m.setEmail(this.keyboard.nextLine());
    System.out.print("passW : ");
    m.setPassword(this.keyboard.nextLine());
    System.out.print("photo : ");
    m.setPhoto(this.keyboard.nextLine());
    System.out.print("tel : ");
    m.setTel(this.keyboard.nextLine());
    m.setRegisteredDate(new Date(System.currentTimeMillis()));
    arrayList.add(m);
    System.out.println("add complete ...");
  }

  
  public void detailMember() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false ) return;
    
    Member tempMember = arrayList.get(res);
    System.out.printf("num : %s\n", tempMember.getName());
    System.out.printf("e-mail : %s\n", tempMember.getEmail());
    System.out.printf("passW : %s\n", tempMember.getPassword());
    System.out.printf("photo : %s\n", tempMember.getPhoto());
    System.out.printf("tel : %s\n", tempMember.getTel());
    System.out.printf("regiDay : %s\n", tempMember.getRegisteredDate());
  }


  
  
  public void updateMember() { 
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false ) return;
    Member originalMember = arrayList.get(res);
    Member insteadMember = new Member();
    insteadMember.setNo(originalMember.getNo());
    System.out.print("name : ");
    String string = keyboard.nextLine();
    insteadMember.setName(string.length() > 0 ?
        string : originalMember.getName());
    System.out.print("e-mail : ");
    string = keyboard.nextLine();
    insteadMember.setEmail(string.length() > 0 ?
        string : originalMember.getEmail());
    System.out.print("passW : ");
    string = keyboard.nextLine();
    insteadMember.setPassword(string.length() > 0 ?
        string : originalMember.getPassword());
    System.out.print("photo : ");
    string = keyboard.nextLine();
    insteadMember.setPhoto(string.length() > 0 ?
        string : originalMember.getPhoto());
    System.out.print("tel : "); 
    string = keyboard.nextLine();
    insteadMember.setTel(string.length() > 0 ?
        string : originalMember.getTel());
    insteadMember.setRegisteredDate(new Date(System.currentTimeMillis()));
    
    arrayList.set(res, insteadMember);
    System.out.println("update complete ...");
  }
  
  
  public void deleteMember() {
    int no = prompt();
    int res = indexOf(no);
    if (valid(res) == false ) return;
    
    arrayList.remove(res);
    System.out.println("delete complete ...");
  }

  private int prompt() {
    System.out.print("num : ");
    int no = Integer.parseInt(keyboard.nextLine());
    return no;
  }
  
  private int indexOf(int no) {
    Member[] temp = arrayList.toArray(new Member[0]);
    for (int k = 0; k < arrayList.getSize(); k++) {
      if (temp[k].getNo() == no) {
        return k;
      }
    }
    return -1;
  }
  
  private boolean valid(int res) {
    if (res == -1) {
      System.out.println("not find num ...");
      return false;
    }
    return true;
  }
  
}
