// 메서드 - 가변 파라미터
package ch06;

public class Test06 {
  public static void main(String[] args) {
    
    // 가변 파라미터에 값 전달하기
    // => 0개 이상의 값을 전달한다, 물론 0개도 됨 즉 아규먼트가 0개여도 가능 0개이상이니까
    int result = plus();
    System.out.println(result);
    result = plus(2);
    System.out.println(result);
    result = plus(2,3,4,5,6,7,8,9);
    System.out.println(result);
    
    int[] abc = new int[] {10, 20, 30};
    
    // 가변 파라미터인 경우 값을 배열에 담아서 넘겨도 된다.
    // 어떻게든 배열의 주소만 주면 됨, 물론 값을 줘도됨 위처럼
    // 파라미터에 넘겨 줄 값으로 배열을 바로 만든다
    // 주의 !! ==> 배열이 넘어가는 것이 아니라 배열의 주소를 넘기는것
    result = plus(new int[] {10,20,30});
    // 실행 순서
    // 1) int 배열 3개를 만든다
    //  2) 중괄호{}에 들어 있는 값으로 각 배열 항목을 초기화
    // 3) 배열의 주소를 파라미터의 값으로 놓는다 ==> plus(주소);
    System.out.println(result);
   
    // 배열 레퍼런스가 있는 경우 new int[]를 생략가능하지만 
    // 없으면 생략 불가능하다.
    // result = plus({10,20,30});
    
    
    //----------------------------------------------------
    //----------------------------------------------------
    // 값이 넘어가는 경우는 primitive data type 만 
    // 나머지는 모두 주소가 넘어가는것
    //----------------------------------------------------
    //----------------------------------------------------
  }

  // 같은 타입의 값을 0개 이상 받을 때 가변 파라미터를 사용하라!
  static int plus(int... value) { // 0개 이상의 int값을 받겠다
    // 파라미터 value는 레퍼런스임
    //가변 파라미터는 배열 레퍼런스 처럼 사용
    int sum = 0; // 메서드 안에 선언된 변수를 '로컬변수(local variable)'이라고 한다.
                   // 파라미터도 로컬 변수입니까 => 로컬변수가 맞다.
    for (int i =0; i < value.length; i++) {
      sum += value[i];
    }
    
    return sum;
  }
  
  
  
  
}


/*









 */
