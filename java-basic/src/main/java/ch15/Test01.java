// Object 클래스 : java 최상위 class
package ch15;

// 클래스를 정의할 때 수퍼클래스를 지정하지 않으면 
// compiler는 자동으로 Object를 상속받는다 
class My1 /* extends Object */{
  
}

public class Test01 {
  public static void main(String[] args) {
    
    // intanceof 연산자를 사용해 해당 인스턴스가 Object 타입인지 확인
    // intanceof 연산자?
    // ==> 레퍼런스가 가리키는 인스턴스가 지정한 클래스를 인스턴스이거나 조상으로 갖는지 검사
    My1 obj = new My1();
    System.out.println(obj instanceof My1);
    // System.out.println(obj instanceof String); compile error
    System.out.println(obj instanceof Object);
    
    // Object를 조상으로 갖는다면 당연히 Object의 메서드를 사용할 수 있다
    System.out.println(obj.toString());
    System.out.println(obj.hashCode());
    
    // 자바의 모든 클래스는 Object의 자손
    // 자바의 모든 클래스는 Object의 자손
    // 자바의 모든 클래스는 Object의 자손
    // 자바의 모든 클래스는 Object의 자손
    // 자바의 모든 클래스는 Object의 자손
    
  }
}
