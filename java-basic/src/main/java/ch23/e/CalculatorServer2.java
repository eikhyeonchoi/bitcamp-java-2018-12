// Stateful 응용 - 클라이언트의 계산 결과를 서버에 유지하기
package ch23.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer2 {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 서버 실행중 ...");

      // 서버의 Stateful 응용
      // ==> 작업 결과를 변수에 저장해 연결을 끊을 때까지 계속 유지한다
      while(true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));) {
          System.out.println("server : 클라이언트와 연결됨 ...");
          
          // 클라이언트의 요청에 대한 계산 결과를 유지할 변수 선언
          int result = 0;

          while(true) {
            String request = in.readLine();
            System.out.println("server : 클라이언트의 요청 처리 ...");
            if (request.equalsIgnoreCase("quit")) {
              out.printf("최종 계산 결과는 %d 입니다 \n", result);
              out.flush();
              break;
            }
            
            String[] input = request.split(" ");
            int b = 0;
            String op = null;

            try {
              op = input[0];
              b = Integer.parseInt(input[1]);
            } catch(Exception e) {
              out.println("식의 형식이 바르지 않습니다");
              out.flush();
              continue;
            }
            switch(op) {
              case "+": result += b; break;
              case "-": result -= b; break;
              case "*": result *= b; break;
              case "/": result /= b; break;
              case "%": result %= b; break;
              default:
                out.printf("server : %s 연산자를 지원하지 않습니다.\n",op);
                out.flush();
                continue;
            }
            out.printf("server : 현재까지의 결과는 %d 입니다\n", result);
            out.flush();
          } // while

        } catch(Exception e) {
          // 클라이언트 요청을 처리하다가 예외가 발생하면 무시하고 연결을 끊는다
          System.out.println("통신중 오류발생");
        }
        System.out.println("server : 클라이언트와 연결끊음 ...");

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
