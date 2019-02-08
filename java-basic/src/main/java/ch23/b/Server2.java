// 데이터 주고 받기 - 에코 서버 만들기
package ch23.b;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server2 {
  public static void main(String[] args) {

    try ( Scanner keyboard = new Scanner(System.in);
        ServerSocket serverSocket = new ServerSocket(8888);) {

      System.out.println("server : 클라이언트의 연결을 기다림 ...");

      try (Socket socket = serverSocket.accept();
          Scanner in = new Scanner(socket.getInputStream());
          PrintWriter out = new PrintWriter(socket.getOutputStream());){

        System.out.println("server : 대기열에서 클라이언트 정보를 꺼내 소켓 생성 ...");
        System.out.println("server : 클라이언트와 통신할 입출력 스트림 준비 완료 ...");

        System.out.println("server : 데이터를 읽기 전에 잠깐 !");
        keyboard.nextLine(); 
        String request = in.nextLine();
        System.out.println(request);

        System.out.println("server :데이터를 보내기 전에 잠깐 !");
        keyboard.nextLine();
        out.write("** " + request + " **");
        /*
         출력 후 무조건
          out.flush();
           out.flush();
            out.flush();
             out.flush();
              out.flush();
         out.flush();
          out.flush();
           out.flush();
            out.flush();
             out.flush();
              out.flush();
               out.flush();
         */
        out.flush();
        System.out.println("server : 클라이언트에게 데이터를 보냈음 ...");


      }
      System.out.println("server : 클라이언트와 연결 종료 ...");
    } catch(Exception e) {
      e.printStackTrace();
    }
    System.out.println("server : 종료 ...");


  }
}
