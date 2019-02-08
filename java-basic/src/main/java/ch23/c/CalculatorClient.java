// 계산기 클라이언트 
package ch23.c;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*

// 계산기 클라이언트 
// : 최소 + - * / % 연산자는 지원한다r

/*
동작 방식 예제 ::
- 클라가 서버에 접속한 후 부터 시작 

(그대로 출력하도록 만들것, ""이 내가 입력하는 부분)
계산기 서버에 오신 것을 환영합니다!  <== 서버의 응답
계산식을 입력하세요!  <== 서버의 응답
예) 23 + 7   <== 서버의 응답
> "23 + 7"  <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다
결과는 30입니다  <== 서버의 응답
> "23 ^ 7"  <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다
^ 연산자를 지원하지 않습니다  <== 서버의 응답
> "ok + yes"  <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다
식의 형식이 잘못되었습니다  <== 서버의 응답
> "quit"  <== 사용자의 입력. '>' 문자는 클라이언트에서 출력한다
안녕히 가세요!  <== 서버의 응답
 */
*/
public class CalculatorClient {
  public static void main(String[] args) {

    try(Socket socket = new Socket("localhost",8542);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(
            socket.getInputStream());
        Scanner keyboard = new Scanner(System.in); ){
      System.out.println("client : 서버에 연결완료");

      System.out.println(in.readUTF());
      System.out.println(in.readUTF());
      System.out.println(in.readUTF());
      while (true) {
        System.out.print("> ");
        String oper = keyboard.nextLine();
        out.writeUTF(oper);
        out.flush();
        String result = in.readUTF();

        if(result.contains("안녕")) {
          System.out.println(result);
          break;
        } else {
          System.out.println(result);
        }

      }

    } catch (Exception e) {
      System.out.println();
    }
  }
}
