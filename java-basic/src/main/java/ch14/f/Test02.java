// 다형적 변수의 규칙 2 - 형변환
package ch14.f;

import java.sql.Date;

public class Test02 {
  public static void main(String[] args) {
    A obj = new B();
    obj.m1(); // B.m1();
    // obj.m2(); compile error
    
    // 실제 obj에 B 인스턴스 주소가 들어 있다 할지라도
    // 직접 B레퍼런스(obj2)에 저장할 수 없다
    // B obj2 = obj; compile error
    
    // 레퍼런스가 가리키는 실제 타입을 그대로 사용하고 싶다면
    // (obj에 저장된 B클래스를 그대로 사용하고 싶다면)
    // 형변환이 필요하다
    B obj2 = (B) obj; // obj에 들어 있는 주소가 원래 B의 인스턴스이다
                         // 그러니 obj2에 저장하라
    
    obj2.m2();
    System.out.println(obj == obj2);
    
    // 
    A obj3 = new A();
    // A타입의 인스턴스를 B타입의 인스턴스라고 주장하면,
    // 컴파일러는 통과가능, JVM은 오류 발생 ==> ClassCastException
    // B obj4 = (B) obj3; // runtime exception
    
    /*
    B b;
    A a = new A();
    b =(B)a;
    */
    
    
    
    
    
    
    
    
    
    
    
    

  }
}
