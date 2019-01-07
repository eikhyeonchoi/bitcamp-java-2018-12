// 배열 - 일반 변수를 여러 개 사용할 때와 배열을 사용할 때의 차이점
package ch03; 

public class Test12 {
  public static void main(String[] args) {
    int a1,a2,a3,a4,a5;
    a1=100;
    a2=90;
    a3=80;
    a4=70;
    a5=60;
    
    // 변수의 들어 있는 값의 합계를 구해보자
    int sum1 = a1 + a2 + a3 + a4 + a5;
    
    
    int[] arr1; // java style ==> 이 방식을 선호 이걸로 해야함
    arr1 = new int[5];
    arr1[0] = 100;
    arr1[1] = 90;
    arr1[2] = 80;
    arr1[3] = 70;
    arr1[4] = 60;
    
    // 배열 변수에 들어 있는 값의 합계를 구해보자
    int sum2=0;
    for (int item :arr1) {
      sum2= sum2+item;
    }
    
    // 만명의 점수를 담을 변수 선언한다고 생각하면 무조건 배열 써야함
    
    
  }
}
/*
 * 
 *  
 * 
 */


