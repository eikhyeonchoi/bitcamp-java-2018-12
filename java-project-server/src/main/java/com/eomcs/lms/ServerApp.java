// 14단계 DAO에 프록시 패턴 적용하기
package com.eomcs.lms;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;
import com.eomcs.lms.dao.BoardDaoImpl;
import com.eomcs.lms.dao.LessonDaoImpl;
import com.eomcs.lms.dao.MemberDaoImpl;
import com.eomcs.lms.service.BoardDaoSkel;
import com.eomcs.lms.service.LessonDaoSkel;
import com.eomcs.lms.service.MemberDaoSkel;
import com.eomcs.lms.service.Service;

// 멀티 스레드 적용
// ==> 클라이언트의 요청을 별로의 스레드에서 처리한다
// ==> 클라이언트에서 서버쪽에 DAO를 마치 직접 사용하는 것처럼 만들기
// ==> 작업절차
// 1) 클라이언의 요청작업을 처리하는 코드를 별도위 스레드 클래스로 분리한다
//     ==> 예) RequestProcessorThread 클래스정의
// 2) 클라이언트가 연결되었을 때 쓰레드에게 실행을 위임한다
// 

public class ServerApp {
  
  static BoardDaoImpl boardDao;
  static MemberDaoImpl memberDao;
  static LessonDaoImpl lessonDao;
  
  static HashMap<String, Service> serviceMap;
  static Set<String> serviceKeySet;
  
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
    } // con
    
    // 독립적으로 수행할 코드를 run()메서드에 작성
    @Override
    public void run() {
      try (Socket socket = this.socket; // 자동 close를 위해 
          ObjectInputStream in = new ObjectInputStream(socket.getInputStream()); 
          ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream()); ){

        System.out.println("클라이언트 연결되었음.");

        String request = in.readUTF();
        System.out.println(request);
        
        
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














