package ch23.c;
import java.net.ServerSocket;


// 개 도랐네 ㅅㅂ
public class pServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 서버 실행중 ...");
      while(true) {
        try {
          new CalculatorProcessor(serverSocket.accept()).execute();
        } catch(Exception e) {
          System.out.println("통신중 오류 발생");
          e.printStackTrace();
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
