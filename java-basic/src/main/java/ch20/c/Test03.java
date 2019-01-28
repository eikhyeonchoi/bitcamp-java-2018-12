// java.util.Set 클래스 사용법 - add()와 hashCode(), equals() - 2
package ch20.c;
import java.util.HashSet;
import java.util.Iterator;

public class Test03 {

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
      
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
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
        Student other = (Student) obj;
        if (age != other.age)
          return false;
        if (name == null) {
          if (other.name != null)
            return false;
        } else if (!name.equals(other.name))
          return false;
        return true;
      }
      
      
    }
    
    HashSet<Student> set = new HashSet<>();

    // set의 값 추가하기
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));
    set.add(new Student("ccc", 40));
    
    // Set은 집합의 특성을 따른다
    // ==> 같은 값을 중복해서 넣을 수 없다
    // ==> 같은 값인지 판단하는 기준은?
    //     equals()의 return값이 true인지 여부
    //     hashCode()의 return값이 true인지 여부
    // ==> 현재 Student 로컬클래스는 equals()와 hashCode()를 오버라이딩 했다
    //     따라서 인스턴스는 다르지만 equals()이 true이고, hashCode()의 return 값도 같기때문에 
    //     중복하여 저장하지 않는다 
    //     기준이 equals(), hashCode() return값임
    // ==> HashSet에서 값을 저장할 때 그 위치는
    //     hasCode()의 return값으로 결정된다
    set.add(new Student("aaa", 20));
    set.add(new Student("bbb", 30));
    
    
    Iterator<Student> iterator = set.iterator();
    while(iterator.hasNext()) {
      System.out.println(iterator.next());
    }
    
    
    // 출력 결과를 보면 입력 순서로 꺼낼 수 없다
    // 이유?
    // ==> 저장할 때 각 인스턴스의 대해 hashCode()의 return값으로
    //     위치를 정하기 때문이다
    System.out.println("========================");
    Object[] values = set.toArray();
    for(Object value : values) {
      System.out.println(value);
    }
    
    
    System.out.println("========================");
    // 입력한 값의 타입으로 배열을 받고 싶다면?
    // ==> 파라미터로 넘겨 준 배열이 값을 담을 만큼 크지않다면, 새 배열을 만들어 return
    Student[] values2 = set.toArray(new Student[0]);
    for(Object value : values2) {
      System.out.println(value);
    }
    
    
    
    
    
    
    
  }
}
