package bitcamp.lms;

import java.sql.Date;
import bitcamp.lms.Member;
import java.util.Scanner;

public class App2 {

  static int count=0;
  public static void main(String[] args) {
    
    final int LENGTH = 10;
    
    Scanner key = new Scanner(System.in);
    Member[] members = new Member[LENGTH];
    
    // 인스턴스 생성
    for (int i = 0; i<members.length; i++) {
      members[i] = new Member();
    }
    
    for(int k = 0; k < LENGTH; k++) {
      count++;
      System.out.print("번호 : ");
      members[k].num = Integer.parseInt(key.nextLine());
      System.out.print("나이 : ");
      members[k].age = Integer.parseInt(key.nextLine());
      System.out.print("이름 : ");
      members[k].name = key.nextLine();
      System.out.print("전화(010제외, -제외) : ");
      members[k].call = Integer.parseInt(key.nextLine());
      System.out.print("가입일은 자동생성 됩니다 ^^\n");
      
      System.out.print("\n계속 입력하시겠습니까?(Y/n)");
      String ans = key.nextLine();
      System.out.println();
      
      if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        printMembers(members);
        break;
      } else continue;
    }

    
    
  }
  
  static void printMembers(Member[] members) {
    Date sign = new Date(System.currentTimeMillis());
    for(int i = 0; i < count; i++) {
      members[i].signUp = sign;
      System.out.printf("%3d, %-7s, %-8s, %s\n"
          , members[i].age, members[i].name, members[i].call, members[i].signUp);
    }
  }
 
  
}
