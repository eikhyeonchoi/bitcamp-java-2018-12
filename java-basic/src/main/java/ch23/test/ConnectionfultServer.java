package ch23.test;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionfultServer {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8888);){
      System.out.println("서버 실행");

      while(true) {
        try (Socket socket = serverSocket.accept();
            Scanner in = new Scanner(socket.getInputStream());
            PrintStream out = new PrintStream(socket.getOutputStream()); ) {
          System.out.println("연결 완료");

          while(true) {
            String response = in.nextLine();
            
            if(response.equalsIgnoreCase("quit")) {
              out.println("종료");
              out.flush();
              System.out.println("연결종료");
              break;
            }
            
            int a = 0, b = 0;
            String op = null;

            try {
              String[] arr = response.split(" ");
              a = Integer.parseInt(arr[0]);
              op = arr[1];
              b = Integer.parseInt(arr[2]);
            } catch (Exception e) {
              out.println("식의 형식이 올바르지 않습니다");
              out.flush();
              continue;
            }

            int result = 0;

            switch(op) {
              case "+" : result = a + b; break;
              case "-" : result = a - b; break;
              case "*" : result = a * b; break;
              case "/" : result = a / b; break;
              case "%" : result = a % b; break;
              default :
                out.println("해당 연산자는 지원하지 않습니다");
                out.flush();
                continue;
            }
            out.printf("결과값은 %d 입니다\n", result);
            out.flush();
            
          } // while

        } catch (Exception e) {
          e.printStackTrace();
        }

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }


  } // main
}
