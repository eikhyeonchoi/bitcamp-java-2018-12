package ch23.g;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class HttpClient {
  public static void main(String[] args) {
    // Http 프로토콜
    // ==> 웹서버와 웹브라우저 사이의 통신 규칙이다
    // ==> Stateless방식으로 동작

    // HTTP 요청 규칙
    // -----------------------------------------------
    // GET [url] [프로토콜/버전](CRLF)
    // Host: [서버주소](CRLF)
    // (CRLF)
    // -----------------------------------------------
    try (Socket socket = new Socket("www.khnp.co.kr", 80);
        PrintStream out = new PrintStream(socket.getOutputStream()); 
        Scanner in = new Scanner(socket.getInputStream()); ){
      
      // 필수 항목들
      out.println("GET /main.do HTTP/1.1");
      out.println("Host: www.www.khnp.co.kr");
      out.println();
      out.flush();
      
      while(true) {
        System.out.println(in.nextLine());
      } // while
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  } // main
}
