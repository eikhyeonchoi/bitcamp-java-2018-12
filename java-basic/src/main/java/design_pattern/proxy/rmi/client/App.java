// 4단계 - RMI 기술을 사용해 C/S 계산기 어플리케이션 만들기
// ==> RMI Registry 서버에 등록된 stub을 받아 원격객체(CalculatorImpl)를 사용한다
package design_pattern.proxy.rmi.client;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import design_pattern.proxy.rmi.server.Calculator;

public class App {
  public static void main(String[] args) throws Exception {

    Scanner keyboard = new Scanner(System.in);

    // RMI 기술을 사용하면 개발자가 skeleton이나 stub객체를 직접 작성할 필요가 없다
    // RMI Registry에 등록된 stub을 받아서 사용하면 된다

    // 1) RMi Registry 서버에 스텁 객체를 받기 위해 사용할 도구를 준비한다
    Registry registry = LocateRegistry.getRegistry("127.0.0.1");

    // 2) 이 도구를 사용하여 RMI Registry 서버에 등록된 스텁을 등록된 이름으로 찾는다
    // ==> lookup() : RMI Registry 서버에서 해당 이름으로 등록된 stub을 찾아서 리턴
    Calculator calc = (Calculator) registry.lookup("calc");

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
          case "-" : System.out.println(calc.minus(a, b)); break;
          default : System.out.println("해당 연산자를 지원하지 않습니다");
        }

      } catch (Exception e) {
        System.out.println("식 or 계산 오류 " + e.getMessage());
      }

    } // while
    keyboard.close();

  } // main()
} // end of class
