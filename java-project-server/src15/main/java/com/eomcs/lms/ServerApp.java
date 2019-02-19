// 14단계 DAO에 프록시 패턴 적용하기
package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

public class ServerApp {
  
  static BoardDaoImpl boardDao;
  static MemberDaoImpl memberDao;
  static LessonDaoImpl lessonDao;
  
  static HashMap<String, Service> serviceMap;
  static Set<String> serviceKeySet;

  ExecutorService executoreServcie = Executors.newCachedThreadPool();
  
  
  public static void main(String[] args) {
    try {
      boardDao = new BoardDaoImpl("board.bin");
      boardDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }
    try {
      memberDao = new MemberDaoImpl("member.bin");
      memberDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }
    try {
      lessonDao = new LessonDaoImpl("lesson.bin");
      lessonDao.loadData();
    } catch (Exception e) {
      System.out.println("게시물 데이터 로딩 중 오류 발생");
    }

    serviceMap = new HashMap<>();
    serviceMap.put("/board/", new BoardDaoSkel(boardDao));
    serviceMap.put("/member/", new MemberDaoSkel(memberDao));
    serviceMap.put("/lesson/", new LessonDaoSkel(lessonDao));

    serviceKeySet = serviceMap.keySet();
    
    try(ServerSocket serverSocket = new ServerSocket(8888); ){
      System.out.println("서버 시작!");

      while (true) {
        // 클라이언트 소켓을 꺼낸 후 스레드에게 전달한다
        // 그리고 스레드를 실행시킴
        // start()를 호출하면 스레드가 독립적으로 실행됨
        // 스레드의 run()메서드가 호출된다
        new RequestProcessThread(serverSocket.accept()).start();
        // 스레드를 시작시킨 후 즉시 return;
        // 스레드가 작업을 종료할 때 까지 기다리지않는다
        // 즉 비동기로 동작한다

      } // while
    } catch(Exception e) {
      e.printStackTrace();
    }

  } // main()
  
  
  
  static class RequestProcessThread extends Thread {
    
    Socket socket;
    
    public RequestProcessThread(Socket socket) {
      this.socket = socket;
      System.out.printf("[%s] 스레드가 생성됨\n", this.getName());
    } // con
    
    // 독립적으로 수행할 코드를 run()메서드에 작성
    @Override
    public void run() {
      try (Socket socket = this.socket; // 자동 close를 위해 
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){

        System.out.printf("[%s] 클라이언트 연결되었음.\n",this.getName());

        String request = in.readUTF();
        System.out.printf("[%s] %s\n",this.getName() ,request);
        
        
        Service service = getService(request);
        
        if(service == null) {
          out.writeUTF("FAIL");
          
        } else {
          service.execute(request, in, out);
        }
        
        out.flush();

        System.out.println("클라이언트와 연결을 끊었음.");
      } catch (Exception e) {
        e.printStackTrace();
      }
      System.out.printf("[%s] 클라이언트와 연결을 끊었음\n", this.getName());
    } // run()
    
    static Service getService(String request) {
      for (String key : serviceKeySet) {
        if(request.startsWith(key)) {
          return serviceMap.get(key);
        }
      } // for
      return null;
    } // getService()
    
  } // RequestProcessThread class


} // end of class














