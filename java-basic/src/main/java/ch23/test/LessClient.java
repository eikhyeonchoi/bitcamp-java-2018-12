package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class LessClient {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    long sessionId = 0;
    
    while(true) {
      System.out.print("> ");
      String request = keyboard.nextLine();
      if(request.equalsIgnoreCase("quit")) break;
      
      try (Socket socket = new Socket("localhost", 8888);
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintStream out = new PrintStream(socket.getOutputStream());  ){
        System.out.println("연결 완료");

        out.println(sessionId);
        out.println(request);

        System.out.println(in.readLine());
        
        if(sessionId == 0) {
          sessionId = Long.parseLong(in.readLine());
          System.out.printf("New Session ID = %d\n", sessionId);
        }

      } catch (Exception e) {
        e.printStackTrace();
      }
      
      
    } // while

    keyboard.close();
  } // main
}
