// 키보드로 입력한 값 받기 5 - token단위로 문자열 읽기;
package ch03; 

public class Test10 {
  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
   
    
    System.out.print("age? ");
    int age = keyboard.nextInt();
    
    
    System.out.print("name? ");
    String name = keyboard.next();
    
    
    // next()는 token단위로 문자열을 읽는다;
    // nextInt()를 호출한 후 LF코드를 남아 있다하더라도
    // next()는 공백을 버리기 때문에 영향을 받지않는다
    // 내부 버퍼의 원리.. h/w에 직접 접근할 수 x OS에서 막음;

    
    System.out.printf("age : %d, name : %s",age, name);
    
    


  }
}


/*
 * 
 * 
 */


