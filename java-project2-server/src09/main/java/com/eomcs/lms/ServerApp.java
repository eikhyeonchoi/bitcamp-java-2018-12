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
  HashMap<String, Object> context = new HashMap<String, Object>();

  public void addApplicationContextListener(ApplicationContextListener listener) {
    listeners.add(listener);
  } // addApplicationContextListener()

  public void service() throws Exception {
    try (ServerSocket ss = new ServerSocket(8888) ){

      for(ApplicationContextListener listener : listeners) {
        listener.contextInitialized(context);
      } // for

      System.out.println("서버 실행중");

      while (true) {
        new RequestHandlerThread(ss.accept()).start();

      } // while

//      for(ApplicationContextListener listener : listeners) {
//        listener.contextDestroyed(context);
//      } 

    } catch (Exception e) {
      e.printStackTrace();
    } // try(ServerSocket)

  } // service()

  public static void main(String[] args) throws Exception {
    ServerApp app = new ServerApp();

    app.addApplicationContextListener(new ApplicationInitializer());
    app.service();

  } // main()

  class RequestHandlerThread extends Thread{
    Socket socket;

    public RequestHandlerThread(Socket socket) {
      this.socket = socket;
    }

    @Override
    public void run() {
      try (Socket socket = this.socket;
          BufferedReader in = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
          PrintWriter out = new PrintWriter(socket.getOutputStream()) ){

        String request = in.readLine();

        Command commandHandler = (Command) context.get(request);
        if (commandHandler == null) {
          out.println("실행할 수 없는 명령입니다.");
          out.println("!end!");
          out.flush();
          return;
        }

        commandHandler.execute(in, out);

        out.println("!end!");
        out.flush();

      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
      }// try(Socket)
    } // run
  }
} // end of class
