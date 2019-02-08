// 데이터 주고 받기 - 에코 클라이언트 만들기
package ch23.b;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        // 문자열을 주고 받기 편하도록 오리지널 입출력 스트림 객체 Decorator를 붙안다
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream())){
      System.out.println("client : 서버에 연결됨 ...");
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
                   out.flush();
                    out.flush();
                     out.flush();
                      out.flush();
                       out.flush();
                        out.flush();
                         out.flush();
                          out.flush();
                          
       */
      out.println("hello !");
      // flush()를 안넣으면 PrintWriter는 일단 내부 버퍼로 보내기 때문에 서버(네트워크)로 안나감
      // 네트워크 통신에서는 출력하고 flush() 습관화 해야함
      out.flush(); // 스트림 객체의 내부 버퍼에 출력된 내용을 네트워크로 방출
      System.out.println("client : 서버에 데이터 보냄 ...");
      
      // 서버의 응답을 받는다
      // ==> 서버가 응답을 할 때 까지 return하지 않음
      //     즉 Blocking모드로 작동
      String response = in.nextLine(); // 서버에서 응답해야지만 다음 코드 실행
      System.out.println(response);

    } catch(Exception e) {
      e.printStackTrace();
    }






  }
}
