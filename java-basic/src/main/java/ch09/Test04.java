// 클래스 필드의 한계
package ch09;

public class Test04 {
  
  
  public static void main(String[] args) {
        
    // Calcultor1을 사용해 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calculator1 을 사용할 경우 계산 결과를 직접 관리해야한다
    
    int res1 = 0;
    int res2 = 0;
    
    res1 = Calculator1.multiple(2,3); // 식1 계산 = 2
    res2 = Calculator1.divide(6,2); // 식2 계산 = 6
    
    res1 = Calculator1.minus(res1, 2); // 식1 => 2 * 3
    res2 = Calculator1.plus(res2, 8); // 식2 => 6 / 2
    
    res1 = Calculator1.plus(res1,7); // 식1 => 2 * 3 - 2
    
    System.out.println(res1);
    System.out.println(res2);
   
    
    // Calcultor1을 사용할 경우 계산 결과를 직접 관리해야 하기 때문에 불편
    // 그러나 여러 계산식을 동시에 처리할 수 있는 좋은점이 있다
    // Calculator2를 사용할 경우 계산 결과를 직접 관리하지 않아도 되기 때문에 편리
    // 그러나, 계산 결과를 클래스에서 한개만 관리하기 때문에 여러 계산식을 동시 실행할 수 없다
    //
    // 클래스에서 여러 결과를 각각 관리하는 방법은 없을까?
    // ==> 인스턴스 필드를 사용하는 것이다
    
    
    
  }
}
