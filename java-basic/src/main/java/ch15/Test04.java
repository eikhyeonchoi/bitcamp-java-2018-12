// Object 클래스 : 주요 메서드 - equals()
package ch15;

class My4 /* extends Object */{
  String name;
  int age;
}

public class Test04 {
  public static void main(String[] args) {
    My4 obj1 = new My4();
    obj1.name = "홍길동";
    obj1.age = 20;

    My4 obj2 = new My4();
    obj2.name = "홍길동";
    obj2.age = 20;

    System.out.println(obj1 == obj2);
    // Object에서 상속받은 equals()는 인스턴스가 같은지 비교한다
    // 만약 그 내용물이 같은지 비교하고 싶다면 equals()를 재정의하라
    System.out.println(obj1.equals(obj2));
    
    
  }
}
/*
원래 == 연산자와 Object클래스의 equals() 메서드는 인스턴스를 비교하는 연산이다
My 4 obj1 = new My4();
My 4 obj2 = new My4();를 선언하면 두 인스턴스를 생성하는 것이기 때문에 
==연산을 하든 equals() 연산을 하든 모두다 false로 나온다
하지만 equals()를 overriding 하면 인스턴스를 비교하는 것이 아니라
인스턴스 안에 내용물을 비교하는 것이다 
overriding한 후 
My 4 obj1 = new My4();
My 4 obj2 = new My4();를 선언하면 두 인스턴스 비교시 
== 연산은 false가 나오고 equals()는 true가 나오게 된다 (내용물 모두가 같을시)
hashCode()도 마찬가지임 
대표적으로 hashCode(), equals()를 overriding 한 클래스가
String, Wrapper이다
*/