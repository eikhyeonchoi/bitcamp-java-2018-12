// 클래스 로딩과 클래스 필드 생성
package ch08;

class My2 {
  // 클래스 필드
  static String manager = "관리자";
  static String member = "회원";
  static String guest = "손님";

  // 인스턴스 필드
  String name;
  int age;
  String userType;
}


public class Test02 {
  public static void main(String[] args) {

    
    System.out.println(My2.manager);
    // ==> My2는 클래스 인데도 new 명령을 실행 하지 않아도
    //      바로 My2.manager를 사용할 수 있기 때문에
    //      그럼 static 변수는 클래스를 로딩할때 로딩하는 것
        
    
    // 클래스 로딩 과정
    //      $ java Test02
    // 1) Test02.class를 "method area 영역"를 로딩한다
    // 2) Test02의 main() 메서드를 호출한다
    // 3) main() 메서드에 선언된 로컬 변수를 "JVM 스택 영역"에 생성
    // 4) main() 메서드의 코드를 실행
    //          - My2.class를 method area에 로딩
    //          - My2의 클래스 필드를 method area에 생성
    //          - sysout 실행
    //          - c
    //
    //
    
    // 5) new 명령에 따라 "힙 영역"에 인스턴스 필드를 생성한다



  }
}



/*
# 클래스 로딩
- 외부 저장장치(ex. HDD, USB 등)에 있는 .class 파일을 
  JVM이 관리하는 메모리로 로딩하는 것

# JVM이 관리하는 메모리 영역
1) heap
    - new 명령으로 생성한 인스턴스가 놓인다
     - 인스턴스 필드가 이 영역에 생성
     - 가비지 컬렉터는 이 메모리의 가비지들을 관리
2) JVM stack
    - 스레드마다 개인적으로 관리하는 메모리 영역이다
    - 스레드에서 메서드를 호출할 때 메서드의 로컬 변수를 이 영역에 만든다
    - 메서드가 호출될 때 그 메서드가 사용하는 로컬 벼수를 프레임에 담아 만듬
    - 메서드 호출이 끝나면 그 메서드가 소유한 프레임 삭제
3) method area
    - JVM이 실행하는 바이트코드(.class파일)를 두는 메모리 영역
    - JVM은 코드를 실행할 때 이 영역에 놓은 명령어를 실행하는것
    - 주의! heap에는 개발자가 작성한 명령어가 없다
    - 개발자가 작성한 class, method 등 이런 코드들이 이 영역에 놓이는것
    - static 필를 이 영역에 생성한다.
    
# 클래스 로딩
- 클래스의 코드를 사용하는 시점에 메모리(method aread 영역)에 로딩된다
- 한번 로딩되면 JVM을 종료할 때까지 유지한다
- 강제로 unloading 할 수 있다, 다시 loading 할 수도 있다

# 클래스의 코드를 사용하는 시점?
- static 멤버(필드와 메서드)를 사용할 때
    ex) My2.member = 200;
    ex) System.out.println("My2.member");
    ex) Integer.parseInt(...);
- new 명령을 사용하여 인스턴스를 생성할 때
    ex) new My2();
- 레퍼런스 변수를 선언할 때는 클래스를 로딩하지 않는다
    My2 obj1;

*/



















