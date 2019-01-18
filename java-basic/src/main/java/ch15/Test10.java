// Object 클래스 : 주요 메서드 - hashCode() 응용
package ch15;

import java.util.HashMap;

class Key {
  String contents;
  
  public Key(String contents) {
    this.contents = contents;
  }
  
  @Override
  public String toString() {
    return "Key [contents = " + contents + "]";
  }
  
}

public class Test10 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    Key k1 = new Key("ok");
    Key k2 = new Key("no");
    Key k3 = new Key("haha");
    Key k4 = new Key("ohora");
    Key k5 = new Key("hul");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중군", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    
    
    Key k6 = new Key("haha");
    System.out.println(k3 == k6);
    System.out.println(k3.hashCode());
    System.out.println(k6.hashCode());
    System.out.println(k3.equals(k6));
    
    // Object로부터 상속받은 hashCode()를 재정의 하지 않으면
    // Object로부터 상속받은 hashCode()를 재정의 하지 않으면
    // Object로부터 상속받은 hashCode()를 재정의 하지 않으면
    // key로 사용할 일이 없으면 overriding 안해도 된다
    // key로 사용할 일이 없으면 overriding 안해도 된다
    // key로 사용할 일이 없으면 overriding 안해도 된다
    // hashMap 클래스에서 key로 사용하려면 hashCode()와 equals()를 재정의 해야함
    // hashMap 클래스에서 key로 사용하려면 hashCode()와 equals()를 재정의 해야함
    // hashMap 클래스에서 key로 사용하려면 hashCode()와 equals()를 재정의 해야함
    // 인스턴스마다 다른 해시코드 값을 갖기 때문에 해시코드가 다르다고 나옴
    // k3와 k6의 내용물이 같은 "haha"라고 해도 
    // hashCode()의 리턴 값이 다르고 equals()의 비교결과도 false이기때문에
    // hashMap 클래스에서는 서로 다른 key라고 간주
    
    
    System.out.println(map.get(k6));
    
    // 대소문자 구별해서 Haha != haha이다
    // key가 다름
    String k7 = new String("Haha");
    System.out.println(map.get(k7));
    
  }
}
