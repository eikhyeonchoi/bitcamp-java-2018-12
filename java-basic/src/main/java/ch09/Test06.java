// 인스턴스 메서드의 등장
package ch09;

public class Test06 {
  
  
  public static void main(String[] args) {
        
    // Calcultor3를 사용해 두 계산식을 동시에 실행하기
    // 식1) 2 * 3 - 2 + 7 = ?
    // 식2) 6 / 2 + 9 = ?
    
    Calculator4 c1 = new Calculator4();
    Calculator4 c2 = new Calculator4();
    
    
    // 인스턴스 메서드는 인스턴스 주소를 파라미터로 넘겨주는 것이 아니라
    // 메서드를 호출하는 코드 앞에 둔다
    // 즉 메서드가 사용할 인스턴스 주소를 파라미터가 아닌 메서드 호출 앞에 둔다
    c1.plus(2);
    c2.plus(6);
    // c1에 있는 인스턴스 주소가 this변수로 들어가는것
    
    c1.multiple(3);
    c2.divide(2);
    
    c1.minus(2);
    c2.plus(9);
    
    c1.plus(7);
    
    System.out.println(c1.result);
    System.out.println(c2.result);
    
    // 인스턴스 메서드를 사용하면, 인스턴스 주소를 넘기기 쉽다
    // 메서드 호출시 앞에 적으면 된다
    // ex) c1.plus(3);
    
    // 인스턴스 메서드는 인스턴스 주소 없이 호출할 수 없다
    // Calculator4.plus(3); compile error
    Calculator4 c3 = null;
    c3.plus(3); // 런타임 오류 ==>  java.lang.NullPointerException
    
  }
}
