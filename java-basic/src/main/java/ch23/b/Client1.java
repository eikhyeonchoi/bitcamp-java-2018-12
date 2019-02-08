// 데이터 주고 받기 - 클라이언트 만들기
package ch23.b;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client1 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        // 서버랑 데이터를 주고 받을 수 있도록 입출력 스트림 객체를 준비
        // ==> 출력 스트림 객체를 준비하기 
        OutputStream out = socket.getOutputStream();
        // ==> 입력 스트림 객체를 준비하기
        InputStream in = socket.getInputStream();){

      System.out.println("client : 서버에 연결됨 ...");

      // 서버에게 데이터 보내기
      // ==> 보통은 클라쪽에서 먼저 서버로 데이터를 보냄, 먼저 연결한 쪽이 먼저 요청
      // ==> 서버에서 데이터를 모두 받아야만 return;
      //     즉 Blocking 모드로 작동한다
      // ==> 실제 write()는 소켓의 내부 버퍼로 출력한다
      //     따라서 write() 호출 후 즉시 return될 것이다
      out.write(100); // 서버에서 받아야만 다음 코드 실행
      System.out.println("client : 서버에 데이터 보냄 ...");
      
      // 서버의 응답을 받는다
      // ==> 서버가 응답을 할 때 까지 return하지 않음
      //     즉 Blocking모드로 작동
      int response = in.read(); // 서버에서 응답해야지만 다음 코드 실행
      System.out.println(response);

    } catch(Exception e) {
      e.printStackTrace();
    }






  }
}
