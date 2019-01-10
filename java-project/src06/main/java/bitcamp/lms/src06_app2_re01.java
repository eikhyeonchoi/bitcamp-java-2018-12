//
package bitcamp.lms;

import java.sql.Date;

public class src06_app2_re01 {
  public static void main(String[] args) {

    java.util.Scanner key = new java.util.Scanner(System.in);
    final int LEN = 10;
    int[] num = new int[LEN];
    String[] content = new String[LEN];
    String[] mail = new String[LEN];
    int[] pw = new int[LEN];
    String[] pic = new String[LEN];
    int[] call = new int[LEN];
    Date[] stDate = new Date[LEN];

    for (int i = 0; i < LEN; i++) {
      System.out.print("번호 : ");
      num[i] = Integer.parseInt(key.nextLine());
      System.out.print("이름 : ");
      content[i] = key.nextLine();
      System.out.print("메일 : ");
      mail[i] = key.nextLine();
      System.out.print("암호 : ");
      pw[i]= Integer.parseInt(key.nextLine());
      System.out.print("사진 : ");
      pic[i] = key.nextLine();
      System.out.print("전화 : ");
      call[i] = Integer.parseInt(key.nextLine());
      System.out.print("시작 : ");
      stDate[i] = Date.valueOf(key.nextLine());
      
      System.out.print("\n계속하시겠습니까?(Y/n) ");
      String ans = key.nextLine();
      
      if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        for(int k = 0; k <= i; k++) {
          System.out.printf("%d,%-10s,%9s,%9s, 0\n"
              , num[k], content[k], stDate[k],new Date(System.currentTimeMillis()));
        }
        break;
      } else continue;
      
      
    }



  }

}
