// 후위 연산자 - a++ a--
package ch04;
 
public class Test09 {
  public static void main(String[] args) {
    
    int a = 5;
    int r = a++;
    System.out.printf("%d, %d\n", a, r );
    // 변수의 값을 먼저 그 자리에 놓고 
    // 그 후 변수의 값을 증가 시킨다
    // r = a++;
    // r = 5; ==> 주의! 변수에 값을 놓기만 할 뿐 아직 assignment 수행x
    //              assignment은 r-value를 처리 한후 맨 마지막에 처리
    // a++실행 ==> a = 6
    // assignment 실행 => r변수에 5 assignment
    
    a = 5;
    r = a++ + a++ * a++;
    System.out.printf("%d, %d\n",a, r);
    // r = a++ + a++ * a++;
    // r = 5 + a++ * a++; ==> a=6
    // r = 5 + 6 * a++ ==> a=7
    // r + 5 + 6 * 7 ==> a=8
    
    a = 5;
    a = a++;
    System.out.println(a);
    
    
  }
}







/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
