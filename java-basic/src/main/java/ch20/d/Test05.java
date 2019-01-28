  // hashMap에서 key, value함께 꺼내기
package ch20.d;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Test05 {
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
    
    // key, value 목록 같이 꺼내기
    Set<Entry<String, Student>> entrySet = map.entrySet();
    for(Entry<String, Student> entry : entrySet) {
      System.out.printf("%s => %s\n", entry.getKey(), entry.getValue());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  }
}
