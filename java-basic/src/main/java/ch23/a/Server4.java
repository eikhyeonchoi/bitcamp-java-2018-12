// 대기열 개수 설정하기
package ch23.a;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server4 {
  public static void main(String[] args) throws IOException {
    Scanner keyboard = new Scanner(System.in);
    
    ServerSocket serverSocket = new ServerSocket(8888, 3);
    System.out.println("server : 서버 소켓 생성 ...");
    System.out.println("server : 클라이언트 연결을 기다림 ...");
    
    while(true) {
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("q")) break;
      
      // 대기열에서 클라이언트 연결 정보를 꺼내 소켓 객체를 준비한다
      // ==> 대기열은 Queue 방식으로 관리하기 때문에 먼저 요청한 클라이언트를 먼저처리
      Socket socket = serverSocket.accept();
      System.out.println("server : 클라이언트와 연결됨 ...");
      // 대기열에서 꺼내는 순간 대기열은 한칸 빈다
      // 즉, 다른 클라이언트의 연결을 수용 가능
    }
    
    
    
    serverSocket.close();
    System.out.println("server : 서버 종료 ...");
    keyboard.close();
  }
}
