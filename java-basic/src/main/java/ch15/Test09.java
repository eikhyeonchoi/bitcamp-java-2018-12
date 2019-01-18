// Object 클래스 : 주요 메서드 - hashCode() 응용
package ch15;

import java.util.HashMap;

public class Test09 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    String k1 = new String("ok");
    String k2 = new String("no");
    String k3 = new String("haha");
    String k4 = new String("ohora");
    String k5 = new String("hul");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중군", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    String k6 = new String("haha");
    // 인스턴스는 다르지만 해시코드는 같다
    System.out.println(k3 == k6);
    System.out.println(k3.hashCode());
    System.out.println(k6.hashCode());
    System.out.println(k3.equals(k6));
    // 결론
    // ==> k3와 k6는 서로 다른 인스턴스 지만
    //      hashCode()의 return 값이 같고 equals()의 리턴이 true
    //        두 객체는 같은 key로 간주
    
    System.out.println(map.get(k6));
    
    // 대소문자 구별해서 Haha != haha이다
    // key가 다름
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
    
  }
}
