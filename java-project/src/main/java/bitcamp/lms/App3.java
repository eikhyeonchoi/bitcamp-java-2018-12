package bitcamp.lms;

public class App3 {

  public static void main(String[] args) {

    java.util.Scanner key = new java.util.Scanner(System.in);

    int[] num = new int[20];
    String[] content = new String[20];
    java.util.Date signUp = new java.util.Date(System.currentTimeMillis());
    int i = 0;

    ok: {
      while(true) {
        String ans = null;
        System.out.print("번호 : ");
        num[i] = Integer.parseInt(key.nextLine());
        System.out.print("내용 : ");
        content[i] = key.nextLine();

        while (true) {
          System.out.print("계속 입력 y/n");
          ans = key.nextLine();

          if(ans.equalsIgnoreCase("y")) {
            i++;
            break;
          } else if (ans.equalsIgnoreCase("n")) {
            int j = 0;
            while (j <= i) {
              System.out.println(num[j]+", "+content[j]+", 0");
              j++;
            }
            break ok;
          } else { 
            System.out.println("유효한값 입력하세요");
          }
        }




      }
    }

  }
}


