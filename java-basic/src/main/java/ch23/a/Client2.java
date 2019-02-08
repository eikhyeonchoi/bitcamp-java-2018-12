// 대기열 제한 확인하기
package ch23.a;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
  public static void main(String[] args) throws Exception{
    // 실행을 잠시 중단시키기 위해 사용
    Scanner keyboard = new Scanner(System.in);
    Socket socket = new Socket("localhost", 8888);
    System.out.println("client : server connected success ...");
    
    keyboard.nextLine();
    
    socket.close();
    System.out.println("client : server connected stopped ...");
    
    // 대기열의 크기에 따라 연결되는 클라이언트 수의 제한을 확인하기 위해
    // 여러 개의 클라이언트를 실행하라
    
    keyboard.close();
  }
}
