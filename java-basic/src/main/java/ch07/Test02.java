// 클래스 사용 전
package ch07;

public class Test02 {
  public static void main(String[] args) {
    
    
    // 학생 정보를 출력하는 명령어를 별도의 블록으로
    // 정보를 출력하는 명령어를 별도의 블록으로 빼는 이유는 유지보수 하기 쉽게하기 위함
    // 출력 형식을 바꾸고 싶으면 그 블록으로 가면 변경하면 된다.
    // 그런데 출력 명령을 별도로 빼면 그 명령어 블록을 실행하기 위해서는 성적 값을 전달해야함
    // 파라미터를 선언해야함
    String name = "홍길동";
    int kor = 100;
    int eng = 100;
    int math = 100;
    
    // 별도로 뺀 명령어 블록(메서드)를 사용해(호출해) 보자
    printScore(name, kor, eng, math);
    
    // 다양한 종류의 값을 담을수 있는 변수를 제공하진 않지만
    // 대신 여러 종류의 데이터를 묶어  새로운 형태의 데이터 타입을 만들 수 있는 문법제공
    // 그 문법의 이름이 """"" 클 . 래 . 스 """""
    // 클래스란 개발자가 자신이 개발하는 프로그램에서 사용할 특별한 형식의 데이터를 다룰 수 있는
    // 새로운 데이터 타입을 전의하게 해주는 문법이다.
    // primitive data type 외에 새 데이터 타입을 정의할 수 있다.
    // 이렇게 정의한 새 데이터 타입을 "사용자 정의 데이터 타입" 이라고한다.
    
    
  }
  
  static void printScore(String name, int kor, int eng, int math) {
    int sum = kor + eng + math;
    float aver = sum / 3f;
    System.out.printf("%s, %d, %d, %d ,%d, %.1f\n"
        , name, kor, eng, math, sum, aver);
  }
  
}
/*
# 클래스 문법의 활용
1) 사용자 정의 데이터 타입과 그 타입의 값을 다루는 연산자를 정의할 때 사용한다
2) 서로 관련된 일을 하는 메서드를 분류해서 관리하기 쉽게 묶는 용도 사용한다.
 
 
 */





