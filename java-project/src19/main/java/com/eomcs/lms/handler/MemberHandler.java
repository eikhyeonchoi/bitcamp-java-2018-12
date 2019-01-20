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
    System.out.println("add complete ...");
    
  }

  public void detailMember() {
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    } 
    Member showMember = arrayList.get(ans);
    System.out.printf("이름 : %s\n", showMember.getName());
    System.out.printf("메일 : %s\n", showMember.getEmail());
    System.out.printf("암호 : %s\n", showMember.getPassword());
    System.out.printf("사진 : %s\n", showMember.getPhoto());
    System.out.printf("전화 : %s\n", showMember.getTel());

  }
  public void updateMember() { 
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    } 
    Member mem = new Member();
    mem.setNo(ans);
    mem.setName(keyboard.nextLine());
    mem.setEmail(keyboard.nextLine());
    mem.setPassword(keyboard.nextLine());
    mem.setPhoto(keyboard.nextLine());
    mem.setTel(keyboard.nextLine());
    arrayList.set(ans, mem);
    System.out.println("update delete ...");
    
  }
  
  public void deleteMember() {
    System.out.print("번호 : ");
    int ans = Integer.parseInt(keyboard.nextLine());
    if (ans > arrayList.getSize() || ans <= 0) {
      System.out.println("해당 번호를 찾을 수 없습니다");
      return;
    } 
    arrayList.remove(ans);
    System.out.println("delete complete ...");

  }

}
