package bitcamp.lms;

public class App2 {

  public static void main(String[] args) {
    
    java.util.Scanner key = new java.util.Scanner(System.in);
    
    System.out.print("번호 : ");
    int num = key.nextInt();
    
    key.nextLine();
    
    System.out.print("이름 : ");
    String name = key.nextLine();
    
    System.out.print("이메일 : ");
    String mail = key.nextLine();
    
    System.out.print("암호 : ");
    int pw = key.nextInt();
    
    key.nextLine();
    
    System.out.print("사진 : ");
    String pic = key.nextLine();
    
    System.out.print("전화 : ");
    String tel = key.nextLine();
    
    System.out.printf("번호 : %d\n이름 : %s\n이메일 : %s\n암호 %d\n사진 : %s\n전화 : %s\n"
        + "가입일 : 2019.01.01",num ,name, mail, pw, pic, tel);
    

  }
}
