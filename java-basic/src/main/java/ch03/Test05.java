// 레퍼런스
package ch03;

public class Test05 {
  public static void main(String[] args) {
    
    //java.lang.package + 기본데이터타입을ㅇ
    
    java.util.Date d1 = new java.util.Date();
    java.util.Date d2 = new java.util.Date();
    d1 = d2;
    System.out.printf("%d, %d\n",d1.getDate(), d2.getDate());
    
    d1.setDate(22);
    System.out.printf("%d, %d\n",d1.getDate(), d2.getDate());
    // d1에 저장된 일자 값을 변경한 후
    // d2에 저장된 일자 값을 출력하면 d1과 똑같이 변경되어 있다;
    // d1과 d2에 저장되는 것은 값이 아니라 (날짜정보가 저장되어있는 메모리)주소이다;
    // 값을 저장하지 않고 값이 저장된 위치(주소)를 저장하는 변수를 '레퍼런스'라고 부른다;
    // java기본 타입을 제외한 모든 변수는 '레퍼런스'이다;
    // 통장이나 체크카드나 동일한 은행의 계좌(레퍼런스)를 가리키고있음;
    // 통장에서 100만원을 인출하면 계좌는 -100만원이되고 체크카드가 가리키는 계좌도 -100만원으로 동일하게 바뀜;
    // 지갑에도 값과 레퍼런스가 공존함 현금이 값 체크카드가 레퍼런스임
    // java에서도 마찬가지로 값변수(자바 기본 데이터타입) = byte short int long float double char boolean
    //                      레퍼런스 = 자바 기본 데이터타입을 제외한 나머지 모두 (new ~~~);
  }
}

/*
 * 
 */


