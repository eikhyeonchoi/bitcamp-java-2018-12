// 메서드 - 로컬 변수와 스택 메모리
package ch06;

public class Test10 {
  public static void main(String[] args) {
    
    int value = 0;
    m1(++value);
    System.out.println("main : " + value);

  }
  
  static void m1(int value) {
    m2(++value);
    System.out.println("m1() : " + value);
  }
  
  static void m2(int value) {
    m3(++value);
    System.out.println("m2() : " + value);
  }
  
  static void m3(int value) {
    System.out.println("m3() : " + ++value);
  }
  
  
}

/*
# 스택 메모리
- 'JVM 스택 메모리' 라고 부른다
- 각 스레드 별로 'JVM 스택 메모리'가 있다.
- 메서드를 호출할 때 '프레임'이 생성된다
    프레임 안에 로컬 변수와, 리턴 값, 예외가 발생했다면 예외 정보가 들어있다.
- 메서드 호출이 끝나면 '프레임'은 삭제 된다
- 메인은 제일 마지막에 삭제된다
- 이렇게 메서드가 호출될 때 로컬 변수가 준비되고 제일 마지막에 호출한 
  메세지가 먼저 삭제된다고 해서 '스택' 메모리라고 부른다
-접시 쌓는 것을 생각하라
- 후입 선출 "Last In First Out (LIFO)"

 */
