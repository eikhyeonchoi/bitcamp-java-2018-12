// 커스텀 key사용
package ch20.d;

import java.util.Enumeration;
import java.util.HashMap;

public class Test10 {
  public static void main(String[] args) {
    class Key {
      int major;
      int minor;
      public Key(int ma, int mi) {
        this.major = ma;
        this.minor = mi;
      }
      
      @Override
      public String toString() {
        return "Key [major=" + major + ", minor=" + minor + "]";
      }
    }
    
    class Student {
      String name;
      int age;
      public Student(String name, int age) {
        this.name = name;
        this.age = age;
      }
      
      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
      }
    }
    
    Key k1 = new Key(100, 1);
    Key k2 = new Key(100, 2);
    Key k3 = new Key(100, 3);
    
    HashMap<Key, Student> map = new HashMap<>();
    
    // HashMap과 HashTable은 기본 사용법이 같음
    map.put(k1, new Student("홍길동", 20));
    map.put(k2, new Student("임꺽정", 30));
    map.put(k3, new Student("윤봉길", 20));
    
    System.out.println(map.get(k1));
    System.out.println(map.get(k2));
    System.out.println(map.get(k3));
    
    Key k4 = new Key(100,2);
    System.out.println(map.get(k4));
    // 오버라이드 하지 않았기 때문에 key로 사용할 수 없음
    
    System.out.println(k2 == k4);
    System.out.println(k2.hashCode() == k4.hashCode());
    System.out.println(k2.equals(k4));
    
    // 저장할 때
    // ==> Key 객체의 hashCode() 리턴 값으로 위치를 계산하여 저장한다
    // 값을 꺼낼 때
    // ==> Key 객체의 hashCode() 리턴 값으로 위치를 계산한다
    // ==> Key 객체의 equals()의 리턴 값으로 같은 key인지 검사한다
    // 결론,,,,,,,,,
    // 위 k2와 k4는 비록 인스턴스가 다르더라도  인스턴스 필드의 값은 같다 
    // hashCode()값이 다르기 때문에 위치 계산 결과도 다르고,
    // equals()의 리턴 값이 false이기 때문에 다른 key로 인식한다
    // ==> 그래서 k2로 저장한 값을 k4로 꺼낼 수 없다
    // 해결책 ?
    // ==> 인스턴스가 다르더라도 인스턴스 필드의 값이 같을 때는
    // ==> hashCode()의 return 값을 같게하고 equals()의 return값을 true로 하라
    
    
  }
}

/*
                     (list)                    (set)                      (map)
1)중복저장                  ok                       no                  key불가능 value가능
2)null허용                ok                    ok(한개만)               map가능, table불가능
3)

























 */





























