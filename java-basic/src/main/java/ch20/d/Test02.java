// hashMap(), HashTable()
package ch20.d;

import java.util.HashMap;
import java.util.Hashtable;

public class Test02 {
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
    Hashtable<String, Student> table = new Hashtable<>();
    
    // HashMap과 HashTable은 기본 사용법이 같음
    map.put("aaa", new Student("홍길동", 20));
    table.put("aaa", new Student("홍길동", 20));
    System.out.println(map.get("aaa"));
    System.out.println(table.get("aaa"));
    
    System.out.println("=========================");
    map.put(null, new Student("임꺽정", 30));
    System.out.println(map.get(null));
    
    // HashTable의 key로 null을 허용하지 않는다 run time exception
    // table.put(null, new Student("임꺽정", 30));
    // System.out.println(table.get(null));
    
    
    
    System.out.println("=========================");
    map.put("ccc", null);
    System.out.println(map.get("ccc"));
    
    // HashTable의 value로 null을 허용하지 않는다 run time exception
    // table.put("ccc", null);
    // System.out.println(table.get("ccc"));
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
