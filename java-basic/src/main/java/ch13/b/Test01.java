// 기능 확장 : 방법 2) 상속 기능활용
package ch13.b;

public class Test01 {

  public static void main(String[] args) {
    // 다음 Calculator2는 Calculatorf의 기능을 상속 받았기 때문에
    // Calculator2를통해 Calculator의 기능을 호출할 수 있다
    Calculator2 c1 = new Calculator2();
    c1.plus(5); // Calculator
    c1.multiple(2); // Calculator2
    c1.minus(2); // Calculator
    c1.divide(4); // Calculator2
    System.out.println(c1.getResult());
  }
}
/*
    
  

*/
