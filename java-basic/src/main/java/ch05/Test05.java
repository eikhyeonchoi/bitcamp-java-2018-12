// 흐름 제어문 - switch문과 문자열
package ch05;

public class Test05 {
  public static void main(String[] args) {

    String str = "yyyyyyyyyyyyyyyyyyyyyy";
    
    switch(str) {
      case "ok":
        System.out.println("ok");
        break;
      case "no":
        System.out.println("no");
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
