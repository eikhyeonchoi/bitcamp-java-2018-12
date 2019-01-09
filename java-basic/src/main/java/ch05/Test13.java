// 흐름제어문 -for 반복문 2
package ch05;

public class Test13 {
  public static void main(String[] args) {

    // 변수초기화 시키는 문장에 여러개의 변수를 선언할 수 있다
    // 변수 증가문에 여러개의 문장을 작성할 수 있다.
    for (int i = 1, j = 3, k = 5; i <=10; i++, k--, j+=2) {
      System.out.printf("(%d, %d, %d)", i, j, k);
    }
    System.out.println();

    
    // for 문의 중첩
    for (int i = 1; i <= 10; i++) {
      for (int j =1; j <= i; j++) {
        System.out.print(j+" ");
      }
      System.out.println();
    }
    System.out.println("-----------------------------");
    
    
    // break
    for (int i = 1; i <= 10; i++) {
      for (int j =1; j <= i; j++) {
        System.out.print(j+" ");
        if (j == 5) break; // break가 소속된 현재 반복문을 멈춘다.
      }
      System.out.println();
    }
    System.out.println("-----------------------------");
    
    
    // break 라벨명;
    loop1:
    for (int i = 1; i <= 10; i++) {
      for (int j =1; j <= i; j++) {
        System.out.print(j+" ");
        if (j == 5) break loop1; // 라벨이 붙은 반복문을 나간다.
      }
      System.out.println();
    }
    System.out.println("-----------------------------");
    
    
    
    for (int i = 1; i <= 10; i++) {
      for (int j =1; j <= i; j++) {
        if (j % 2 == 0) 
          continue; // 다음 줄로 가지 않고 변수 증가문으로 이동
        System.out.print(j+" ");
      }
      System.out.println();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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
