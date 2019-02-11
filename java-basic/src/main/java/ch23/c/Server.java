package ch23.c;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) {

    try (ServerSocket serverSocket = new ServerSocket(8542);){
      System.out.println("server : 클라이언트 연결 대기중");

      while (true) {
        Socket socket = null;
        PrintStream out = null;
        BufferedReader in = null;

        try {socket = serverSocket.accept();
        out = new PrintStream(socket.getOutputStream());
        in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        System.out.println("server : 클라이언트 연결 완료");

        while(true) {
          String response = in.readLine();
          if(response.equalsIgnoreCase("quit")) break;
          try {
          String[] arr = response.split(" ");

          int result = 0;
          int a = Integer.parseInt(arr[0]);
          String op = arr[1];
          int b = Integer.parseInt(arr[2]);
          switch(op) {
            case "+" : result = a + b; break;
            case "-" : result = a - b; break;
            case "*" : result = a * b; break;
            case "/" : result = a / b; break;
            case "%" : result = a % b; break;
            default : 
              out.println("해당 연산자는 지원하지 않습니다");
              out.flush();
              continue;
              

          } //switch

          out.printf("결과 값은 %d 입니다 \n", result);
          out.flush();

        } // while
        } catch (Exception e) {
          try {
            out.println("잘못된 값을 입력하셨습니다");
            out.flush();} catch (Exception e2) {}
        } finally {
          try {in.close();} catch(Exception e) {}
          try {out.close();} catch(Exception e) {}
          try {socket.close();} catch(Exception e) {}
        }

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }

  } // main
}
