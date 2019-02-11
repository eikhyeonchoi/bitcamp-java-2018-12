package ch23.test;
import java.net.ServerSocket;

public class CalculatorServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8542);) {
      System.out.println("server : 서버 실행 ...");

      while(true) {
        new CalculatorProcess(serverSocket.accept()).process();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  
  
}
