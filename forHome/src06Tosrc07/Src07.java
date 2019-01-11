package src06Tosrc07;

import java.sql.Date;
import java.util.Scanner;

public class Src07 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    final int LEN = 10;
    Scanner key = new Scanner(System.in);

    Member[] members = new Member[LEN];
    
    
    for(int i = 0; i < LEN; i++) {
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
      
      members[i] = tempMember;
      
      System.out.print("\n 계속 입력 하시겠습니까?(y/n)");
      String ans = key.nextLine();
      
       Date signUp = new Date(System.currentTimeMillis());
      if(!ans.equalsIgnoreCase("y")) {
        for(int k = 0; k <= i; k++) {
          System.out.printf("%-2d, %-5s, %-10s, %-8s, %s\n"
              , members[k].num, members[k].name
              , members[k].mail, members[k].tel, signUp);
        }
        break;
      } 
      
    }

  }
}
