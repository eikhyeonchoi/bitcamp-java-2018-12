package com.company.product00;

public class src06_02 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    
    java.util.Scanner key = new java.util.Scanner(System.in);
    String[][] tot = new String[5][2];
    int i = 0;
    
    
    while(true) {
      System.out.println("수업을 입력하세요");
      System.out.println("최대 5개 까지 입력 가능합니다 현재 "+(i)+"개");
      int j = 0;
      String ans = null;
      System.out.print("수업 : ");
      tot[i][j] = key.nextLine();
      j++;
      System.out.print("내용 : ");
      tot[i][j] = key.nextLine();
      j = 0;

      if (i>=4) {
        System.out.println("수업이 꽉찾습니다. 현재 5개");
        int k = 0;
        while (k <= i) {
        System.out.println(tot[k][0]+" "+tot[k][1]);
        k++;
        }
        break;
      }
      
      System.out.print("계속 입력 y/n : ");
      ans = key.nextLine();
      if(ans.equalsIgnoreCase("y")) {
        i++;
        continue;
      } else {
        int k = 0;
        while (k <= i) {
        System.out.println(tot[k][0]+" "+tot[k][1]);
        k++;
        }
        break;
      }
      
      
    }
    
    

    
    
  }

}
