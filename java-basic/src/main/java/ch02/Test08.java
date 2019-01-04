//논리 리터럴
package ch02;
public class Test08 {
  public static void main(String[] args) {
    System.out.println(true);
    System.out.println(false);
    //System.out.println((boolean)1); //정수값을 boolean(true, false)으로 compile할 수 없음
    
    //작은 따옴표(single quote)의 리턴값은 2바이트 정수 값(UTF-16코드)
    if('가' == 0xac00) { //==연산 결과는 true/false;
      //코드값을 적을때는 16진수를 사용 0xac00 으로 적음 44~~~x
      System.out.println("맞");
    } else {
      System.out.println("아니다");
    }
    
    /* c언어에서는 error가 안나지만 java에서는 compile error
     * c언어에서는 0 =false 나머지 true;
    if(10-10) {
      
    } else {
      
    }
    */

   
    
    
    
    
  }
}

/*
 * #논리 리터럴
 * -자바는 참true, 거짓false을 표현하는 키워드를 제공 
 * -배열 값인 경우 1바이트 메모리에 저장
 * 
 * #논리값 저장
 * -4바이트int 메모리 저장
 * -true =1, false =0;
 * -직접 정수값 지정x <=이건 c언어만
 */
