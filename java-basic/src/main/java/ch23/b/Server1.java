// 데이터 주고 받기 - 서버 만들기
package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server1 {
  public static void main(String[] args) {

    try ( Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {
      
      System.out.println("server : 클라이언트의 연결을 기다림 ...");

      try ( // 대기열에서 클라를 한개 꺼낸다
              // ==> 대기열에 클라정보가 없다면 있을 때 까지 기다림 
              //     즉 Blocking모드로 작동한다
          Socket socket = serverSocket.accept();
          InputStream in = socket.getInputStream();
          OutputStream out = socket.getOutputStream();){

        // 클라이언트와 데이터를 주고 받을 입출력 스트림 객체를 준비한다
        System.out.println("server : 대기열에서 클라이언트 정보를 꺼내 소켓 생성 ...");
        System.out.println("server : 클라이언트와 통신할 입출력 스트림 준비 완료 ...");
        
        // Client1과 Server1의 통신규칙에 따라 순서대로 입출력 해야 한다
        // 왜? 입출력은 blocking 모드로 작동하기 때문이다
        // 클라이언트와 서버간의 데이터를 주고 받는 통신 규칙을 프로토콜 이라한다
        // echo 는 클라이언트에서 한 줄의 문자열을 보낸다
        // 따라서 서버는 한줄의 문자열을 읽은 후에 응답 해야 한다
        
        // 서버에서 1바이트의 데이터를 읽기 전에는 클라이언트의 println이 return하지 않음을
        // 증명하기 위해 클라이언트가 보낸 데이터를 읽지 않도록 잠시 실행을 중단
        System.out.println("server : 데이터를 읽기 전에 잠깐 !");
        keyboard.nextLine(); // 사용자가 콘솔창에서 엔터를 칠 때 까지 return하지 않는다
        
        // 클라이언트가 1바이트을 보낼 때 까지 return하지 않는다
        // ==> 한줄의 문자열??? 문자열 끝에 0A(LF; 줄바꿈코드)를 만날 때 까지이다
        // ==> blocking모드로 작동하기 때문이다
        int request = in.read();
        System.out.println(request);
        
        // 서버가 데이터를 보내지 않으면 클라이언트의 read()는 return 하지 않는다
        // 이를 확인하기 위해 잠시 실행을 멈춘다
        System.out.println("server :데이터를 보내기 전에 잠깐 !");
        keyboard.nextLine();
        
        // ==> 클라에게 받은 문자열을 그대로 보냄
        //     물론 클라가 보낸 데이터를 다 읽을때 까지 return하지 않음
        out.write(100 / 3);
        System.out.println("server : 클라이언트에게 데이터를 보냈음 ...");
        
        
      }
      System.out.println("server : client와 연결 종료 ...");
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("server : 종료 ...");


  }
}
