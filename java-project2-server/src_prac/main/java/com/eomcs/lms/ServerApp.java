// 3단계 : 클라이언트 요청에 응답하는 서버 프로그램으로 전환하기 
// 클라와 서버 사이의 통신 규칙
package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;

public class ServerApp {

  ArrayList<ApplicationContextListener> listeners= new ArrayList<>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  } // addApplicationContextListener()

  public void service() throws Exception {

    try (ServerSocket ss = new ServerSocket(8888) ){

      // App에서 사용할 객체를 보관하는 저장소
      HashMap<String, Object> context = new HashMap<String, Object>();

      // App을 시작할 때 등록된 Listener를 호출
      for(ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      } // for

      System.out.println("서버 실행중");

      while (true) {
        try (Socket socket = ss.accept(); 
            BufferedReader in = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream()) ){

          String request = in.readLine();

          if (request.equalsIgnoreCase("stop")) {
            System.out.println("종료합니다");
            break;
          }


          Command commandHandler = (Command) context.get(request);
          if (commandHandler == null) {
            out.println("실행할 수 없는 명령입니다.");
            out.println("!end!");
            out.flush();
            continue; 
          }

          commandHandler.execute(in, out);
          
          out.println("!end!");
          out.flush();

        } catch (Exception e) {
          System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        }// try(Socket)
      } // while

      for(ApplicationContextListener listener : listeners) {
        listener.contextDestroyed(context);
      } 

    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  } // service()

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    app.addApplicationContextListener(new ApplicationInitializer());
    app.service();

  } // main()

} // end of class
