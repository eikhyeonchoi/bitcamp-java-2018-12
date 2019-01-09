//src06 복습

package bitcamp.lms;
import java.sql.Date;

public class src06_app3_re01 {
  public static void main(String[] args) {

    final int LENGTH = 10;
    java.util.Scanner key = new java.util.Scanner(System.in);

    int[] num = new int[LENGTH];
    String[] content = new String[LENGTH];
    Date writeDay = new Date(System.currentTimeMillis());
    
    
    for (int i = 0; i < LENGTH; i++) {
      System.out.print("번호 : ");
      num[i] = Integer.parseInt(key.nextLine());
      System.out.print("내용 : ");
      content[i] = key.nextLine();
      
      System.out.print("계속 입력하시겠습니까(Y/n)");
      String ans = null;
      ans = key.nextLine();
      if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        for (int k = 0; k <= i; k++) {
          System.out.printf("%d, %-10s, %9s\n",num[k], content[k], writeDay);
        }
        break;
      } else continue;
    }
    
  }
}
