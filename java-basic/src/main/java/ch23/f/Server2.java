// Connection-Oriented vs ConnectionLess
package ch23.f;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server2 {
  public static void main(String[] args) {

    // Connectionless
    // ==> 서버와 연결없이 데이터를 보내고 받을 수 있다
    // ==> DatagramSocket, DatagramPacket을 사용해 처리
    
    // 데이터 송수신을 담당할 소켓을 먼저 준비한다
    // ==> 보내는 쪽이나 받는 쪽이나 같은 소켓 클래스를 사용한다
    // ==> Connectionful처럼 따로 ServerSocket이 없다
    // ==> 받는 쪽에서는 socket을 생성할 때 포트 번호를 설정해주면 된다
    try (DatagramSocket socket = new DatagramSocket(8888); ){

      // 데이터받을 버퍼를 준비
      byte[] buf = new byte[8192];
      
      // 빈 패킷을 준비한다
      DatagramPacket emptyPacket = new DatagramPacket(buf, buf.length);
      
      // 소켓을 이용해 패킷을 받음
      // ==> 물론 받을 때 까지 return하지 x ==> Blocking 방식으로 동작
      socket.receive(emptyPacket);
      System.out.println("데이터 수신 완료");
      
      String message = new String(
          emptyPacket.getData(), // 패킷에서 바이트 배열을 꺼낸다
            0, // 패킷에서 꺼낸 버퍼에서 0번째 부터 갯수 만큼 바이트 배열을 읽어 문자열로 만듦
          emptyPacket.getLength(), // 패킷에서 받은 바이트의 갯수를 알아낸다
          "UTF-8" // 바이트 배열로 인코딩된 문자표의 이름을 지정한다
          );
      System.out.println(message);

    } catch (Exception e) {
      e.printStackTrace();
    }
  } // main
}
