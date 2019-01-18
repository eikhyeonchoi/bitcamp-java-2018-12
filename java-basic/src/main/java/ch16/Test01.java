// 제네릭(generic) 적용 전 - Object를 이용한 다형적 변수 사용
package ch16;

import java.util.Calendar;
import java.util.Date;

public class Test01 {
  public static void main(String[] args) {
    // echo() 리턴 타입이 Object이기 때문에 String 레퍼런스로 바로 받을 수 없다
    // ==> 형변환이 필요하다
    //String obj = echo(new String("hello")); compile error
    String obj1 = (String) echo(new String("hello"));
    
    // 컴파일은 속일지라도 JVM은 속이지 못한다
    // 잘못된 형변환은 runtime 오류를 발생시킨다
    Integer obj2 = (Integer) echo(new String("hello"));

    Date obj3 = (Date) echo(new Date());
    Calendar obj4 = (Calendar) echo(Calendar.getInstance());
    
  }
  // 제네릭 적용 전
  public static Object echo(Object obj) {
    return obj;
  }
}
