package com.company.product00;

public class about_method {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    m1();
    m2(500, 200);
    System.out.println(m3());
    System.out.println(m4("최익현"));
    
  }
  
  static void m1() {
    System.out.println("hello");
  }
  // parameter X, return X

  static void m2(int a, int b) {
    System.out.printf("%d, %d\n", a, b);
  }
  // parameter O, return X
  
  static String m3() {
    return "안녕하세요";
  }
  // parameter X, retirn O
  
  static String m4(String a) {
    return a + "님 반갑습니다";
  }
  // parameter O, return O
  
}

/*
  - 메서드는 특정 기능을 수행하는 명령어를 모아둔 블록이다 (메서드 시그니쳐와 메서드 블록으로 구성된다)
  - 문법
    1) void 메서드명() {문장1;, 문장2;}
     2) void 메서드명(파라미터1, 파라미터2, ...) {문장1; 문장2;};
     3) returnType 메서드명() {문장1; 문장2; return returnType값;}
     4) returnType 메서드명(파라미터1, 파라미터2, ...) {문장1; 문장2; return returnType값;}
      
  - 메서드 블록을 메인함수에서 수행시키는 것을 메서드 콜 이라고 부른다.
  - 메서드 콜을 할때 메서드의 parameter와 메서드 call의 아규먼트의
    타입, 갯수, 순서가 같아야 메서드 콜을 할 수 있다
  - return이 존재하는 메서드는 메인에서 값을 받아도 되고 안받아도 된다
  - parameter는 변수가 넘어가는 것이 아니라 변수의 값이 넘어가는 것
  
 
 
 */
