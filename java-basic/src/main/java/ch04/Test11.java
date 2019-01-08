// 논리 연산자 : &, |
package ch04;
 
public class Test11 {
  public static void main(String[] args) {
    
    // 피연산자가 boolean type일때는 &&, ||와 동일하게 수행
    // & (AND) 논리 연산자
    // 피연산자 모두 true일때만 결과가 true가 된다
    System.out.println(true & true);
    System.out.println(true & false);
    
    // |(OR) 논리 연산자
    //  피연산자 둘중 하나라도 true면 결과가 true
    // 둘다 false 일때 false
    System.out.println(true | false);
    System.out.println(false | false);
    
    // 피연산자가 정수일 때는 비트연산을 수행한다 & = and, | = or
    int a = 0xca; // 0000 0000 0000 0000 0000 0000 1100 1010
    int b = 0x66; // 0000 0000 0000 0000 0000 0000 0110 0110
    System.out.println(a & b);
    System.out.println(a | b);

    // 1100 1010
    // 0110 0110
    // & = and  => 0100 0010
    // | = or => 1110 1110
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
