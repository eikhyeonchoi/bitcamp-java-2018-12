package bitcamp.lms;

import java.sql.Date;

public class App2 {

  public static void main(String[] args) {

    java.util.Scanner key = new java.util.Scanner(System.in);

    int[] num = new int[20];
    String[] name = new String[20];
    String[] mail = new String[20];
    int[] pw = new int[20];
    String[] pic = new String[20];
    int[] phone = new int[20];
    Date signUp = new Date(System.currentTimeMillis());
    int i = 0;
    ok: {
      while(true) {
        String ans = null;
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
        phone[i] = Integer.parseInt(key.nextLine());

        System.out.print("계속하시겠습니까 y/n");
        ans = key.nextLine();

        if(ans.equals("Y") || ans.equals("y") || ans.equals("\n")) {
          i++;
          continue;
        } else {
          int j = 0;
          while(j <= i) {
            System.out.println(num[j]+" "+name[j]+" "+mail[j]+" "+phone[i]+
                " "+signUp);
            j++;
          }
          key.close();
          break ok;
        }
      }
    }













  }
}
