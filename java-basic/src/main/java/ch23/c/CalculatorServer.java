// 계산기 서버 만들기
package ch23.c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CalculatorServer {
  public static void main(String[] args) {

    try(ServerSocket serverSocket = new ServerSocket(8542, 1);) {
      System.out.println("server : 클라이언트를 기다리는 중...");

      try (Socket socket = serverSocket.accept();
          DataOutputStream out = new DataOutputStream(socket.getOutputStream());
          DataInputStream in = new DataInputStream(socket.getInputStream())){
        System.out.println("server : 클라이언트 연결 완료");

        out.writeUTF("계산기 서버에 오신것을 환영합니다!");
        out.writeUTF("계산식을 입력하세요!");
        out.writeUTF("예) 23 + 7 ");
        out.flush();
        while(true) {
          String result = in.readUTF();
          if(result.equalsIgnoreCase("quit")) {
            out.writeUTF("안녕히 가세요!");
            out.flush();
            break;
          } else {
            out.writeUTF(split(result));
          }

        }
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static String split(String oper) {
    String blank = oper.replaceAll(" ", "");
    String[] list;
    int first, second;
    int mm = 0;

    if(blank.contains("+")) {
      list = blank.split("\\+");
      first = Integer.parseInt(list[0]);
      second = Integer.parseInt(list[1]);
      mm = first + second;
      return ""+mm;
      
    } else if (blank.contains("-")) {
      list = blank.split("\\-");
      first = Integer.parseInt(list[0]);
      second = Integer.parseInt(list[1]);
      mm = first - second;
      return ""+mm;
      
    } else if (blank.contains("*")) {
      list = blank.split("\\*");
      first = Integer.parseInt(list[0]);
      second = Integer.parseInt(list[1]);
      mm = first * second;
      return ""+mm;
      
    } else if (blank.contains("/")) {
      list = blank.split("\\/");
      first = Integer.parseInt(list[0]);
      second = Integer.parseInt(list[1]);
      mm = first / second;
      return ""+mm;
      
    } else if (blank.contains("%")) {
      list = blank.split("\\%");
      first = Integer.parseInt(list[0]);
      second = Integer.parseInt(list[1]);
      mm = first % second;
      return ""+mm;
      
    } else {
      return "지원하지 않는 형식입니다";
    }
    
  }
  
  
}
