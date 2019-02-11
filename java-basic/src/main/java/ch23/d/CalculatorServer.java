
package ch23.d;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 서버 실행중 ...");

      // 서버의 Stateless 통신방식
      while(true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));) {

          System.out.println("클라이언트와 연결됨! 요청 처리중 ...");
          String[] input = in.readLine().split(" ");
          int a, b, result = 0;
          String op = null;

          try {
            a = Integer.parseInt(input[0]);
            op = input[1];
            b = Integer.parseInt(input[2]);
            result = 0;
          } catch(Exception e) {
            out.println("식의 형식이 바르지 않습니다");
            out.flush();
            continue;
          }
          switch(op) {
            case "+": result = a + b; break;
            case "-": result = a - b; break;
            case "*": result = a * b; break;
            case "/": result = a / b; break;
            case "%": result = a % b; break;
            default:
              out.printf("%s 연산자를 지원하지 않습니다.\n",op);
              out.flush();
              continue;
          }
          out.printf("결과는 %d 입니다\n", result);
          out.flush();


        } catch(Exception e) {
          // 클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다
          System.out.println("통신중 오류발생");
        }
        System.out.println("클라이언트와 연결끊음 ...");

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
