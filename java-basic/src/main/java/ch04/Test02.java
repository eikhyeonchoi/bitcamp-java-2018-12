//산술연산자 - data type과 연산자
package ch04;

public class Test02 {

  public static void main(String[] args) {
    
    // data type에 따라 제공되는 연산자가 다르다.
    System.out.println(5.75 % 0.24); // 부동소수점 산술연산 ok!
    
    //System.out.println(true % false);// boolean type에 대해서는 산술연산x
    //System.out.println(true + true);
    
    System.out.println("hello,"+" world!"); // +연산자가 문자열 연결용도로 사용
    //System.out.println("hello,"-"o,"); // compile error
    //System.out.println("hello" * 5); // compile error
    
    System.out.println(true && true);
    //System.out.println(10 && 10); // compile error
    
    
    
  }
}
