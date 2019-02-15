// 로컬에서 Calculator class 사용
package design_pattern.proxy.before1;

public class App {
  public static void main(String[] args) {
    Calculator calc = new Calculator();
    System.out.println(calc.plus(199, 222));
    System.out.println(calc.minus(199, 222));
    
    
  } // main()
} // end of class
