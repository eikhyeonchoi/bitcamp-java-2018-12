// Stateless 응용
package ch23.e;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
/*
stateless는 응답을 받은 후 연결을 끊는다
다시 요청할 때는 서버와 연결을 다시 한다
서버쪽에서는 어떻게 클라이언트를 구분하여 
 */
public class CalculatorClient {
  public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);

    String cookie = null;
    while(true) {
      System.out.print("> ");
      String input = keyboard.nextLine();
      if(input.equalsIgnoreCase("quit")) break;

      try (Socket socket = new Socket("localhost", 8558);
          PrintStream out = new PrintStream(socket.getOutputStream());
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream())); ){
        System.out.println("client : 서버에 연결 완료 ...");
        out.println(cookie);
        out.flush();

        out.println(input);
        out.flush();

        String response = in.readLine();
        System.out.println(response);

        cookie = in.readLine();

      } catch (Exception e) {
        e.printStackTrace();
      } 
      System.out.println("client : 서버와 연결 종료 ...");
    } // while
    keyboard.close();
  } // main
} 
