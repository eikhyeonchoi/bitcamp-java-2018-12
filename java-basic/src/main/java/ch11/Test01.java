// String 클래스 사용법
package ch11;

public class Test01 {
  public static void main(String[] args) {
    
    // String 레퍼런스
    // ==> String은 java primitive 타입이 아니라 클래스이다
    String s1; // s1은 String 인스턴스 주소를 담는 레퍼런스이다
    
    // Strin 인스턴스
    s1 = new String("Hello"); // heap에 hello 문자코드를 저장할 메모리를 만들고 주소 return
    
    String s2 = new String("Hello");
    
    if(s1==s2) {
      System.out.println("같다");
    } else System.out.println("다르다");
    
  }
}
