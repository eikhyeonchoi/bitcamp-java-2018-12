// 흐름 제어문 - switch문
package ch05;

public class Test04 {

  public static void main(String[] args) {

    byte b = 1; // switch 조건문 ok
    short s =1; // switch 조건문 ok
    int i = 1; // switch 조건문 ok
    long l = 1L; // switch 조건문 x
    float f = 1.0f; // switch 조건문 x
    double d = 1.0; // switch 조건문 x
    String str = "Hello"; // switch 조건문 ok
    
    switch(b) {
      case 1:
        System.out.println("11");
        System.out.println("1111");
        break;
        
      case 2:
        System.out.println("22");
        System.out.println("2222");
        break;
        
      case 'a': //return 2byte(UTF-16 code) 정수값
        System.out.println("aa");
        break;
        
      default:
        System.out.println("??");
    }
    
    
    
    
  }
}

/*
 * # switch 문법
 * switch(4byte정수 or 문자열) {
 *  case 4byte정수 or 문자열:
 *      문장1;
 *      문장2;
 *      break;
 *  case 4byte정수 or 문자열:
 *      문장1;
 *      문장2;
 *      break;
 *  default:
 *      위의 조건에 해당되는 것이 없으면 이 문장실행;
 * }
 * 
 * 
 * 
 */
