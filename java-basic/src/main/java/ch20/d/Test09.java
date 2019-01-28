  // hashtable에서 value목록 꺼내기 - 2 elements 
package ch20.d;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Hashtable;

public class Test09 {
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
    Hashtable<String, Student> map = new Hashtable<>();
    
    // HashMap과 HashTable은 기본 사용법이 같음
    map.put("aaa", new Student("홍길동", 20));
    map.put("bbb", new Student("임꺽정", 30));
    
    Student s = new Student("안중근", 25);
    map.put("ccc", s);
    map.put("ddd", s);
    // value목록 꺼내기
    Enumeration<Student> values = map.elements();
    while(values.hasMoreElements()) {
      System.out.println(values.nextElement());
    }
  }
}

/*
                     (list)                    (set)                      (map)
1)중복저장                  ok                       no                  key불가능 value가능
2)null허용                ok                    ok(한개만)               map가능, table불가능
3)

























 */





























