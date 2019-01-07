// 배열 - 선언과 초기화 시키는 문법
package ch03; 

public class Test13 {
  public static void main(String[] args) {
    
    // 1) reference 변수를 선언한 후 배열 생성
    int[] arr1; // java style ==> 이 방식을 선호 이걸로 해야함
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    
    // 2) reference 변수를 선언할 때 배열 생성하기
    int[] arr2 = new int[5];
    
    // 3) reference 변수를 선언할 때 배열 생서과 값을 초기화 시키기
    //     ==> 초기 값을 설정할 때는 배열의 개수를 지정하면 안된다.
    int[] arr3 = new int[] {100, 100, 90, 90, 60};
    
    // 4) 배열 생성과 동시에 값을 초기화 시킬 때 배열 생성 문법을 생략할 수 있다.
    int[] arr4 = {10,90,80,70,60};
    
    // 5) reference를 별도로 선언한 경우 4)방식으로 초기화 불가
    int[] arr5;
    // arr5 = {90,90,90,90,90}; 초기화 할때만 사용가능 compile error
    // reference를 별도로 선언한 경우 배열 생성 문장을 생략할 수 없다.
    arr5 = new int[] {90,90,90,90,90}; //Ok 생략 불가능

    int[] aaa = new int[4];
    
  }
}
/*
 * 
 *  
 * 
 */


