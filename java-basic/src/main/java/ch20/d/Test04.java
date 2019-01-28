  // hashMap에서 value목록 꺼내기
package ch20.d;

import java.util.Collection;
import java.util.HashMap;

public class Test04 {
  public static void main(String[] args) {
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
    HashMap<String, Student> map = new HashMap<>();
    
    // HashMap과 HashTable은 기본 사용법이 같음
    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    map.put("ccc", new Student("안중근", 25));
    
    // value목록 꺼내기
    Collection<Student> values = map.values();
    // key는 중복되지 않기 때문에 keySet을 사용하는 것이고
    // value는 중복될 수 있기 때문에 중복되도 되기 때문에 Collection을 사용하는것
    for(Student value : values) {
      System.out.println(value);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
