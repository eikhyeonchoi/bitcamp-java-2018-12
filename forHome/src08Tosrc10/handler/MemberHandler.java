package src08Tosrc10.handler;

import java.sql.Date;
import java.util.Scanner;
import src08Tosrc10.domain.Member;

public class MemberHandler {
  public static final int LEN = 10;
  public static int midx = 0;
  public static Scanner key;
  public static Member[] members = new Member[LEN];
  
  public static void listMember() {
    Date date = new Date(System.currentTimeMillis());
    if (midx == 0) {
      System.out.println("정보가 없습니다");
      return;
    }
    System.out.printf("%2s, %5s, %8s, %s\n", "번호", "이름", "메일", "전화", "가입일");
    for (int k = 0; k < midx; k++) {
      System.out.printf("%2d, %5s, %8s, %s\n", members[k].num, members[k].name, members[k].tel,
          date);
    }
  }
  public static void addMember() {
    Member tempMember = new Member();
    System.out.print("번호 : ");
    tempMember.num = Integer.parseInt(key.nextLine());
    System.out.print("이름 : ");
    tempMember.name = key.nextLine();
    System.out.print("메일 : ");
    tempMember.mail = key.nextLine();
    System.out.print("암호 : ");
    tempMember.pw = Integer.parseInt(key.nextLine());
    System.out.print("사진 : ");
    tempMember.pic = key.nextLine();
    System.out.print("전화 : ");
    tempMember.tel = key.nextLine();
    members[midx] = tempMember;
    midx++;
    System.out.println("저장되었습니다");
  }
}
