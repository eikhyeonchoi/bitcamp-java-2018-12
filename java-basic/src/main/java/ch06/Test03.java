// 메서드 - 메서드의 리턴값
package ch06;

public class Test03 {
  public static void main(String[] args) {
    // 값을 리턴하는 메서드 호출
    // ==> 리턴 값을 받을 변수를 준비한다.
    // ==> 변수에 리턴 값을 받는다.
    // ==> 리턴 값과 변수의 타입이 같아야한다.
    
    int i ;
    String s;
   
    // i = m1(); compile error ==> 리턴 값의 타입과 변수의 타입이 맞지않다
    s = m1(); // 리턴값의 타입과 변수의 타입이 맞다.
    i = m2();
    System.out.println(s);
    System.out.println(i);
    // 리턴 값을 사용할 일이 없다면 메서드 호출할 때 받지 않아도 된다.
    
    
  }
  
  static String m1() {
    return "홍길동";
  }
  static int m2() {
    return 100;
  }
}
/*









 */
