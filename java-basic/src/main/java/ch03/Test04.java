// l-value와 r-value
package ch03;

public class Test04 {
  public static void main(String[] args) {

    int a = 100;
    // 왼쪽편의 a를 l-value; 반드시 메모리가 위치해야함;
    // 오른편의 100을 r-value;
    int b = a;
    System.out.printf("%d, %d\n",a,b);
    
    a = 200;
    System.out.printf("%d",a);
    
    // 100 = 20;  compile error
    // 100 = a; compile error
    
    a = 300; // r-value는 리터럴 ok
    a = b; // r-value는 변수 ok 의미? 변수의 값을 왼쪽 변수에 저장하라는 의미
  }
}

/*
 * # l-value & r-value
 * - l-value : =연산자 왼쪽
 * - r-value : =연산자 오른쪽
 *      int a; 
 *      a = 100;
 * - a=>l-value  100=>r-value;
 * 단 l-value는 반드시 메모리여야 한다
 * 100=a 절대 안됨 
 * 
 * */


