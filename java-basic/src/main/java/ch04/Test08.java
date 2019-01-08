// 전위 연산자 - ++a --a
package ch04;
 
public class Test08 {
  public static void main(String[] args) {
    
    int a = 5;
    int r = ++a;
    System.out.printf("%d, %d\n", a, r );
    // r = ++a 연산순서
    // 1) ++a 연산 수행 - a변수의 값을 1 증가시킨다
    // 2) a값을 return  ==> r=6
    // 3) = 할당연산자를 실행 ==> r 변수에 6 assignment
    // 결론!!!!!!
    // 전위 연산자는 변수의 값을 -- or ++한 후 
    // 그 자리에 변수의 밗을 놓는다.
    
    a = 5;
    r = --a;
    System.out.printf("%d, %d\n",a, r);
    // r = --a 연산순서
    // 1) --a 연산 수행 - a변수의 값을 1 감소시킨다
    // 2) a값을 return  ==> r=4
    // 3) = 할당연산자를 실행 ==> r 변수에 4 assignment
    
    a = 5;
    r = --a + --a / --a;
    System.out.printf("%d, %d\n",a, r);
    // r = 4 + --a / --a;
    // r = 4 + 3 / --a;
    // r = 4 + 3 / 2;
    // r + 4 + 1;
    // r = 5 assignment
    
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
