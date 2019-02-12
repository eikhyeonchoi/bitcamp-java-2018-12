
package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import org.hamcrest.core.IsEqual;

public class CalculatorServer2 {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 서버 실행중 ...");

      HashMap<Long, Integer> map = new HashMap<Long, Integer>();
      while(true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));) {
          System.out.println("클라이언트와 연결됨! 요청 처리중 ...");

          int result = 0;
          boolean isNewSessionId = false;

          long sessionId = Long.parseLong(in.readLine());
          System.out.println("Session ID : " + sessionId);
          if(sessionId == 0) {
            sessionId = System.currentTimeMillis();
            map.put(sessionId, 0);
            isNewSessionId = true;
          } else {
            result = map.get(sessionId);
          }
          

          String[] input = in.readLine().split(" ");
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
              out.printf("%s 연산자를 지원하지 않습니다.\n",op);
              out.flush();
              continue;
          }
          out.printf("결과는 %d 입니다\n", result);
          out.flush();

          map.put(sessionId, result);

          if(isNewSessionId) {
            out.println(sessionId);
            out.flush();
          }

        } catch(Exception e) {
          System.out.println("통신중 오류발생");
        }
        System.out.println("클라이언트와 연결끊음 ...");

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
