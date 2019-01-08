// 흐름제어문 - 반복문 while과 break, continue
package ch05;

public class Test09 {
  public static void main(String[] args) {
    
    int a = 1;
    while(a <= 10) {
      System.out.print(a +" ");
      a++;
      if(a > 5) break; //반복문을 멈추고 나간다.
    }

    System.out.println();
    a = 1;
    while(a <= 10) {
      if(a % 2 == 0 ) { 
        // 조건문을 만족하면 즉 짝수면 다음 코드를 실행하지 않고
        // while 조건문으로 바로 올라 간다.
        a++;
        continue;
      }
      System.out.print(a+" ");
      a++;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}




/*
 *# while 문법
 *while(조건) 문장;
 *while(조건) {
 *  문장1;
 *  문장2;
 *}
 *
 *
 *
 *
 *
 *
 * 
 * 
 * 
 */
