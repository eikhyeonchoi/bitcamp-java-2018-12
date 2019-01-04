// 키보드로 입력한 값 받기 3 - int값 읽기
package ch03; 

public class Test08 {
  public static void main(String[] args) {
    
    java.util.Scanner keyboard = new java.util.Scanner(System.in);
    
    
    System.out.print("a? ");
    int a = keyboard.nextInt();
    // nextInt()는 한개의 token을 읽을 때까지 기다린다.
    // 한 token을 읽으면 4byte 정수 값으로 바꾼 후 return;
    // token ? => token이란 공백으로 구분되는 단어를 뜻한다
    //               공백(white space)? => space, tab, LF코드
    //               ex) aaa        bbb cc ==> aaa, bbb, cc;
    //                중간에 여러 개의 공백이 들어가더라도 한 개의 공백으로 간주
    
    
    System.out.print("b? ");
    int b = keyboard.nextInt();
    
    System.out.printf("%d * %d = %d",a,b,a*b);
  }
}

/*
 * 
 * 
 */


