//부동소수점 리터럴의 크기
package ch02;

public class Test06 {
  static final float ff =12.375f;
  public static void main(String[] args) {
    System.out.println(0.1f * 0.1f);
    // 결과 값이 예상한 값과다르다;
    // 이유? ==>부동소수점을 이진수로 바꿀 때 존나작은수의 오차가 있을 수 있음;
    
    // 그래서 부동소수점을 비교할 때 정수 비교할 때 처럼 단순하게 비교하면
    // 원하는 결과를 얻을 수 없다;
    System.out.println(0.1f * 0.1f == 0.01f); // true로 예상했지만 결과는 false;
    
    //해결방안 =>예상한 값과의 오차가 부동소수점에서 인정하는 오차 이하의 값이라면 같다라고하자;
    System.out.println((0.1f * 0.1f - 0.01f)<Float.POSITIVE_INFINITY);
    
  }
}

