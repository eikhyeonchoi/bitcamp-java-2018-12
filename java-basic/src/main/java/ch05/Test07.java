// 흐름 제어문 - switch문과 break;
package ch05;

public class Test07 {
  public static void main(String[] args) {

    String type = "개발팀장";

    int score = 10;
    // break문을 쓰지 않으면 계속 이어서 실행된다.
    // ==>일부러 쓰지 않는 경우도 있다.
    switch(type) {
      case "개발팀장":
        System.out.println("개발 경력 10년이상 or 석사 이상");
      case "개발자":
        System.out.println("정보처리 자격증");
      case "사무직":
        System.out.println("전문학사 이상");
      default:
        System.out.println("이력서");
    }
    
    switch (score) {
      case 100:
      case 90:
        System.out.println("a");
        break;
      case 80:
      case 70:
        System.out.println("b");
        break;
      case 60:
      case 50:
      case 40:
        System.out.println("c");
        break;
      default :
        System.out.println("f");

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
 */
