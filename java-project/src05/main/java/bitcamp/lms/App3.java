package bitcamp.lms;

public class App3 {

  public static void main(String[] args) {
    
    java.util.Scanner k = new java.util.Scanner(System.in);
    java.util.Date date =new java.util.Date();
    
    System.out.print("번호 : ");
    int num = k.nextInt();
    
    k.nextLine();
    
    System.out.print("내용 : ");
    String con = k.nextLine();
    
    System.out.printf("번호 : %d\n내용 : %s\n작성일 : %3$ty %3$tm %3$td "
        + "%3$tH %3$tM %3$tS",num, con, date);
    
    
    
  }
}
