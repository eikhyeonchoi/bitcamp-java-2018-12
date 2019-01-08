// 논리 연산자 : &&, ||, ^
package ch04;
 
public class Test10 {
  public static void main(String[] args) {
    
    // && (AND) 논리 연산자
    // 피연산자 모두 true일때만 결과가 true가 된다
    System.out.println(true && true);
    System.out.println(true && false);
    
    // ||(OR) 논리 연산자
    //  피연산자 둘중 하나라도 true면 결과가 true
    // 둘다 false 일때 false
    System.out.println(true || false);
    System.out.println(false || false);
    
    // ^ (Exclusive OR XOR) 논리 연산자
    // 피연산자가 서로 다를때 true
    System.out.println(true ^ true);
    System.out.println(false ^ false);
    System.out.println(true ^ false);
    
    // 논리 연산자의 피연산자 값은 반드시 true 또는 false 여야만 한다
    //System.out.println(1 &&1); //compile error
    
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
