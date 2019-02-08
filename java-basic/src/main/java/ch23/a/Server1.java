// 서버 만들기
package ch23.a;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Server1 {
  public static void main(String[] args) throws IOException {
    // 중간에 실행을 잠깐 멈출 때 사용하기 위함
    Scanner keyboard = new Scanner(System.in);
    // 서버? 클라이언트 요청을 받는 쪽을 가리키는 용어
    
    // 1) 클라이언트 요청을 받을 도구를 준비한다
    ServerSocket serverSocket = new ServerSocket(8888);
    // 아규먼트 : 연결 요청을 받을 때 사용할 포트 번호, 다른 프로세스(프로그램)과 중복 불가능
    // 내선번호가 중복 불가능하듯 마찬가지로 포트번호도 중복이 불가능하다
    System.out.println("서버 소켓 생성 완료");
    System.out.println("클라이언트의 연결을 기다림");
    
    // 잠깐 멈추기
    keyboard.nextLine(); // 사용자가 엔터를 칠 때 까지 return하지 않는다
    
    // 2) 서버소켓의 모든 자원을 해제
    serverSocket.close();
    keyboard.close();
    

  }
}
