package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
 
public class CalculatorClient2 {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    
    long sessionId = 0;
    while(true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit")) break;

      try (Socket socket = new Socket("localhost", 8558);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream())); ){
        System.out.println("client : 서버에 연결 완료 ...");
        
        out.println(sessionId);
        out.flush();
        
        out.println(input);
        out.flush();

        String response = in.readLine();
        System.out.println(response);
        
        if(sessionId == 0) {
         sessionId =Long.parseLong(in.readLine());
          System.out.printf("Your New Session ID : %d\n",sessionId);
        }


      } catch (Exception e) {
        e.printStackTrace();
      } 
      System.out.println("client : 서버와 연결 종료 ...");
    } // while

    keyboard.close();
  } // main
} 
