// 흐름제어문 -for 반복문 3
package ch05;

public class Test14 {
  public static void main(String[] args) {

    String[] names = new String[] {"홍길동", "임꺽정", "유관순", "안중근", "윤봉길", "김구"};
    
    for (int i = 0; i < names.length; i++) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
    
    //인덱스 범위조정
    for (int i = 2; i < 4; i++) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
    
    for (int i = 0; i < names.length; i += 2) {
      System.out.print(names[i] + " ");
    }
    System.out.println();
    
    
    
    
  }
}
/*
 * # for 반복문
 * - 배열과 함께 사용할 때 유용
 * 
 * for(변수초기화 ; 조건; 변수증가문){
 *      문장1;
 *      문장2;
 *      문장3;
 * }
 *
 * 
 * 
 * 
 */
