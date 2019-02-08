package ch23.c;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class pServer {
  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(8558,1);) {
      System.out.println("server : 클라이언트 연결 대기중");
      
      try (Socket socket = serverSocket.accept();
          PrintWriter out = new PrintWriter(socket.getOutputStream());
          Scanner in = new Scanner(socket.getInputStream());) {
        System.out.println("server : 클라이언트 연결 완료");
        out.println("계산서버에 오신것을 환영합니다!");
        out.println("계산식을 입력하세요!");
        out.println("예)23 + 7");
        out.flush();
        System.out.println(in.nextLine());
        /*
        while(true) {
          System.out.println(in.nextLine());
        }
        */
        
        
        
        
        
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    

  }
}
