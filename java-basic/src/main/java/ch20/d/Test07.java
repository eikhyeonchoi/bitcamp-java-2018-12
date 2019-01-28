// hashMap에서 Iterator를 얻은 후 값을 변경할 때 - 실행 오류 발생
package ch20.d;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test07 {
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
    
    Set<String> keySet = map.keySet();
    
    // Set에서 값을 꺼내기 위해 Iterator의 도움을 받는다
    Iterator<String> iterator = keySet.iterator();
    
    System.out.println(iterator.next());
    
    // Iterator를 사용하는 도중에 Set의 값을 변경하면 
    // 더 이상 Iterator는 유효하지 않다  
    // 따라서 다음과 같이 Iterator를 사용하려하면 실행 오류가 발생한다
    // 해결책?
    // ==> 값을 변경하면 다시 Iterator를 얻어야 한다
    map.put("bba", new Student("bba", 20));
    map.put("bbc", new Student("bbc", 20));
    System.out.println(iterator.next());
    System.out.println(iterator.next());
    
    
    
    
    
    
    
  }
}
