package bitcamp.lms;

import java.sql.Date;
import java.util.Scanner;

public class App3 {

  static int count = 1;

  public static void main(String[] args) {

    final int LENGTH = 10;
    Scanner key = new Scanner(System.in);
    Board[] b = new Board[LENGTH];

    for (int i = 0; i < LENGTH; i++) {
      b[i] = new Board();
      System.out.print("번호 : ");
      b[i].num = Integer.parseInt(key.nextLine());
      System.out.print("내용 : ");
      b[i].contents = key.nextLine();

      System.out.print("\n계속 입력 하시겠습니까?(y/n) ");
      String ans = key.nextLine();
      System.out.println();

      if (!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        printList(b);
        break;
      } else {
        count++;
        continue;
      }

    }

  }

  static void printList(Board[] b) {
    Date makeDate = new Date(System.currentTimeMillis());
    for (int k = 0; k < count; k++) {
      b[k].createdDate = makeDate;
      System.out.printf("%d, %-5s, %10s, 0\n", b[k].num, b[k].contents, b[k].createdDate);
    }
  }

}


