// Object 클래스 : 주요 메서드 - equals() 오버라이딩
package ch15;

class My5 /* extends Object */{
  String name;
  int age;
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    My5 other = (My5) obj;
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

public class Test05 {
  public static void main(String[] args) {
    My5 obj1 = new My5();
    obj1.name = "홍길동";
    obj1.age = 20;

    My5 obj2 = new My5();
    obj2.name = "홍길동";
    obj2.age = 20;

    System.out.println(obj1 == obj2);
    // Object에서 상속받은 equals()는 인스턴스가 같은지 비교한다
    // 만약 그 내용물이 같은지 비교하고 싶다면 equals()를 재정의하라
    System.out.println(obj1.equals(obj2));
    
    // 원래 equals()는 인스턴스 비교임 
    // 내용물 비교하도록 ==> overring하면 가능
    // ==> String, Wrapper클래스는 equals()를 이미 overriding함
    // ==> StringBuffer는 equals()를 overriding하지 않아 내용물 비교x
  }
}
