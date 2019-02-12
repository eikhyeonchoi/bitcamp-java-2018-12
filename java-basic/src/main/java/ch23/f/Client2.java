// Connection-Oriented vs ConnectionLess
package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client2 {
  public static void main(String[] args) {

    // Connectionless
    // ==> 서버와 연결없이 데이터를 보내고 받을 수 있다
    // ==> DatagramSocket, DatagramPacket을 사용해 처리
    // ==> 예) 편지, ping 등
    // ==> 응용) 모니터링 프로그램에서 많이 사용

    // 데이터 송수신을 담당할 소켓을 먼저 준비한다
    try (DatagramSocket socket = new DatagramSocket()){

      for (int i = 0; i < 100; i++) {
        // 데이터를 패킷에 담는다
        byte[] bytes = String.format("hello! - %d", i).getBytes("UTF-8");
        
        DatagramPacket packet = new DatagramPacket(
            bytes, // 보내는 데이터
            bytes.length, // 바이트 배열의 크기
            InetAddress.getByName("localhost"), // 받는이의 주소
            8888 // 받는 이의 포트 번호
            );

        // 소켓을 이용해 패킷을 네트워크로 내보냄
        socket.send(packet);
        System.out.println(i+ "데이터 전송 완료(상대방이 받았는지 보장 못함)");
        
        Thread.currentThread().sleep(500);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // main
}
