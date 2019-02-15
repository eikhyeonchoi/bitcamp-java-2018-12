package design_pattern.proxy.before2.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// 클라이언트의 요청을 실제 일을 하는 객체에게(Calculator class) 전달하고
// 객체(Calculator class)가 작업한 결과를 클라이언트에게 보내주는 일을 한다
// ==> 즉 객체(Calculator class)와 클라이언트간의 중계 역할을 수행한다
// ==> 이렇게 원격에서 객체를 사용할 수 있도록 중계인의 역할을 수행하는 객체를
// Object Request Broker(ORB) 라고한다
// ==> 객체가 있는 서버측에서 요청과 응답을 대행하는 ORB를 "스켈레톤(skeleton)"이라고 부른다
// ==> 객체를 사용하는 클라이언트 측에서 요청과 응답을 대행하는 ORB를 "스텁(stub)"이라고 부른다
public class CalculatorServer {
  public static void main(String[] args) {

    Calculator calc = new Calculator();

    try (ServerSocket serverSocket = new ServerSocket(8888);) {
      System.out.println("서버실행");
      
      while (true) {
        try (Socket socket = serverSocket.accept();
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());) {

          int a = in.readInt();
          int b = in.readInt();
          String op = in.readUTF();
          for (int i = 0; i < 0; i++) {

          }
          switch (op) {
            case "+":
              out.writeUTF("OK");
              out.writeInt(calc.plus(a, b));
              break;
            case "-":
              out.writeUTF("OK");
              out.writeInt(calc.minus(a, b));
              break;
            default:
              out.writeUTF("FAIL");
              out.writeUTF("해당 연산자를 지원하지 않습니다");
          }
          out.flush();

        } catch (Exception e) {
          System.out.println("클라처리중 오류발생");
        }

      } // while

    } catch (Exception e) {
      e.printStackTrace();
    }

  } // main()
} // end of class
