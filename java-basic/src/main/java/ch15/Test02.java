// Object 클래스 : 주요 메서드 - toString()
package ch15;

class My2 /* extends Object */{}

public class Test02 {
  public static void main(String[] args) {
    
    My2 obj = new My2();
    
    // Object에서 상속받은 메서드
    // 1) toString()
    //      -class 정보를 간단히 출력한다
    //      -package명.class명@16진수해시값
    //      -ex) ch15.My2@5fdef03a
    System.out.println(obj.toString());
    // hash ??
    // -instance마다 부여된 고유의 식별자
    // - 주의! 주소가 아님 주소가 아님 주소가 아님 주소가 아님
    // - 주의! 주소가 아님 주소가 아님 주소가 아님 주소가 아님
    // - 목적 : 인스턴스가 같은지 검사할 때 사용할 수 있다
    // - toString()을 재정의하지 않고 원래 메서드를 그대로 사용하면
    //    무조건 인스턴스마다 새로운 해시값이 부여된다
    
    My2 obj2 = new My2();
    My2 obj3 = new My2();
    
    if (obj2 == obj3) System.out.println("같다");
    else System.out.println("다르다");
    
    System.out.println(obj2.toString());
    System.out.println(obj3.toString());
    
  }
}
