package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class CalculatorProcess {

  Socket socket;
  BufferedReader in;
  PrintStream out;

  public CalculatorProcess(Socket socket) throws Exception {
    this.socket = socket;
    this.in = new BufferedReader(
        new InputStreamReader(socket.getInputStream()));
    this.out = new PrintStream(socket.getOutputStream());
  }

  void process() {
    try(Socket socket = this.socket;
      BufferedReader in = this.in;
      PrintStream out = this.out;){
      greeting(out);

      while(true) {
        String response = in.readLine();
        if(isQuit(out, response)) break;
        calculate(out, response);
      }
    } catch (Exception e) {
      System.out.println("클라이언트와의 오류 발생");
    }
    
  }

  void greeting(PrintStream out) {
    out.println("계산기 서버에 오신 걸 환영합니다!");
    out.println("계산식을 입력하세요!");
    out.println("예) 23 + 7");
    out.println("");
  }

  void calculate(PrintStream out, String response) {
    try {
      String[] list = response.split(" ");
      int a = Integer.parseInt(list[0]);
      String op = list[1];
      int b = Integer.parseInt(list[2]);
      int result = 0;
      switch(op) {
        case "+" : result = a + b; break;
        case "*" : result = a * b; break;
        case "-" : result = a - b; break;
        case "/" : result = a / b; break;
        case "%" : result = a % b; break;
        default: 
          out.println("이 연산자는 지원하지 않습니다");
          out.flush();
          return;
      }
      out.printf("계산결과는 %d 입니다.\n", result);
      out.flush();
    }catch (Exception e) {
      out.println("식의 형식이 잘못되었습니다");
      out.flush();
    }
  }

  boolean isQuit(PrintStream out, String response) {
    if(response.equalsIgnoreCase("quit")) {
      out.println("안녕히 가세요");
      out.flush();
      return true;
    } 
    return false;
  }


}
