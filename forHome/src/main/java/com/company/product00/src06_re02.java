// 함수를 사용한 src06구현

package com.company.product00;
import java.sql.Date;

public class src06_re02 {
  public static void main(String[] args) {

    final int LENGTH = 10;
    int[] num = new int[LENGTH];
    String[] content = new String[LENGTH];
    
    inputData(LENGTH, num, content);

  }

  // 데이터를 입력받는 method
  static void inputData(int a, int[] num, String[] content) {
    java.util.Scanner key = new java.util.Scanner(System.in);
    String ans = null;
    int temp = 1;

    for (int k = 0; k < a; k++) {
      System.out.print("번호 : ");
      num[k] = Integer.parseInt(key.nextLine());
      System.out.print("내용 : ");
      content[k] = key.nextLine();
      System.out.print("계속 입력하시겠습니까(Y/n)");
      ans = key.nextLine();
      if(!ans.equalsIgnoreCase("y") && !ans.equalsIgnoreCase("")) {
        viewList(temp, num, content);
        break;
      } else {
        temp++;
        continue;
      }
    }
  }

  // num과 content를 받아 출력하는 method
  static void viewList(int times, int[] number, String[] content) {
    Date writeDay = new Date(System.currentTimeMillis());
    for (int i = 0; i < times; i++) {
      System.out.printf("%d, %-10s, %9s\n", number[i], content[i], writeDay);
    }
  }

}
