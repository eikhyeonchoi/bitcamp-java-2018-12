package ch23.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class CalculatorServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 서버 실행중 ...");

      HashMap<String, Integer> map = new HashMap<String, Integer>();
      // HashMap<Long, Integer> sessionMap = new HashMap<Long, Integer>();

      while(true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));) {
          int result = 0;

          /*
          boolean isNewSessionId = false;

          long sessionId = Long.parseLong(in.readLine());
          System.out.printf("session ID = %d\n", sessionId);
          if (sessionId == 0) {
            //l 클라이언트에게 세션 ID를 발급한 적이 없다면, 새 세션 ID를 발급
            sessionId = System.currentTimeMillis();
            sessionMap.put(sessionId, 0);
            isNewSessionId = true;
          } else {
            //l 클라리언트의 세션 ID로 기존에 저장된 결과 값을 가져 온다
            result = sessionMap.get(sessionId); // auto-unboxing => Integer.intValue();
          }
           */

          String cookie = in.readLine();
          System.out.printf("cookie = %s\n", cookie);
          if(cookie.equals("null")) {
            cookie = socket.getInputStream().toString();
            map.put(cookie, 0);
          } else {
            result = map.get(cookie);
          }
          // result = sessionMap.get(sessionId);
          System.out.println("클라이언트와 연결됨!");
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
          out.printf("현재까지의 계산결과는 %d 입니다\n", result);
          out.flush();

          out.println(cookie);
          out.flush();
          map.put(cookie, result);
          
          /*
          sessionMap.put(sessionId, result);
          if (isNewSessionId) {
            out.println(sessionId);
          }
          */
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
