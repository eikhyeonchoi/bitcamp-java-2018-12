// Wrapper 클래스
package ch11;

import java.util.Date;

public class Test09 {
  public static void main(String[] args) {

    // 자바는 primitive type의 값을 좀 더 정교하게 제어할 수 있도록
    // 자바 원시 타입의 각각에 대응하는 클래스를 제공한다
    // Wrapper class 라 부른다 (java.lang 패키지 소속)
    // 기본타입에 첫글자 대문자로 바꿈(클래스)
    // Byte, Short, Integer, Long, Float, Double, Boolean, Char 클래스

    // wrapper 클래스의 생성자가 deprecated 상태임.
    // 가능한 생성자를 사용하여 인스턴스를 생성하지 말라
    // deprecated(비난받는) 사용하지 않는 것이 좋다고 결정, 가까운 장래에 제거될 것이라는 의미
    // 가능한 사용하지 말자 
    // Integer i1 = new Integer(100);
     Integer i1 = Integer.valueOf(100);
     
     // Character c1 = new Character('가');
     char c = Character.valueOf('가');
     
     // wrapper 클래스는 해당 값을 다루는 다양한 메서드를 제공한다
     byte b = i1.byteValue(); // int를 byte로 변환하여 리턴하는 메서드
     String s = i1.toString(); // int를 String 인스턴스로 리턴하는 메서드
     String str = Integer.toHexString(200); // int를 16진수로 변환해 문자열로 리턴하는 메서드
     
     // wrapper 클래스의 가장 큰 목적 
     // ==> primitive 값을 포함하여 모든 값을 쉽게 주고 받기 위함이다
     // wrapper 클래스를 사용하지 않으면 다음과 같이 각 타입의 값을 처리할 메서드를 
     // 여러개 만들어야 한다
     printInt(100);
     printFloat(3.14f); // 파라미터가 primitive type이라 주소를 넘길 수 없다
     // printInt("hello"); compile error
     
     // wrapper 클래스를 사용하면 primitive type도 인스턴스로 다룰 수 있기 때문에
     // primitive 데이터를 다루는 메서드를 여러개 만들 필요xxxxxxx
     Integer x = Integer.valueOf(1000);
     Float y = Float.valueOf(3.14f); // primitive값을 인스턴스로 만들어 넘길 수 있다
     System.out.println();
     
     String z = "hello";
     Date today = new Date();
     
     printObject(x); // primitive 값을 인스턴스에 담아서 넘길 수 있다
     printObject(y); // 이것이 wrapper클래스가 필요한 이유이다
     printObject(z);
     printObject(today);
     int[] asd = new int[10];
     Date[] date = new Date[10];
     date[0] = new Date();
     printObject(date);
     printObject(date[0]);
  
  }

  static void printInt(int i) {
    System.out.println("값 => "+ i);
  }
  static void printFloat(float f) {
    System.out.println("값 => "+ f);
  }
  static void printObject(Object o) {
    System.out.println("값 => "+o.toString());
    
  }
  
}
