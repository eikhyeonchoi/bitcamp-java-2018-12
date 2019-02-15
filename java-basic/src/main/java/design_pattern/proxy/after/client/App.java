// 3단계 - 프록시 패턴을 적용해 C/S 계산기 어플리케이션 사용학
// ==> 서버 개발자가 제공해준 프록시 객체를 이용해 계산한다
package design_pattern.proxy.after.client;

import java.util.Scanner;
import design_pattern.proxy.after.server.Calculator;
import design_pattern.proxy.after.server.CalculatorStub;

public class App {
  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);
    
    // 클라이언트 개발자가 원격의 객체(Server의 Calculator class)를 사용하기위해
    // 원격 서버와 통신하는 코드를 프로토콜(out, in 순서와 갯수) 에 맞춰 직접 작성함
    Calculator calc = new CalculatorStub();

    while (true) {
      System.out.print("계산식(예. 100 + 200) >> ");
      String input = keyboard.nextLine();
      if (input.equalsIgnoreCase("quit")) 
        break;
      
      String[] values = input.split(" ");
      try {
        int a = Integer.parseInt(values[0]);
        int b = Integer.parseInt(values[2]);
        String op = values[1]; 
        switch(op) {
          // 이렇게 Calculator를 로컬에서 사용하는 것처럼
          // CalculatorStub이라는 프록시를 통해 작업을 수행할 수 있다
          // Calculator를 사용해야 하는 클라이언트 개발자는
          // Calculator를 사용하기 위해 서버와 통신하는 코드를 작성할 필요가 없다
          // 서버 개발자가 프록시 객체를 만들어 제공함
          case "+" : System.out.println(calc.plus(a, b)); break;
          case "-" : System.out.println(calc.plus(a, b)); break;
          default : System.out.println("해당 연산자를 지원하지 안ㅅ습니다");
        }
        
      } catch (Exception e) {
        System.out.println("식 or 계산 오류 " + e.getMessage());
      }
      
    } // while
    keyboard.close();

  } // main()
} // end of class
