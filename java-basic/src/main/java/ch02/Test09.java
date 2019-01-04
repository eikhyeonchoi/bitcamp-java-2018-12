//문자열 리터럴
package ch02;
public class Test09 {
  public static void main(String[] args) {
    //문자열 3개생성되는거임;
    System.out.println("hello" + "world");
    
    //20과 false가 문자열로 바뀐뒤 합쳐져 새로운 문자열 생성
    System.out.println("나이 : " + 20);
    System.out.println(false + "<====재직자 여부");
    System.out.println("성별 : " + '여');
    System.out.println("키 : " + 170.5f);
    

    
  }
}

/*
 * #문자열
 * -자바의 기본타입이 아니라 객체;
 * -객체란? 여러 데이터들의 덩어리임;
 * -char[] 배열에 유니코드가 저장된다;
 * -표기법 ""(double quote)안에 문자들(문자열)을 작성한다; ex)"hello"
 * -문자열 연결 연산자(concatenation) =  +
 *      +를 이용해 문자열 + 문자열 가능 ==>연결된 문자열이 새로 생성 
 * -문자열과 다른 종류의 값을 연결하기
 *      연결되기전 다른종류의 값이 먼저 문자열로 바뀐다음 연결 
 * 
 */
