// java.util.ArrayList사용법 - contains()
package ch20.a;
import java.util.Date;
import java.util.ArrayList;

public class Test04 {
  public static void main(String[] args) {
    class Student {
      String name;
      int age;
      Student(String name, int age) {
        this.name = name;
        this.age = age;
      }
      @Override
      public String toString() {
        return "Student [name=" + name + ", age=" + age + "]\n";
      }
      /* 
      @Override
      public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
      }
       */
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
    ArrayList<Student> list = new ArrayList<>();
    Student s1 = new Student("aaa", 20);
    Student s2 = new Student("bbb", 30);
    Student s3 = new Student("ccc", 40);

    Student s4 = new Student("bbb", 30);

    System.out.println(s2 == s4);
    System.out.println(s2.equals(s4));
    System.out.println(s2.hashCode() ==  s4.hashCode());

    list.add(s1);
    list.add(s2);
    list.add(s3);
    System.out.println(list);

    // contains() : 인스턴스가 다르더라도 equals()의 retrun 이 true면
    // 목록에 있는 것으로 판단한다, ArrayList에서는 hashCode()까진 비교하지 않는다
    // ==> Student 클래스에서 equals()를 오버라이딩 하지 않는다면
    //     list.contains(s4)의 return 값은 false
    System.out.println(list.contains(s2));
    System.out.println(list.contains(s4));

  }
}
