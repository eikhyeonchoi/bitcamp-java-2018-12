// Object 클래스 : 주요 메서드 - hashCode() 응용 사용자가 만든 클래스를 key로 사용하기
// Object 클래스 : 주요 메서드 - hashCode() 응용 사용자가 만든 클래스를 key로 사용하기
// Object 클래스 : 주요 메서드 - hashCode() 응용 사용자가 만든 클래스를 key로 사용하기
// hashCode()와 equals()오버라이딩 하기
// hashCode()와 equals()오버라이딩 하기
// hashCode()와 equals()오버라이딩 하기
// hashCode()와 equals()오버라이딩 하기
package ch15;

import java.util.HashMap;

class Key2 {
  String contents;
  
  public Key2(String contents) {
    this.contents = contents;
  }
  
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((contents == null) ? 0 : contents.hashCode());
    return result;
  }

  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Key2 other = (Key2) obj;
    if (contents == null) {
      if (other.contents != null)
        return false;
    } else if (!contents.equals(other.contents))
      return false;
    return true;
  }
  

  @Override
  public String toString() {
    return "Key [contents = " + contents + "]";
  }
  
}

public class Test11 {
  public static void main(String[] args) {
    HashMap map = new HashMap();
    
    Key2 k1 = new Key2("ok");
    Key2 k2 = new Key2("no");
    Key2 k3 = new Key2("haha");
    Key2 k4 = new Key2("ohora");
    Key2 k5 = new Key2("hul");
    
    map.put(k1, new Student("홍길동", 20, false));
    map.put(k2, new Student("임꺽정", 30, true));
    map.put(k3, new Student("유관순", 17, true));
    map.put(k4, new Student("안중군", 24, true));
    map.put(k5, new Student("윤봉길", 22, false));
    
    System.out.println(map.get(k3));
    
    
    
    Key2 k6 = new Key2("haha");
    System.out.println(k3 == k6);
    System.out.println("k3 hashCode "+k3.hashCode());
    System.out.println("k6 hashCode "+k6.hashCode());
    System.out.println("k3.equals() "+k3.equals(k6));
    
    
    System.out.println("k6 haha "+map.get(k6));
    
    // 대소문자 구별해서 Haha != haha이다
    // key가 다름
    Key2 k7 = new Key2("Haha");
    System.out.println("k7 Haha "+map.get(k7));
    
  }
}
