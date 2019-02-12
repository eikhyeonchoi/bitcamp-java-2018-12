package ch23.test;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ConnectionfulClient {
  public static void main(String[] args) {
    
    try(Socket socket = new Socket("localhost",8888);
        Scanner in = new Scanner(socket.getInputStream()); 
        PrintStream out = new PrintStream(socket.getOutputStream());
        Scanner keyboard = new Scanner(System.in)){
      System.out.println("서버에 접속");
      while(true) {
   
      String ans = keyboard.nextLine();
      out.println(ans);
      
      if(ans.equalsIgnoreCase("quit")) {
        System.out.println(in.nextLine());
        break;
      }
      
      String response = in.nextLine();
      System.out.println(response);
      
      } // while
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("서버 연결을 종료합니다");
  } // main
}
