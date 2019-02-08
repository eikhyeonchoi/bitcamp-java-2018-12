// 데이터 주고 받기 - 에코 클라이언트 만들기
package ch23.b;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8888);
        // 문자열을 주고 받기 편하도록 오리지널 입출력 스트림 객체 Decorator를 붙안다
        BufferedOutputStream out = new BufferedOutputStream(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        FileInputStream fileIn = new FileInputStream("")){
      System.out.println("client : 서버에 연결됨 ...");
      
      out.wri
      out.flush(); 
      System.out.println("client : 서버에 데이터 보냄 ...");
      
      String response = in.nextLine();
      System.out.println(response);

    } catch(Exception e) {
      e.printStackTrace();
    }






  }
}
