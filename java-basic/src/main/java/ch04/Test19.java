// 비트 연산자 응용
package ch04;
 
public class Test19 {
  public static void main(String[] args) {
    //l 한 개의 정수 값에 여러 개의 정보를 저장하기
    //l ==> 비트의 1 또는 0을 이용해 정보를 표현할 수 있음
    
    //l 예를 들어 개발자가 프로그래밍 가능한 언어를 int로 표현
    //l Java        : 0000 0000 0000 0001 = 0x0001
    //l C           : 0000 0000 0000 0010 = 0x0002
    //l C++         : 0000 0000 0000 0100 = 0x0004
    //l Python      : 0000 0000 0000 1000 = 0x0008
    //l Php         : 0000 0000 0001 0000 = 0x0010
    //l Kotlin      : 0000 0000 0010 0000 = 0x0020
    //l Groovy      : 0000 0000 0100 0000 = 0x0040
    //l JavaScript  : 0000 0000 1000 0000 = 0x0080
    //l TypeScript  : 0000 0001 0000 0000 = 0x0100
    //l GO          : 0000 0010 0000 0000 = 0x0200
    //l SQL         : 0000 0100 0000 0000 = 0x0400
    //l R           : 0000 1000 0000 0000 = 0x0400
    
    //l java, c, c++, js
    int d1 = 0x0001 | 0x0002 | 0x0004 | 0x0080; // 0000 0000 1000 0111
    int d2 = 0x0087;
    
    System.out.println(d1);
    System.out.println(d2);
    
    //l 정수 값에서 특정 비트의 값만 검사하는 방법
    //l 0000 0000 0001 0111 설정값
    //l TypeScript 언어를 할줄 아는지 검사
    //l 0000 0000 0001 0111 설정값
    //l 0000 0001 0000 0000 & 연산 ㄱ
    //l ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    //l 0000 0000 0000 0000 결과값
    //l 0000 0001 0000 0000 TypeScript여부 조사값
    //l 결과값과 조사값이 같지 않으면 해당비트가 0이라는 의미이다
    
    
    System.out.printf("java       : %b\n",(d1 & (0x0001)) == 0x0001);
    System.out.printf("c          : %b\n",(d1 & (0x0002)) == 0x0002);
    System.out.printf("c++        : %b\n",(d1 & (0x0004)) == 0x0004);
    System.out.printf("Python     : %b\n",(d1 & (0x0008)) == 0x0008);
    System.out.printf("Php        : %b\n",(d1 & (0x0010)) == 0x0010);
    System.out.printf("Kotlin     : %b\n",(d1 & (0x0020)) == 0x0020);
    System.out.printf("Groovy     : %b\n",(d1 & (0x0040)) == 0x0040);
    System.out.printf("JavaScript : %b\n",(d1 & (0x0080)) == 0x0080);
    System.out.printf("TypeScript : %b\n",(d1 & (0x0100)) == 0x0100);
    System.out.printf("GO         : %b\n",(d1 & (0x0200)) == 0x0200);
    System.out.printf("SQL        : %b\n",(d1 & (0x0400)) == 0x0400);
    System.out.printf("R          : %b\n",(d1 & (0x0800)) == 0x0800);
    
    
  }
}
