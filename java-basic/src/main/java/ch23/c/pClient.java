package ch23.c;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class pClient {
  public static void main(String[] args) {
    try (Socket socket = new Socket("localhost", 8558);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        Scanner in = new Scanner(socket.getInputStream());
        Scanner keyboard = new Scanner(System.in); ){
      
      System.out.println("client : 서버에 연결완료");
      while(in.hasNext()) {
        System.out.println(in.nextLine());
        if(in.nextLine().contains("+")) break;
      }
      out.println("asdasdasdad");
      out.flush();
      
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
}
