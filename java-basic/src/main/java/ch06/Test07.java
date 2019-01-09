// 메서드 - 가변 파라미터 vs 레퍼런스
package ch06;

public class Test07 {
  public static void main(String[] args) {

    // 가변 파라미터는 call하는 쪽에서 배열을 만들 필요가 x
    // java가 자동으로 배열을 만든다.
    plus1();
    plus1(20, 30);
    
    // 레퍼런스는 호출자가 만들어서 넘겨야함
    // 그래서 호출할 때 가변파라미터가 더 편하다
    plus2(new int[] {}); // 빈거라도 만들어서 넣어야함
    plus2(new int[] {10});
    plus2(new int[] {10, 20});
    
    
    
  
  }

  // 가변 파라미터
  static int plus1(int... value) {
    int sum = 0; 
    int sum2 = 0;
    for (int i =0; i < value.length; i++) {
      sum += value[i];
    }
    
    for(int a : value) {
      sum2 +=a;
    }
    
    return sum;
  }
  
  // 레퍼런스 파라미터
  static int plus2(int[] value) {
    int sum = 0; 
    for (int i =0; i < value.length; i++) {
      sum += value[i];
    }
    return sum;
  }
  
  
  
  
}


/*









 */
