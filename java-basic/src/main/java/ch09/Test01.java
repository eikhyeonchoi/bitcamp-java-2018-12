// 클래스 필드가 필요한 이유
package ch09;

public class Test01 {
  
  
  public static void main(String[] args) {
        
    // 계산하기
    // ==> 2 * 3 - 2 + 7 = ?
    
    int res = Calculator1.multiple(2, 3);
    res = Calculator1.minus(res, 2);
    res = Calculator1.plus(res, 7);
    
    System.out.println(res);
    
    // Calculator1의 메서드를 이용해 계산을 수행할 때
    // 계산 결과를 호출하는 쪽에서 직접 관리하였다
    // res변수는 Calcultor1의 메서드들이 사용하는 변수인데
    // 다른 클래스에서 관리하니 너무 불편하다
    // 이런경우, 
    // 변수를 사용하는 클래스에 두는 것이 소스 코드 유지보수에 좋다
    
    
    
    
    
    
  }
}
