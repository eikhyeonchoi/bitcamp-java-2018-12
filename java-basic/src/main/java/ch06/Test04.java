// 메서드 - 메서드의 리턴값
package ch06;

public class Test04 {
  public static void main(String[] args) {
    
    String str = greet("홍길동");
    System.out.println(str);
    
    int res = plus(10,20);
    System.out.println(res);
  }
  
  static String greet(String name) {
    return name + "님 반갑습니다.";
  }
  static int plus(int a, int b) {
    return a+b;
  }
}
/*









 */
