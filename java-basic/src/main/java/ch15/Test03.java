// Object 클래스 : 주요 메서드 - toString()을 오버라이딩 할때
package ch15;

class My3 /* extends Object */{
  String name;
  int age;
  
  // 개발을 하다보면 인스턴스의 현재 값을 간단히 확인하고 싶을 경우 있음
  // 그럴경우 toString()을 오버라이딩 하라
  @Override
  public String toString() {
    return "My3 [name=" + name + ", age=" + age + "]";
  }
  
  
}

public class Test03 {
  public static void main(String[] args) {
    My3 obj = new My3();
    obj.name = "홍길동";
    obj.age = 20;

    System.out.println(obj.toString());
    // println()의 파라미터 값으로 문자열을 넘겨주지 않으면
    // 내부에서 파라미터로 넘어온 객체에 대해 tostring() 호출한 후
    // 그 리턴 값을 출력한다
    // 따라서 그냥 객체(주소)를 넘겨줘도 된다
    
  }
}
