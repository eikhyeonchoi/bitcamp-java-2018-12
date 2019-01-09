// 흐름제어문 - do ~ while()
package ch05;

public class Test11 {
  public static void main(String[] args) {

    int i = 1;
    
    do {
      System.out.print(i+" ");
    } while (i++ < 10);
    System.out.println();

    i = 0;
    do {
      System.out.print(++i);
      System.out.print(", ");
    } while(i < 10);
    System.out.println();
    
    
    
    
    
    
    
    
    
    
  }
}
/*
 *# do ~ while 문법
 *
 *  do{
 *      문장1;
 *      문장2;
 *      문장3;
 *   }
 *  while (조건);
 *  ==> 한번 이상 실행해야 할 경우 do ~ while() 실행
 *  ==> 최소 한번은 수행함
 *  ==> 한번 이상 수행 하지 않아도 될때는 while()
 *  ==> 대부분 while()문을 사용함
 *
 *
 *
 *
 *
 * 
 * 
 * 
 */
