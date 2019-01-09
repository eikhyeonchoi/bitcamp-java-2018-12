// 메서드 - 메서드 중첩 호출
package ch06;

public class Test05 {
  public static void main(String[] args) {

    // 2 + 3 + 4 + 5;
    int res = plus(2, 3);
    res = plus(res, 4); // res 변수가 넘어가는 것이 아니라 res 변수의 값이 넘어 간다.
    res = plus(res, 5);
    System.out.println(res);

    res = plus(plus(plus(2, 3), 4), 5);
    // 실행과정 - 메서드를 중첩하면 가장 안쪽 메서드부터 콜(실행)
    // res = plus(plus(5, 4), 5);
    // res = plus(9, 5);
    // res = 14;
    System.out.println(res);
    
    System.out.printf("100 + 200 = %d\n",plus(100, 200));


  }

  static int plus(int a, int b) {
    return a+b;
  }

}

/*









 */
