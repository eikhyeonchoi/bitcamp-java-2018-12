// Http서버 만들기
package ch23.g;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HttpServer {
  public static void main(String[] args) {

    // HTTP 응답 규칙
    // ----------------------------------------------
    // [프로토콜]/[버전] [실행결과코드] [실행결과내용](CRLF)
    // Content-Type: [mime type](CRLF)
    // ...
    // (CRLF)
    // 서버가 클라이언트에게 보내는 콘텐트
    // ----------------------------------------------
    try (ServerSocket serverSocket = new ServerSocket(8989);) {
      System.out.println("서버 실행중");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            PrintStream out = new PrintStream(socket.getOutputStream()); 
            Scanner in = new Scanner(socket.getInputStream()); ){

          while (true) {
          String request = in.nextLine();
          System.out.println(request);
          if (request.length() == 0) break;
          }

          out.println("HTTP/1.1 200 ok");
          out.println("Content-Type: text/html;charset=UTF-8");
          out.println();
          out.println("<html><body><h1>오호라!! 안녕하세요</h1></body></html>");
          out.flush();

        } catch (Exception e) {
          e.printStackTrace();
        }
        
      } // while
      
    } catch (Exception e1) {
      e1.printStackTrace();
    }




  } // main
}
