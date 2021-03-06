// 클라이언트만들기
package ch23.a;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
  public static void main(String[] args) throws UnknownHostException, IOException {
    // 클라이언트?
    // ==> 연결을 요청하는쪽을 가리키는 용어
    // 서버?
    // ==> 연결 요청을 받는 쪽을 가리키는 용어

    // 1) 서버에 연결 요청을할 때 사용할 도구를 준비
    //    ==> 서버와의 연결이 이루어지면 Socket객체를 리턴한다
    Socket socket = new Socket("localhost", 8888);
    // 1번째 아규먼트 : IP주소 또는 도메인명
    //          특수 IP   : 127.0.0.1 - 로컬 컴퓨터
    //          특수 도메인 : localhost - 로컬 컴퓨터 == 127.0.0.1 
    // 2번째 아규먼트 : 포트번호 - 서버를 구현하는 식별번호  
    // IP주소가 회사 대표번호라면, 포트 번호는 내선 번호라고 할 수있다
    System.out.println("client : server connected success ...");
    
    // 2) 서버와 연결 해제
    //    ==> 작업이 끝난 후에는 항상 서버와의 연결을 해제해야 한다
    //    ==> 물론 해제하지 않아도 서버측에서 일정시간이 지나면 자동으로 연결과 관련된 자원을 해제
    //    ==> 그러나 가능한 명시적으로 연결을 해제하는 것이 좋다
    //        서버측에서 해당 클라이언트와 연결하기 위해 사용한 자원을 빠르게 회수해
    //        다른 클라이언트를 위해 사용할 수 있기 때문이다
    socket.close();
    
    


  }
}
