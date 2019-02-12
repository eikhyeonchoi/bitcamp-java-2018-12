package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class LessServer {
  public static void main(String[] args) {

    try (ServerSocket serversocket = new ServerSocket(8888); ){
      System.out.println("서버 실행");

      HashMap<Long, Integer> map = new HashMap<Long, Integer>();
      while (true) {
        try(Socket socket = serversocket.accept();
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintStream out = new PrintStream(socket.getOutputStream()); ) {
          
          int result = 0;
          boolean isNewSessionId = false;
          
          long sessionId = Long.parseLong(in.readLine());
          System.out.printf("Session ID of this client = %d\n", sessionId);
          if(sessionId == 0) {
            sessionId = System.currentTimeMillis();
            map.put(sessionId, 0);
            isNewSessionId = true;
          } else {
            result = map.get(sessionId);
          }
          
          String response = in.readLine();

          int a = 0;
          String op = null;

          try {
            String[] arr = response.split(" ");
            op = arr[0]; 
            a = Integer.parseInt(arr[1]);
          } catch(Exception e) {
            out.println("식의 형식이 올바르지 않습니다");
            out.flush();
            continue;
          }
          switch(op) {
            case "+" : result += a; break;
            case "-" : result -= a; break;
            case "*" : result *= a; break;
            case "/" : result /= a; break;
            case "%" : result %= a; break;
            default : 
              out.println("해당 연산자를 지원하지 않습니다");
              out.flush();
              continue;
          }
          
          out.println(result);
          out.flush();
          
          map.put(sessionId, result);
          
          if(isNewSessionId) {
            out.println(sessionId);
            out.flush();
          }

        } catch(Exception e) {
          e.printStackTrace();
        }

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // main
}
