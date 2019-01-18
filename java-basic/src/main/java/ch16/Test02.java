// 제네릭(generic) 적용 전 - Object를 이용한 다형적 변수 사용할 때 형변환이 불편
package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test02 {
  public static void main(String[] args) {
    // echo()의 return 값을 원하는 타입으로 받기 위해 형변환 해야하는 일이 번거롭다
    // 해결책?
    // 각타입의 대해 echo()를 만들기
    String obj1 = echo(new String("hello"));
    Date obj3 = echo(new Date());
    Calendar obj4 = echo(Calendar.getInstance());
    // 이렇게 각 타입에 맞는 echo()를 정의하면 형변환할 필요 없어 사용하기 편하다
    // 타입이 존나게 많으면 존나게 노답임 다 같은 기능인데 타입만 return 타입만 달라 개씹비효율
    
    // Object를 다형적 변수를 이용한 방법과 각 메서드를 타입별로 만들어
    // 형변환을 하지 않는 이점을 모두 취할 수 있는 문법이 generic이다
    // 
  }
  // 제네릭 적용 전
  public static String echo(String obj) {
    return obj;
  }
  public static Date echo(Date obj) {
    return obj;
  }
  public static Calendar echo(Calendar obj) {
    return obj;
  }
}
