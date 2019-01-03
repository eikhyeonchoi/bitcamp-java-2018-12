//부동소수점 리터럴의 크기
package ch02;

public class Test05 {
  public static void main(String[] args) {
    
    //부동소수점 9876.54345678
    System.out.println(9876.54345678);
    
   //부동소수점 9876.54345678
    System.out.println(9876.54345678f);

  }
}

/* #부동소수점 리터럴 크기
 * f붙으면 4바이트 안붙으면 8바이트
 *  -4바이트 부동소수점
 *      3.14f = 31.4e-1f = 314e-2f
 *  -8바이트 부동소수점
 *      3.14 = 31.4e-1


*/
