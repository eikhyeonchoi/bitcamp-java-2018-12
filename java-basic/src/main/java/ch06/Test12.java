// 메서드 - 재귀호출
package ch06;

public class Test12 {
  public static void main(String[] args) {
    
    int result = sum1(5, sum1(4, sum1(3, sum1(2, sum1(1, 0)))));
    
    int result2 = 0;
    result2 = sum1(result2, 1);
    result2 = sum1(result2, 2);
    result2 = sum1(result2, 3);
    result2 = sum1(result2, 4);
    result2 = sum1(result2, 5);
    System.out.println(result2);
    
    // 위의 알고리즘(결과를 내는)은 다음 수학 공식과 같다
    // sum(n) = n +sum(n-1)
    System.out.println(sum2(5));
  }
  
  static int sum1(int a, int b) {
    return a + b;
  }
  
  static int sum2(int n) {
    if (n == 1)
      return n;
    
    // 재귀 호출 
    // 쫄지 마라, 그냥 다른 메소드를 호출했다고 생각하라
    // 메서드가 호출되면 스택에 그 메서드가 사용할 변수가 생성된다
    // 재귀호출은 수학 공식을 그대로 표현할 수 있어 읽기 쉽고 코딩도 쉽다.
    // 그러나 계속 메서드를 호출하기 때문에 메모리를 많이 차지하고 실행 속도가 느리다
    // 특히 메서드 호출이 너무 깊이 들어가면 스택메모리가 꽉차서 stack overflow exception이발생
    // 메서드 호출이 깊지 않은 간단한 상황에 재귀호출을 적용
    return n + sum2(n-1);
  }
  
}

