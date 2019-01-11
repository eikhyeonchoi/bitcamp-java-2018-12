package src06Tosrc07;

import java.sql.Date;
import java.util.Scanner;

public class Src06 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    final int LEN = 10;
    Scanner key = new Scanner(System.in);
    
    int[] num = new int[LEN];
    String[] name = new String[LEN];
    String[] mail = new String[LEN];
    int[] pw = new int[LEN];
    String[] pic = new String[LEN];
    String[] tel = new String[LEN];
    
    for(int i = 0; i < LEN; i++) {
      System.out.print("번호 : ");
      num[i] = Integer.parseInt(key.nextLine());
      System.out.print("이름 : ");
      name[i] = key.nextLine();
      System.out.print("메일 : ");
      mail[i] = key.nextLine();
      System.out.print("암호 : ");
      pw[i] = Integer.parseInt(key.nextLine());
      System.out.print("사진 : ");
      pic[i] = key.nextLine();
      System.out.print("전화 : ");
      tel[i] = key.nextLine();
      
      System.out.print("\n 계속 입력 하시겠습니까?(y/n)");
      String ans = key.nextLine();
      
       Date signUp = new Date(System.currentTimeMillis());
      if(!ans.equalsIgnoreCase("y")) {
        for(int k = 0; k <= i; k++) {
          System.out.printf("%-2d, %-5s, %-10s, %-8s, %s\n"
              , num[k], name[k], mail[k], tel[k], signUp);
        }
        break;
      } 
      
    }

  }
}
