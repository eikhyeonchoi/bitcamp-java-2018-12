package com.eomcs.lms;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import com.eomcs.lms.context.ApplicationContextListener;
import com.eomcs.lms.handler.Command;
import com.eomcs.util.DataSource;

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
      // DB Connection을 빌려줄 커넥션풀을 꺼낸다
      DataSource dataSource = (DataSource) context.get("dataSource");

      // Connection pool에서 Connection객체 하나를 얻는다
      Connection con = dataSource.getConnection();


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

        try {
          commandHandler.execute(in, out);
          //l 클라이언트 요청을 처리한 후 Connection을 통해 작업한 것을 완료
          con.commit();
          System.out.println("DB Connection Commit !!!");
          
        } catch (Exception e) {
        //l 만약 클라이언트 요청을 처리하는 동안 예외가 발생하면 
          // Connection을 통해 수행했던 모든 데이터 변경작업을 취소한다
          try {
            con.rollback();
            System.out.println("DB Connection RollBack ...");
          } catch (SQLException e1) {}
          out.printf(String.format("실행 오류 : %s\n", e.getMessage()));
        }
        out.println("!end!");
        out.flush();
        
      } catch (Exception e) {
        System.out.println("명령어 실행 중 오류 발생 : " + e.toString());
        e.printStackTrace();
        
      } finally {
        // 클라이언트 요청을 모두 처리했으면 DB Connection 객체를 Connection pool에 반납
        // 커넥션 객체를 close() 하면 안된다, 다음에 다시 사용해야 하야해서
        dataSource.returnConnection(con);
        System.out.println("DB Connection을 Connection Pool에 반납 ...");
        
      } // try(Socket)
    } // run
  } // class


} // end of class
