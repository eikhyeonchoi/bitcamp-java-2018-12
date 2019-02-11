package ch23.c;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {

    try (Socket socket = new Socket("localhost", 8542);
        PrintStream out = new PrintStream(socket.getOutputStream());
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        Scanner keyboard = new Scanner(System.in); ){
      while(true) {
        String send = keyboard.nextLine();
        out.println(send);
        
        if(send.equalsIgnoreCase("quit")) break;
        
        String response = in.readLine();
        System.out.println(response);

        
      } // while
    } catch (Exception e) {
      e.printStackTrace();
    } 


  } // main
}
