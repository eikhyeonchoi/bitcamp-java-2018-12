// 키보드로 입력한 값 받기 2 - 한 줄의 문자열 읽기
package ch03; 

public class Test07 {
  public static void main(String[] args) {
    
    //System.in 이 키보드(입력) 
    //System.out 이 모니터(출력)
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    
    System.out.println("이름 : ");
    java.lang.String name = keyboard.nextLine();
    //한줄을 입력할때 까지 return하지않음 (LF 받을때 까지);
    // java에서 blocking이라고 부름; 모든 입출력은 blocking으로 수행됨 but nonblocking도있음;
    
    System.out.println("나이 : ");
    String age = keyboard.nextLine();
    //java.lang package의 멤버를 사용할때는 package이름을 적지 않아도 된다;
    //java.lang.String = String 다 가능;
    // nextLine()은 문자열 받는거임;
    
    System.out.printf("%s %s",name,age);
  }
}

/*
 * 
 * 
 */


