package ch23.test;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class CalculatorClient {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost",8542);
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in);
        PrintStream out = new PrintStream(socket.getOutputStream())){
      System.out.println("client : 서버에 연결됨 ...");
      while(true) {
        String greeting = in.readLine();
        System.out.println(greeting);
        if(greeting.length() == 0) break;
      }
      
      while(true) {
        System.out.print("> ");
        String ans = keyboard.nextLine();
        
        out.println(ans);
        out.flush();

        String response = in.readLine();
        System.out.println(response);
        if(ans.equalsIgnoreCase("quit")) break;
      }
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
  }
}
