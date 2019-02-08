// 데이터 주고 받기 - 에코 클라이언트 만들기
package ch23.b;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
  public static void main(String[] args) {

    try (Socket socket = new Socket("192.168.0.109", 8888);
        // 문자열을 주고 받기 편하도록 오리지널 입출력 스트림 객체 Decorator를 붙안다
        DataOutputStream out = new DataOutputStream(
            new BufferedOutputStream(socket.getOutputStream()));
        Scanner in = new Scanner(socket.getInputStream());  ){
      
      System.out.println("client : 서버에 연결됨 ...");
      
      File file = new File("temp/testDPR.mp4");
      try (BufferedInputStream fileIn =
          new BufferedInputStream(
              new FileInputStream(file));){
        
        // 서버에 보낼 파일이 크기를 먼저 알려준다
        long fileLen = file.length();
        out.writeLong(fileLen);
        out.writeUTF("testDPR.mp4");
        out.flush();
        
        // 파일에서 1바이트를 읽어 서버에 보낸다
        // ==> 읽을 때도 출력할 때도 버퍼를 사용하기 때문에
        // ==> 1바이트씩 읽을 때마다 서버에 보내는게 아니라 일단 버퍼에 저장한 후 버퍼만큼 한번에 보냄
        System.out.println("client : 서버에 데이터를 보내는중 ...");
        for(long i = 0; i < fileLen; i++) {
          out.write(fileIn.read());
        }
        // 버퍼에 남은 잔여 데이터를 보내는 것을 잊지말라
        out.flush();
        System.out.println("client : 서버에 데이터를 보냄 ...");
      }

      System.out.println("client : 서버에 응답을 기다림 ...");
      String response = in.nextLine();
      System.out.println(response);

    } catch(Exception e) {
      e.printStackTrace();
    }






  }
}
