// 메서드 - 메서드와 파라미터
package ch06;

public class Test02 {
  public static void main(String[] args) {
    
    // 파라미터가 있는 명령어 블록을 사용하기
    // => 파라미터가 있는 메서드를 호출하기
    // => 파라미터가 있는 메서드 호출하기
    
    // 파라미터가 있는 메서드를 호출하려면 반드시 그 파라미터가 원하는
    // 타입의 값을 넘겨줘야한다 또 순서도 지켜야한다, 갯수도 일치해야함
    // m1(); compile error ==> 파라미터 없음
    // m1(20, "홍길동"); compile error ==> 파라미터 순서가 안맞음
    // m1(20, 30); compile error ==> 파라미터 data type이 안맞음
    // m1("홍길동", 20, 30) compile error ==> "홍길동", 20의 타입은 맞지만 개수가 일치하지않음
    // 파라미터의 갯수, 타입, 순서가 일치해야 메서드 콜 가능
    m1("홍길동", 20);
    m1("유관순", 30);
    m1("임꺽정", 40);
    
    // 이렇게 메서드를 호출할 때 파라미터에 넘겨 주는 값을 "아규먼트라고 한다"ㄴ
    
  }
  
  // 외부에서 값을 받아 실행하는 메서드는
  // 그 값을 담을 변수를 메서드 정의에 선언해야한다.
  // 이렇게 외부에서 값을 받는 변수를 '파라미터(parameter)' 라고 부른다.
  static void m1(String name, int age) {
    System.out.printf("이름: %s\n", name);
    System.out.printf("이름: %d\n", age);
    System.out.println();
  }
}
/*
 # 메서드 
  -특정 기능을 수행하는 명령어들을 모아둔 블럭
  -문법
  1) 명령어 블록을 실행할 때 값을 넘겨주지 않고 결과도 넘겨 받지 않는다;
     void 메서드명() {
       문장1;
       문장2;
     }

   2) 명령어 블록을 실행할 때 값을 넘겨준다. 그러나 결과는 받지 않는다. 
     void 메서드명(변수선언1, 변수선언2, ...._) {
       문장1;
       문장2;
      }

   3) 명령어 블록을 실행할 때 값을 넘겨주지 않는다. 결과는 받는다
     리턴타입 메서드명() {
       문장1;
       문장2;
      }

   4) 명령어 블록을 싱핼 때 값을 넘겨주고 결과는 받는다
      리턴타입 메서드명 (변수선언1, 변수선언2, ...) {
         문장1;
         문장2;
       }



















 */
