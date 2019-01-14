// 클래스 필드의 한계
package ch09;

public class Test03 {
  
  
  public static void main(String[] args) {
        
    // 두 계산식을 동시에 하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 8 = ?
    
    // Calculator2의 result 변수는 오직 한 개만 존재
    // 따라서 다음과 같이 두 개의 계산식을 동시에 수행할 수 없다
    
    Calculator2.plus(2); // 식1 계산 = 2
    Calculator2.plus(6); // 식2 계산 = 6
    
    Calculator2.multiple(3); // 식1 => 2 * 3
    Calculator2.divide(2); // 식2 => 6 / 2
    
    Calculator2.minus(2); // 식1 => 2 * 3 - 2
    Calculator2.plus(8); // 식2 => 6 / 2 + 8 
    
    Calculator2.plus(7);
    System.out.println(Calculator2.result);
   
    
    // 동시에 계산식을 수행하는 방법은 없을까?
    // Calcultor2는 불가능하다
    // Calcultor1이 오히려 가능 왜? 계산 결과를 호출하는 쪽에서 관리하기 때문임
    
    
    
    
    
    
    
  }
}
